package com.anma.javalin.repositories;

import com.anma.javalin.models.Cat;
import com.anma.javalin.mongo.MongoConfig;

import java.util.List;

public class CatRepositoryImpl implements CatRepository {

    @Override
    public void createCat(Cat cat) {
        MongoConfig.createCat(cat);
    }

    @Override
    public Cat findCatByName(String name) {
        return MongoConfig.getCatByName(name);
    }

    @Override
    public List<Cat> findAllCats() {
        return MongoConfig.getAllCats();
    }

    @Override
    public Cat updateCat(Cat cat, String id) {
        return MongoConfig.updateCat(cat);
    }

    @Override
    public void deleteCatById(String id) {
        MongoConfig.deleteCat(id);
    }
}
