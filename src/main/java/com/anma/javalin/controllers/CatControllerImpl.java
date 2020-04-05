package com.anma.javalin.controllers;

import com.anma.javalin.models.Cat;
import com.anma.javalin.repositories.CatRepository;
import com.anma.javalin.repositories.CatRepositoryImpl;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class CatControllerImpl implements CatController {

    CatRepository catRepository = new CatRepositoryImpl();

    @Override
    public void getAllCats(@NotNull Context ctx) {
        ctx.attribute("cats", catRepository.findAllCats());
        ctx.render("templates/cats.html");
    }

    @Override
    public void getCatById(@NotNull Context ctx) {
        String name = ctx.pathParam("name");
        ctx.attribute("cat", catRepository.findCatByName(name));
        ctx.render("templates/cat.html");
    }

    @Override
    public void createCat(@NotNull Context ctx) {
        Cat cat = ctx.bodyAsClass(Cat.class);
        catRepository.createCat(cat);
        System.out.println("********* Cat created");
    }

}
