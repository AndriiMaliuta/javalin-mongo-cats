package com.anma.javalin.repositories;

import com.anma.javalin.models.Cat;

import java.util.List;

public interface CatRepository {

    void createCat(Cat cat);

    Cat findCatByName(String name);

    List<Cat> findAllCats();

    Cat updateCat(Cat cat, String id);

    void deleteCatById(String id);
}
