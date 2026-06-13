package com.almashines.utils;

import java.util.UUID;

public class TestDataGenerator {

    private TestDataGenerator() {
        // Prevent instantiation
    }

    public static String generateEmail() {

        return "user"
                + UUID.randomUUID().toString().substring(0, 8)
                + "@gmail.com";
    }

    public static String generateFirstName() {

        return "User"
                + UUID.randomUUID().toString().substring(0, 4);
    }

    public static String generateLastName() {

        return "Test"
                + UUID.randomUUID().toString().substring(0, 4);
    }

    public static String generatePassword() {

        return "Ts@"
                + UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .substring(0, 6);
    }
}
