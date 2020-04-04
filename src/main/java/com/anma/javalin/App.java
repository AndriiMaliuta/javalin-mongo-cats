package com.anma.javalin;

import com.anma.javalin.controllers.CatController;
import com.anma.javalin.controllers.CatControllerImpl;
import com.anma.javalin.models.Cat;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {

        CatController catController = new CatControllerImpl();

        Javalin app = Javalin.create().start(7000);
        System.out.println("Running on port 7000");

//        app.get("/", ctx -> {
//            ctx.header("country", "Ukraine");
//            ctx.attribute("cat", new Cat(1L, "Murzik", 7, "white"));
//            ctx.render("templates/home.html");
//        });

//        app.get("/:name", ctx -> {
//            ctx.result("Hello " + ctx.pathParam("name"));
//        });

        app.routes(() -> {
            path("cats", () -> {
                get(catController::getAllCats);
            });
        });
    }
}
