package ru.netology;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int flightTime;

    public Ticket(int id, int cost, String departureAirport, String arrivalAirport, int flightTime) {
        this.id = id;
        this.cost = cost;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.getCost()) {
            return -1;
        } else if (this.cost > o.getCost()) {
            return 1;
        } else {
            return 0;
        }
    }
}
