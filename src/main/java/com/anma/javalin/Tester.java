package com.anma.javalin;

import com.anma.javalin.models.Cat;
import com.anma.javalin.mongo.MongoConfig;
import org.bson.types.ObjectId;

public class Tester {

    public static void main(String[] args) {
//        MongoConfig.createCat(new Cat("Murzik", 6, "white"));
//        System.out.println(MongoConfig.getCatByName("Murzik"));
        System.out.println(MongoConfig.getAllCats().size());
        System.out.println(MongoConfig.getCollection().countDocuments());
    }
}
