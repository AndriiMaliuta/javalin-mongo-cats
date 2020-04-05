package com.anma.javalin;

import com.anma.javalin.models.Cat;
import com.anma.javalin.mongo.MongoConfig;
import org.bson.types.ObjectId;

public class Tester {

    public static void main(String[] args) {
//        MongoConfig.createCat(new Cat("Bagira", 7, "black"));
//        System.out.println(MongoConfig.getCatByName("Murzik").getName());
//        System.out.println(MongoConfig.getAllCats().size());
//        System.out.println(MongoConfig.getCollection().countDocuments());
        MongoConfig.getAllCats().forEach(cat -> System.out.println(cat.getName()));
    }
}
