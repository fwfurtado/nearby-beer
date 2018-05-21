package com.github.fehwilinando.nearbybeer.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class POSQuery {

    private final JsonNode query;


    POSQuery(JsonReader reader) throws IOException {
        Resource resource = new FileSystemResource("src/test/resources/graphql/input/queries/pos.json");

        query = reader.readResource(resource);
    }


    public JsonNode setId(Long id){
        ((ObjectNode) query.get("variables")).put("id", id);

        return query;
    }
}
