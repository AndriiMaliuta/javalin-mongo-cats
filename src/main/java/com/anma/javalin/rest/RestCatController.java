package com.anma.javalin.rest;

import com.anma.javalin.models.Cat;
import com.anma.javalin.repositories.CatRepository;
import com.anma.javalin.repositories.CatRepositoryImpl;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RestCatController {

    CatRepository catRepository = new CatRepositoryImpl();

    public Context getAllCatsREST(@NotNull Context ctx) {
        return ctx.json(catRepository.findAllCats());
    }

    public void createCatsREST(@NotNull Context ctx) {
        Cat cat = ctx.bodyAsClass(Cat.class);
        ctx.status(201);
        catRepository.createCat(cat);
    }
}
