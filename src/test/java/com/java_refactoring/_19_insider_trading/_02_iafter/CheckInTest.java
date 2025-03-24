package com.java_refactoring._19_insider_trading._02_iafter;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CheckInTest {

    @Test
    void isFastPass() {
        CheckIn checkIn = new CheckIn(new Ticket(LocalDate.of(2021,12,31),true));
        assertTrue(checkIn.getTicket().isFastPass(new Ticket(LocalDate.of(2021,12,31),true)));

        CheckIn checkIn2 = new CheckIn(new Ticket(LocalDate.of(2021,12,31),true));
        assertFalse(checkIn2.getTicket().isFastPass(new Ticket(LocalDate.of(2022,1,2),false)));
    }
}