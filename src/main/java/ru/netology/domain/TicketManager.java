package ru.netology.domain;

import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;
    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        // определяем размера массива tmp
        int size = 0;
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getDepartureAirport().equals(from) && ticket.getArrivalAirport().equals(to)) {
                size++;
            }
        }

        Ticket[] result = new Ticket[0];
        Ticket[] tmp = new Ticket[size];
        int copyToIndex = 0;

        // сохраняем элементы подходящие по критерия в  массив tmp
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getDepartureAirport().equals(from) && ticket.getArrivalAirport().equals(to)) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        // проверяем, что если совпадений в поиске не было возвращаем пустой массив, не выполняя сортировки
        if (size != 0) {
            result = tmp;
            Arrays.sort(result);
        }
        return result;
    }
}
