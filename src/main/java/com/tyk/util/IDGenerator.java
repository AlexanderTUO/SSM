package com.tyk.util;

import java.util.UUID;

public class IDGenerator {
    public static String nextId() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }
}
