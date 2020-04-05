package com.anma.javalin.controllers;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class HomeController {

    public void getHomePage(@NotNull Context ctx) {
        ctx.render("templates/home.html");
    }
}
