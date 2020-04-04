package com.anma.javalin.controllers;

import com.anma.javalin.models.Cat;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class CatControllerImpl implements CatController{

    @Override
    public void getAllCats(@NotNull Context ctx) {
        ctx.attribute("cat", new Cat(1L, "Murzik", 7, "white"));
        ctx.render("templates/home.html");
    }

}
