package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Franchises associated with the Company
 */
public class Franchise {
	/**
	 * Id of the franchise
	 */
    private int ID;
    /**
     * list of services associated with a franchise
     */
    private List<Service> services = new ArrayList<Service>();
    /**
     * Customers of the franchise
     */
    private List<Customer> customers = new ArrayList<Customer>();


    public int getID() {
        return ID;
    }

    public void setID(int number) {
        this.ID = number;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Customer> getCustomer() {
        return customers;
    }

    public void setCustomer(List<Customer> customers) {
        this.customers = customers;
    }


}
