package org.generation.italy.magicHat.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.generation.italy.magicHat.model.House.*;

public class HouseAssignementCerimony {
    private MagicHat hat = new MagicHat();
    private ArrayList<Student> students = new ArrayList<>(Arrays.asList(
        new Student("Alessandro", "Rovito", GRYFFINDOR),
        new Student("Riccardo", "Girotto", GRYFFINDOR),
        new Student("Alessio", "Rongione", RAVENCLAW),
        new Student("Roberto", "Pantoni"),
        new Student("Francesco", "Aversali"),
        new Student("Vito", "Chianese", RAVENCLAW),
        new Student("Giulia", "Saporiti", SLYTHERIN),
        new Student("Lorenzo", "Murra"),
        new Student("Luca", "Mazzone", RAVENCLAW),
        new Student("Christian", "Soru"),
        new Student("Lorenzo", "Emiliani", GRYFFINDOR),
        new Student("Sonia", "Mammone", HUFFLEPUFF),
        new Student("Manuel", "Trenta", GRYFFINDOR),
        new Student("Breno", "Scudo"),
        new Student("Jessica", "Cardinali"),
        new Student("Alessandra", "Bavastrelli", HUFFLEPUFF),
        new Student("Giovanni", "Minoliti"),
        new Student("Enrico", "Ranieri", RAVENCLAW),
        new Student("Paolo", "Morello"),
        new Student("Lorenzo", "Tirotta"),
        new Student("Lorenzo", "Fioravanti", SLYTHERIN),
        new Student("Alberto", "Pelagotti", SLYTHERIN),
        new Student("Michele", "Coppi"),
        new Student("Francesca", "Piccitto"),
        new Student("Stanislao", "Tariffa", HUFFLEPUFF)
    ));
    private final int NUM_HOUSES = House.values().length;
    private final int NUM_STANDARD = students.size()/NUM_HOUSES*NUM_HOUSES;
    private final int STANDARD_SIZE = students.size()/NUM_HOUSES;

    public void start() {
        Collections.shuffle(students);
        House.assignSize(STANDARD_SIZE);
        for(int i = 0; i < NUM_STANDARD; i++) {
            var house = hat.assignStudent(students.get(i));
            makeAnnouncement(house, students.get(i));
        }
        House.assignSize(STANDARD_SIZE + 1);
        for(int i = NUM_STANDARD; i < students.size(); i++) {
            var house = hat.assignStudent(students.get(i));
            makeAnnouncement(house, students.get(i));
        }
        reportAssignements();
    }

    private void makeAnnouncement(House house, Student s) {
        if(house == s.getFavouriteHouse()) {
            hat.announceAssignement(s);
            System.out.println();
        } else {
            hat.announceAssignement(s, house);
            System.out.println();
        }
    }

    public void reportAssignements() {
        for(int i = 0; i < House.values().length; i++) {
            System.out.printf("%-30s", House.values()[i]);
        }
        System.out.println();
        for(int i = 0; i < STANDARD_SIZE + 1; i++) {
            for(int j = 0; j < NUM_HOUSES; j++) {
                System.out.printf("%-30s", House.values()[j].getStudentName(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HouseAssignementCerimony cerimony = new HouseAssignementCerimony();
        cerimony.start();
    }
}
