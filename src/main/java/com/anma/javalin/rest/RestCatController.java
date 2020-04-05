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

    public Context createCatsREST(@NotNull Context ctx) {
        System.out.println("******** Executing POST inside REST createCatsREST method");
        Cat cat = ctx.bodyAsClass(Cat.class);
        System.out.println(cat);
        ctx.status(201);
        catRepository.createCat(cat);
        return ctx.json(cat);
    }
}
