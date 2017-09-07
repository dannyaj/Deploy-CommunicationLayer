package Adapter.MongoDB;

/*
    This class implemented a singleton db adapter for MongoDB
    Methods:
        add - add a new item to a collection
        query - find out all matched items from a collection
        update - update a item to a collection
 */

import com.mongodb.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class MongoDB {

    private static Logger logger = Logger.getRootLogger();

    private Mongo mongoClient;
    private DB mongoDatabase;
    private String moduleName;
    private static MongoDB mongoDB;

    // constructor, get all of arguments and init a connection
    public MongoDB(String[] args) {

        this.moduleName = this.getClass().getName();
        ArgsParser parser = new ArgsParser(args);

        try{
            this.mongoClient = new Mongo( parser.getIP(), parser.getPort() );
            this.mongoDatabase = mongoClient.getDB(parser.getDB());

            logger.info(this.moduleName + " - Connection to MongoDB Successfully");

        }catch(Exception e){

            logger.fatal(e.getClass().getName() + " - " + e.getMessage());

            e.printStackTrace();
            System.exit(-1);
        }
    }

    // singleton function
    public static void init(String[] args) {
        mongoDB = new MongoDB(args);
    }

    // singleton function
    public static MongoDB getMongoDB() {
        return mongoDB;
    }

    // create a new item
    public boolean add(String collectionName, String jsonString) {

        logger.info("MongoDB - Add to " + collectionName + " - " + jsonString);

        try{
            // get collection
            DBCollection collection = mongoDatabase.getCollection(collectionName);

            // transfer json string to a DB object
            Object obj = com.mongodb.util.JSON.parse(jsonString);
            DBObject dbObj = (DBObject) obj;

            // add to a collection
            collection.insert(dbObj);
        }catch(Exception e){

            logger.fatal( this.moduleName + " - " + e.getMessage() );

            e.printStackTrace();
            return false;
        }
        return true;
    }

    // query and get list
    public ArrayList<Object> query(String collectionName, String key, String value) {

        logger.info("MongoDB - Query to " + collectionName + " - " + key + " - " + value);

        try {
            // get collection
            DBCollection collection = mongoDatabase.getCollection(collectionName);

            // construct a query object
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put(key, value);

            // get matcheed items
            DBCursor cursor = collection.find(whereQuery);
            ArrayList<Object> output = new ArrayList<Object>();
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                logger.info(this.moduleName + " - " + obj.toString());
                output.add((Object) obj);
            }

            return output;
        } catch (Exception e) {
            logger.fatal(this.moduleName + " - " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // update a exist item
    public boolean update(String collectionName, String key, String value, String jsonString) {

        logger.info("MongoDB - Update to " + collectionName + " - " + jsonString);

        try{
            // get collection
            DBCollection collection = mongoDatabase.getCollection(collectionName);

            // make a search object
            BasicDBObject searchQuery = new BasicDBObject().append(key, value);

            // make a save object
            Object obj = com.mongodb.util.JSON.parse(jsonString);
            DBObject dbObj = (DBObject) obj;

            // update to a collection
            collection.update(searchQuery, dbObj);
        }catch(Exception e){
            logger.fatal( this.moduleName + " - " + e.getMessage() );
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
