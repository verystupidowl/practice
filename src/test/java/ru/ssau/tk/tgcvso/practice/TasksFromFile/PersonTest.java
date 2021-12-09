package ru.ssau.tk.tgcvso.practice.TasksFromFile;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PersonTest {
    @Test
    public void test() {
        Person AlexeyMaklov = new Person();
        Person KirillKrylov = new Person();
        AlexeyMaklov.setPassportId(4235);
        AlexeyMaklov.setFirstName("Alexey");
        AlexeyMaklov.setLastName("Maklov");
        assertEquals(AlexeyMaklov.getPassportId(), 4235);
        assertEquals(AlexeyMaklov.getFirstName(), "Alexey");
        assertEquals(AlexeyMaklov.getLastName(), "Maklov");
        KirillKrylov.setPassportId(626);
        KirillKrylov.setFirstName("Kirill");
        KirillKrylov.setLastName("Krylov");
        assertEquals(KirillKrylov.getPassportId(), 626);
        assertEquals(KirillKrylov.getFirstName(), "Kirill");
        assertEquals(KirillKrylov.getLastName(), "Krylov");
    }
}