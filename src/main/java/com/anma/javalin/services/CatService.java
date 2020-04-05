//package com.anma.javalin.services;
//
//import com.anma.javalin.models.Cat;
//import com.anma.javalin.mongo.MongoConfig;
//
//import java.util.*;
//
//public class CatService {
//
//    private static Map<Integer, Cat> cats = new HashMap<>();
//
//    static {
////        cats.put(1, new Cat(UUID.randomUUID().toString(), "Murzik", 7, "white"));
////        cats.put(2, new Cat(UUID.randomUUID().toString(), "Pukh", 5, "white and gray"));
//    }
//
//    public static Collection<Cat> getCats() {
//        return MongoConfig.getAllCats();
//    }
//
//    public static Cat getCatById(String id) {
//        for (Cat cat : MongoConfig.getAllCats()) {
//            if (cat.getId().equals(id)) return cat;
//        }
//        return new Cat(UUID.randomUUID().toString(), "No such cat", 0, "no such cat");
//    }
//
//    public void createCat() {
//        MongoConfig.createCat();
//    }
//
//
//}
