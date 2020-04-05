package com.anma.javalin.mongo;

import com.anma.javalin.models.Cat;
import com.anma.javalin.services.POJOconverterService;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class MongoConfig {

    private static MongoClient client;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    static {
        client = MongoClients.create();
        database = client.getDatabase("cats");
        collection = database.getCollection("cats");
        System.out.println("********* Mongo initiated");
    }

    public static MongoCollection<Document> getCollection() {
        return collection;
    }

    public static void createCat(Cat cat) {
        collection.insertOne(POJOconverterService.catToDoc(cat));
        System.out.println("*********** Cat created with name " + cat.getName());
    }

    public static List<Cat> getAllCats() {

        System.out.println("********** Getting cats");

        List<Cat> cats = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
                cats.add(POJOconverterService.docToCat(cursor.next()));
            }
        } finally {
            cursor.close();
        }

        return cats;
    }

    public static Cat getCatByName(String name) {
        return POJOconverterService.docToCat(Objects.requireNonNull(collection.find(eq("name", name)).first()));
    }

    public static Cat updateCat(Cat cat) {
        collection.updateOne(eq("_id", cat.getId()), set("name", cat.getName()));
        return cat;
    }

    public static void deleteCat(String id) {
        collection.deleteOne(eq("_id", id));
    }

}
