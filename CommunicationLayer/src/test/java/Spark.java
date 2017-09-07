import static spark.Spark.*;

public class Spark {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}