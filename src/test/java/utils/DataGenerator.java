package utils;

import com.github.javafaker.Faker;

import java.util.*;

import static utils.Constant.*;

public class DataGenerator {
    Faker faker = new Faker(new Locale("en-US"));
    Random random = new Random();

    private int getRandom(int max) {
        Random random = new Random();
        return random.nextInt(max + 1);
    }

    public String setFirstName () {
         return faker.name().firstName();
    }

    public String setLastName () {
        return faker.name().lastName();
    }

    public String setUserEmail () {
        return faker.internet().emailAddress();
    }

    public String setAddress () {
        return faker.address().fullAddress();
    }

    public String setNumber () {

        long min = 1_000_000_000L;
        long max = 9_999_999_999L;
        long phoneNumber = min + (long) (random.nextDouble() * (max - min + 1));

        return String.valueOf(phoneNumber);
    }

    public String setGender () {
        return genders.get(genders.size()-1);
    }

    public String dayNumber () {
        return  String.valueOf(getRandom(27));
    }

    public String month () {
        return MONTHS.get(getRandom(12));
    }

    public String year (int minYear, int maxYear) {
        return String.valueOf(random.nextInt(maxYear - minYear + 1) + minYear);
    }

    public int stateNumber () {
        return getRandom(DISTRICT_NUMBERS.size()-1);
    }

    public int cityNumber () {
        return getRandom(CITY_NUMBERS.size()-1);
    }
}
