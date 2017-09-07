package Tool;

import org.json.JSONObject;

public class JSONTool {

    public static String getValueFromString(String jsonString, String key){
        /*
            Get Value From JSON String
            Example
                jsonString = '{"example": "value"}'

                key = "example"
                return value

                key = "test"
                return ""
         */

        try {
            JSONObject jsonObject = JSONTool.loadToJSONObject(jsonString);
            return jsonObject.getString(key);
        } catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String addKeyValueToString(String jsonString, String key, String value) {
        /*
            Add a new key and value to json string
            Example
                jsonString = '{"old": "old-data"}'
                key = "test"
                value = "info

                return '{"old": "old-data", "test": "info"}'
         */
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString.toString());
            jsonObject.put(key, value);
            return jsonObject.toString();
        } catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static JSONObject loadToJSONObject(String jsonString) {
        /*
            Load JSON String to a JSONObject
            Example
                jsonString = '{"example": "value"}'
                return JSONObject
         */

        try {
            return new JSONObject(jsonString.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }
}
