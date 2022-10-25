package model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
     *
     * @param name: Name of the service
     * @param id:   Unique id of the service.
     */
    public Service(String name, int id) {
        this.name = name;
        this.id = id;
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


    //method that checks the size of the franchise and returns false if greater than 500

    public boolean checkFranchiselessthan500(Customer customer) {
        int maxAmountofCustomersinFranchise = 500;
        boolean lessthan500 = true;
        if (customer.getFranchise().getCustomer().size() > maxAmountofCustomersinFranchise) {
            System.out.println("Capacity full for the franchise");
            lessthan500 = false;
        }

        return lessthan500;
    }

    //checks the amount of service present for a given customer

    public boolean checkServiceAmount(Customer customer) {
        boolean checkServiceUsed = true;
        if (customer.getFranchise().getServices().size() > 3) { //service cannot be greater than 3
            checkServiceUsed = false;
            System.out.println("Incorrect amount of services used");
        }
        return checkServiceUsed;
    }

    //method that checks for duplicate services
    public boolean checkDuplicateServices(Customer customer) throws Exception {
        boolean checkUnique = true;

        Set<String> uniqueNames = new HashSet<>();
        for(Service service: customer.getFranchise().getServices()){
            uniqueNames.add(service.getName()); //sorts service by name for duplication
        }
        if(uniqueNames.size() != customer.getFranchise().getServices().size()){
            //matches the set list to service list to see if there is duplicates as set removes duplicates
            checkUnique= false;
            throw new Exception("Duplicate service");
        }

        return checkUnique;
    }

    /**
     * Add a new customer to the service
     *
     * @param customer: who is requesting the service
     * @return true if the customer is successfully enrolled, false otherwise
     */

    public boolean addCustomerToService(Customer customer) throws Exception {
        return checkDuplicateServices(customer) && checkFranchiselessthan500(customer) && checkServiceAmount(customer);
    }

}
