package ru.netology.deliverycardpatterns.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {

        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Абакан", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
                "Нижний Новгород", "Челябинск", "Самара", "Уфа", "Ростов-на-Дону", "Омск", "Красноярск", "Краснодар",
                "Воронеж", "Пермь", "Волгоград", "Саратов", "Тюмень", "Тольятти", "Барнаул", "Ижевск", "Махачкала",
                "Хабаровск", "Ульяновск", "Иркутск", "Владивосток", "Ярославль", "Кемерово", "Томск", "Волжский",
                "Севастополь", "Ставрополь", "Оренбург", "Новокузнецк", "Рязань", "Пенза", "Чебоксары", "Липецк",
                "Калининград", "Астрахань", "Тула", "Киров", "Сочи", "Курск", "Улан-Удэ", "Тверь", "Магнитогорск",
                "Сургут", "Брянск", "Иваново", "Якутск", "Владимир", "Симферополь", "Белгород", "Нижний Тагил",
                "Калуга", "Чита", "Грозный", "Смоленск", "Саранск", "Вологда", "Курган", "Череповец",
                "Орёл", "Архангельск", "Владикавказ", "Йошкар-Ола", "Мурманск", "Кострома", "Псков",
                "Новороссийск", "Тамбов", "Нальчик", "Таганрог", "Нижнекамск", "Благовещенск",
                "Комсомольск-на-Амуре", "Петрозаводск"};

        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + "" + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}