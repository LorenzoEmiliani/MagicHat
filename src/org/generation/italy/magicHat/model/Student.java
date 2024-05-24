package org.generation.italy.magicHat.model;

import java.util.Random;

public class Student {
    private String name;
    private String lastname;
    private House favouriteHouse;
    private Random random;
    
    public Student(String name, String lastname, House favouriteHouse) {
        this.name = name;
        this.lastname = lastname;
        this.favouriteHouse = favouriteHouse;
        this.random = new Random();
    }

    public Student(String name, String lastname) {
        this(name, lastname, null);
    }

    public String getFullName() {
        return String.format("%s %s", name, lastname);
    }

    public boolean hasFavourite () {
        return favouriteHouse != null;
    }

    public House getFavouriteHouse () {
        return favouriteHouse;
    }

    public boolean isLucky() {
        return random.nextInt(2) == 0;
    }

}
