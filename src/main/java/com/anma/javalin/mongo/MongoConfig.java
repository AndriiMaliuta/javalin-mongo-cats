package com.anma.javalin.mongo;

import com.anma.javalin.models.Cat;
import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class MongoConfig {

    private static MongoClient client;
    private static MongoDatabase database;
    private static MongoCollection<Cat> collection;

    static {
        client = MongoClients.create();
        database = client.getDatabase("cats");
        collection = database.getCollection("cats", Cat.class);
        System.out.println("********* Mongo initiated");
    }

    public static MongoCollection<Cat> getCollection() {
        return collection;
    }

    public static void createCat(Cat cat) {
        collection.insertOne(cat);
        System.out.println("*********** Cat created with name " + cat.getName());
    }

    public static List<Cat> getAllCats() {

        System.out.println("********** Getting cats");

        List<Cat> cats = new ArrayList<>();
        MongoCursor<Cat> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
                cats.add(cursor.next());
            }
        } finally {
            cursor.close();
        }

        return cats;
    }

    public static Cat getCatByName(String name) {
        return collection.find(eq("name", name)).first();
    }

    public static Cat updateCat(Cat cat) {
        collection.updateOne(eq("_id", cat.getId()), set("name", cat.getName()));
        return cat;
    }

    public static void deleteCat(String id) {
        collection.deleteOne(eq("_id", id));
    }

}
