package ibf2022.assessment.paf.batch3.models;

import java.time.LocalDate;

public class Order {
    private int orderId;
	private LocalDate date;
	private String breweryId;

    public Order() {
    }

    public Order(int orderId, LocalDate date, String breweryId) {
        this.orderId = orderId;
        this.date = date;
        this.breweryId = breweryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(String breweryId) {
        this.breweryId = breweryId;
    }

    public <List> void orderList(){
        
    }


    
}


