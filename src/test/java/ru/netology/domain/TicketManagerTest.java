package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 300, "DME", "NQ", 111);
    Ticket ticket2 = new Ticket(2, 200, "DME", "NQZ", 121);
    Ticket ticket3 = new Ticket(3, 200, "ME", "NQZ", 222);
    Ticket ticket4 = new Ticket(4, 500, "DME", "NQZ", 212);
    Ticket ticket5 = new Ticket(5, 200, "DME", "NQZ", 0);
    Ticket ticket6 = new Ticket(6, 500, "", "", -1);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void should() {
        Ticket[] expected = {ticket2, ticket5, ticket4};
        Ticket[] actual = manager.findAll("DME", "NQZ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNot() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DME", "sdf");

        Assertions.assertArrayEquals(expected, actual);
    }
}
