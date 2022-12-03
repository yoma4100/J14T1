package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.Ticket;


public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 300, "DME", "NQ", 111);
    Ticket ticket2 = new Ticket(2, 200, "DME", "NQZ", 121);
    Ticket ticket3 = new Ticket(3, 200, "ME", "NQZ", 222);
    Ticket ticket4 = new Ticket(4, 500, "DME", "NQZ", 212);
    Ticket ticket5 = new Ticket(5, 200, "DME", "NQZ", 0);
    Ticket ticket6 = new Ticket(6, 500, "", "", -1);

    @BeforeEach
    public void setUp() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
    }

    @Test
    public void shouldRemoveOneCell() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket6};

        repo.removeById(5);

        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
