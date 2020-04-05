package com.anma.javalin;

import com.anma.javalin.controllers.CatController;
import com.anma.javalin.controllers.CatControllerImpl;
import com.anma.javalin.controllers.HomeController;
import com.anma.javalin.rest.RestCatController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {

        CatController catController = new CatControllerImpl();
        HomeController homeController = new HomeController();
        RestCatController restCatController = new RestCatController();

        Javalin app = Javalin.create().start(7000);
        System.out.println("Running on port 7000");

        app.routes(() -> {
            path("", () -> {
                get(homeController::getHomePage);
            });
            path("cats", () -> {
                get(catController::getAllCats);
                post(catController::createCat);
                path(":id", () -> {
                    get(catController::getCatById);
                });
            });
            path("rest/cats", () -> {
                get(restCatController::getAllCatsREST);
                post(restCatController::createCatsREST);
            });
        });
    }
}
