package com.irfanhkm.controller.backoffice;

import com.google.gson.Gson;
import com.irfanhkm.service.MovieService;

import javax.inject.Inject;

import static spark.Spark.*;

public class MovieController {

    @Inject
    private MovieService movieService;

    public void routes()
    {
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
                    System.out.println(movieService.getAll());
                    return new Gson()
                            .toJson(null);
                });
            });
        });
    }
}
