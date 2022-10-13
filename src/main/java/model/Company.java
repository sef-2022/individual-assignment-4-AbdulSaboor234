package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Company having franchises
 */
public class Company {
	/**
	 * name of the department
	 */
    private String name;
    /**
     * list of franchises associated with the company
     */
    private List<Franchise> franchises = new ArrayList<Franchise>();
    /**
     * list of services associated with the company
     */
    private List<Service> services = new ArrayList<Service>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Franchise> getfranchises() {
        return franchises;
    }

    public void setFrancgises(List<Franchise> franchises) {
        this.franchises = franchises;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }


}
