package org.example.util;

import java.util.UUID;

public class RandomDataUtil {
    public static String getRandomString(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
    public static String getRandomFirstName() {
        return "User" + getRandomString(5);
    }
    public static String getRandomLastName() {
        return "Test" + getRandomString(5);
    }
    public static String getRandomZipCode() {
        return "Zip" + getRandomString(4);
    }
}
