package com.anma.javalin.services;

import com.anma.javalin.models.Cat;

import java.util.HashMap;
import java.util.Map;

public class CatService {

    private static Map<Integer, Cat> cats = new HashMap<>();

    static {
        cats.put(1, new Cat(1L, "Murzik", 7, "white"));
        cats.put(2, new Cat(2L, "Pukh", 5, "white and gray"));
    }

    public static Map<Integer, Cat> getCats() {
        return cats;
    }

    public static Cat getCatById(int id) {
        for (Cat cat : cats.values()) {
            if (cat.getId() == id) return cat;
        }
        return new Cat(100, "test", 1, "test");
    }


}
