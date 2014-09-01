package com.dzhao.simplecms.server.repository.database.model.util;

import java.util.UUID;

/**
 * A id generator class to generate an universal unique object ID.
 */
public class IdGenerator {
    private IdGenerator(){}

    public static String generateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
