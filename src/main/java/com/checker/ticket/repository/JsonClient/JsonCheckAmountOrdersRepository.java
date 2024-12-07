package com.checker.ticket.repository.JsonClient;

import com.checker.ticket.repository.protocols.CheckAmountOrdersRepository;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Repository;

import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository("json-orders-repository")
public class JsonCheckAmountOrdersRepository implements CheckAmountOrdersRepository{
    private static final String JSON_FILE_PATH = "public/clients.json";

    @Override
    public int getAmountOrdersByClientId(int clientId) throws IOException{
        String json = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
        JsonObject clientObject = JsonParser.parseString(json).getAsJsonObject();
        int numExchanges = clientObject.get("orders").getAsInt();
        return numExchanges;
    }
}
