package org.generation.italy.magicHat.model;

import java.util.Random;

public class MagicHat {
    private Random random = new Random();

    public House assignStudent(Student s) {
        if(s.hasFavourite() && s.isLucky() && s.getFavouriteHouse().addStudent(s)) {
           return s.getFavouriteHouse();
        }
        boolean assigned;
        House randomHouse;
        do {
            randomHouse = House.getRandomHouse();
            assigned = randomHouse.addStudent(s);
        } while(!assigned);
        return randomHouse;
    }

    public void announceAssignement(Student s, House randomHouse) {
        System.out.printf("%s...", s.getFullName());
        generateSuspance();
        System.out.printf("E' stato inserito nella casa %s", randomHouse);  
    }

    public void announceAssignement(Student s) {
        System.out.printf("%s...", s.getFullName());
        generateSuspance();
        System.out.printf("Fortunello! E' stato inserito nella sua casa preferita %s", s.getFavouriteHouse());
    }

    private void generateSuspance() {
        int millis = random.nextInt(2000, 4000);
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            //will never execute
        }
    }

}
