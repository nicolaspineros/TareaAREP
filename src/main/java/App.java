import entity.Message;
import service.MessageService;
import service.impl.MessageServiceImpl;

import org.json.JSONObject;

import static spark.Spark.*;

public class App {

    private static MessageService service = new MessageServiceImpl();

    public static void main(String... args){
        port(getPort());
        //get("hello", (req,res) -> "Hello Docker!");
        path("/message", () ->{
            post("/add",(req, res) -> {
                //res.type("application/json");
                JSONObject jsonObject = new JSONObject(req.body());
                Message message = new Message(req.queryParams("message"));
                service.addMessage(message);
            });
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
