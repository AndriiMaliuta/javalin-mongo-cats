package com.anma.javalin.services;

import com.anma.javalin.models.Cat;
import com.anma.javalin.models.CatDTO;
import org.bson.Document;
import org.bson.types.ObjectId;

public class POJOconverterService {

    public static Cat docToCat(Document document) {

        return new Cat(
                (ObjectId) document.get("_id"),
                (String) document.get("name"),
                (int) document.get("age"),
                (String) document.get("color")
        );
    }

    public static Document catToDoc(Cat cat) {

        return new Document("name", cat.getName())
                .append(("age"), cat.getAge())
                .append("color", cat.getColor()
                );
    }

}
