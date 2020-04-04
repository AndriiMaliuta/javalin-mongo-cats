package com.anma.javalin.controllers;

import com.anma.javalin.models.Cat;
import com.anma.javalin.services.CatService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class CatControllerImpl implements CatController{

    @Override
    public void getAllCats(@NotNull Context ctx) {
        ctx.attribute("cat", new Cat(1L, "Murzik", 7, "white"));
        ctx.render("templates/home.html");
    }

    @Override
    public void getCatById(@NotNull Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ctx.attribute("cat", CatService.getCatById(id));
        ctx.render("templates/cat.html");
    }

}
