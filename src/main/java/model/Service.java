package model;

import org.jetbrains.annotations.NotNull;

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
     * @param fID:  Franchise that offers the service.
     */
    public Service(String name, int id,Franchise fID) {
        this.name = name;
        this.id = id;
        this.fID = fID;
    }

    public Service() {
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

    public boolean checkFranchiselessthan500(Franchise fID){
        boolean lessthan500 = false;
        for(Service service: fID.getServices()){
            int amountOfCustomers = service.getCustomer().size();
            if(amountOfCustomers>500){
                System.out.println("Capacity full for the service");
                lessthan500 = true;
            }
        }

        return lessthan500;
    }
    public boolean checkServiceAmount(Customer customer){
        boolean checkServiceUsed = customer.getNumberOfServices() >= 0 && customer.getNumberOfServices() <= 3;
        if(!checkServiceUsed){
            System.out.println("Incorrect amount of services used");
        }
        return checkServiceUsed;
    }

    public  boolean checkServiceUnique(Customer customer){
        boolean checkUnique = true;
        try{
            boolean noRepeatingServices = customer.getFranchise().getServices().stream().distinct().findAny().isPresent();
            if(!noRepeatingServices){
                checkUnique = false;
                throw new Exception("service already existed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return checkUnique;
    }

    /**
     * Add a new customer to the service
     * @param customer: who is requesting the service 
     * @return true if the customer is successfully enrolled, false otherwise
     */

    public boolean addCustomerToService(Customer customer, Franchise fID) {
        return checkFranchiselessthan500(fID) && checkServiceAmount(customer) && checkServiceUnique(customer);
    }


}
