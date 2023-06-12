package com.demoqa.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomGender());
    }
    public static String getRandomString(int len){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();

    }

    public static String getRandomEmail(){
return getRandomString(10)+"@qa.guru";
    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max +1);
    }
    public static String getRandomGender(){
       String[] genders ={"Male", "Female", "Other"};
       return getRandomItemFromArray(genders);
    }

    private static String getRandomItemFromArray(String[]values){
int index = getRandomInt (0, values.length -1);
        return values[index];
    }
}
