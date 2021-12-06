package route;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import dao.MovieSpec;

import static spark.Spark.*;

public class BackofficeRouteMain {
    static class Result {
        @SerializedName("account_num")
        public String accountnumStr;

        @SerializedName("name")
        public String nameStr;
    }

    public static void main(String[] args) {
        after((req, res) -> {
            res.type("application/json");
        });

        get("/hello", (req, res) -> "Hello World");
        path("/api/v1/backoffice", () -> {
            before("/*", (q, a) -> System.out.println("Received API Call"));
            path("/movies", () -> {
                get("", (req, res) -> "Hello World");
                put("/:id",       (q, a) -> {
                    System.out.print("Received movie PUT" + a);
                    System.out.print("Received movie PUT" + q);
                    return true;
                });
                post("/schedule",       (q, a) -> {
                    System.out.print("Received movie schedlue post" + a);
                    System.out.print("Received movie schedlue post" + q);
                    return true;
                });
            });
            path("/tags", () -> {
                get("",  (q, a) -> {
                    MovieSpec movieSpec = new MovieSpec();
                    System.out.println(movieSpec.getAll());
                    return new Gson()
                            .toJson(null);
                });
            });
        });
    }
}
