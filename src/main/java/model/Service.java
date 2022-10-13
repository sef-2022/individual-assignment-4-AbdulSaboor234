package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Service offered by the franchise.
 */
public class Service {
    /**
     * Name the service
     */
    private String name;
    
    /**
     * ID of the service
     */
    private int id;

    /**
     * Start date of the service
     */
    private Date startDate;

    /**
     * End date of the service
     */
    private Date endDate;


    /**
     * Customers allocated to the service
     */
    private List<Customer> customers = new ArrayList<Customer>();

   
    /**
     * Services associated with a franchise
     */
    private Franchise fID;
    
    
    /**
     * Create a new service object.
     * @param name: Name of the service
     * @param id:  Unique id of the service.
     * @param Franchise:  Franchise that offers the service.
     */
    public Service(String name, int id) {
        this.name = name;
        this.id = id;
        
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Customer> getCustomer() {
        return customers;
    }
    
    public Franchise getFranchise() {
        return fID;
    }
    
    public void setFranchise(Franchise fID) {
        this.fID = fID;
    }

    /**
     * Add a new customer to the service
     * @param customer: who is requesting the service 
     * @return true if the customer is successfully enrolled, false otherwise
     */

    public boolean addCustomerToService(Customer customer, Franchise fID){
    	return false;
   
    }




}
