package com.javathought.product.catalog;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;

public class Util {
    private Util(){
        //can not create out side of it
    }
    public static String getRandomString(){
        return UUID.randomUUID().toString();
    }
}
