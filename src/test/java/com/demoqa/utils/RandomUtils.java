package com.demoqa.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import com.github.javafaker.*;

public class RandomUtils {
    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomGender());
        System.out.println(getRandomPhone());
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
    public static String getRandomPhone(){
          return String.format("%s%s%s%s%s", getRandomInt(1, 9),getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomDay() {
        return String.valueOf(getRandomInt(10, 28));
    }
    public static String getRandomMonth(){
        String[] months ={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(months);
    }
    public static String getRandomYear() {
        return String.valueOf(getRandomInt(1953, 2002));
    }
    public static String getRandomSubject(){
        String[] subjects ={"Hindi", "History", "Computer Science", "Commerce", "Maths", "Accounting", "English", "Physics", "Chemistry", "Civics", "Social Studies", "Biology"};
        return getRandomItemFromArray(subjects);
    }
    public static String getRandomHobbie(){
        String[] hobbies ={"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            String[] city = {"Delhi", "Gurgaon", "Noida"};
            return faker.options().option(city);
        } else if (state.equals("Uttar Pradesh")) {
            String[] city = {"Agra", "Lucknow", "Merrut"};
            return faker.options().option(city);
        } else if (state.equals("Haryana")) {
            String[] city = {"Karnal", "Panipat"};
            return faker.options().option(city);
        } else if (state.equals("Rajasthan")) {
            String[] city = {"Jaipur", "Jaiselmer"};
            return faker.options().option(city);
        }
        return null;
    }

}
