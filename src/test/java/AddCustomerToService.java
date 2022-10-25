import model.Customer;
import model.Franchise;
import model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Implement and test {Service.addCustomerToService } that respects the following:
 *
 *  <ul>
 *
 *      <li> Get the number of services a customer is currently using </li>
 *      <li> A customer cannot hold more than 3 services</li>
 *      <li> Throws an exception if a customer is already using the same service</li>
 *      <li> Get the number of customers associated with the service offered by a franchise</li>
 *      <li> A service offered by a franchise cannot have more than 500 customers. </li>
 *      <li> If this limit is reached for a franchise, then customer is not added to the service</li>
 *  </ul>
 *
 * NOTE: You are expected to verify that the constraints to add a new customer to a service are met.
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with setUp method.
 */
public class AddCustomerToService {

    Customer customer;
    Customer customer1;
    Service service = new Service(); //initialized to be used to test service methods

    Franchise franchise;
    ArrayList<Service> services = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();




    /*setup creating the customers and adding services to the customer franchise*/
    @BeforeEach
    void setup(){

        franchise = new Franchise(1,services,customers); //to intialize it
        customer  = new Customer("John Smith",1234,franchise);
        customer1 = new Customer("James m",256,franchise);
        customers.add(customer);
        customers.add(customer1);
        services.add(new Service("Booking",123));
        services.add(new Service("Cleaning",125));
        services.add(new Service("Cooking",111));

    }



    //checks the number of services used by the customer.
    @Test
    void getNumberServicesUsed_equals0_ifNoServiceAdded(){
        System.out.println("Number of services: "+ franchise.getServices().size());
    }


    //checks if customers services are not null ie all customers have services in the franchise
    @Test
    void checkifCustomerisAddedtoService_showNull_ifServiceIsNotThere(){
        //franchise.setServices(null); //uncomment to check if it is null
        assertNotNull(franchise.getServices());
    }


    //displays all customers related to a specific franchise.
    @Test
    void showAllCustomersRelatedToService(){
        int numberOfCustomers = 0;
    for(Service franchiseService: franchise.getServices()){
        if (franchiseService.getName().equals("Cleaning")) { //checks customers related to the cleaning service
            numberOfCustomers = franchise.getCustomer().size();
        }
    }
        System.out.println("Number of customers: " + numberOfCustomers);
    }


    //checks for duplicate services and if they throw an exception
    @Test
    void checkForDuplicateService_throwException_IfDuplicateServiceFound() {
        customer1.getFranchise().getServices().add(new Service("Booking",123)); //duplicate service added
        Throwable throwable = Assertions.assertThrows(Exception.class,()->{
            service.checkDuplicateServices(customer1);
        });
        Assertions.assertEquals("Duplicate service",throwable.getMessage());

    }


    //checks the number of services are less than 500
    @Test
    void checkNumberOfCustomersLessThan500_returnFalse_ifCustomersMoreThan500(){
        int i = 0; //for the loop
        while(franchise.getCustomer().size() <501){ //adds random 501 customers
            franchise.getCustomer().add(new Customer(i+" Name",i,customer.getFranchise()));
            i++;
        }
       Assertions.assertFalse(service.checkFranchiselessthan500(customer));
    }


    //checks if the amounts of service are less than 4
    @Test
    void checkIfTheNumberOfServiceIsLessThan4_returnFalse_ifServicesMoreThan4(){
        int i = 0;
        while(customer.getFranchise().getServices().size() <5){ //adds 4 service for the customer
            customer.getFranchise().getServices().add(new Service(i+ " Name",i));
            i++;
        }
        Assertions.assertFalse(service.checkServiceAmount(customer));
    }

    
    //checks if the service can be added for a specific customer
    @Test
    void checkIfCustomerISAddedToTheService_returnFalse_IfCustomerIsNotAddedToTheService() throws Exception {
        int i = 0;
        int j =0;
        while(customer.getFranchise().getServices().size() < 5){ //adds 4 service for the customer ie incorrect amount
            customer.getFranchise().getServices().add(new Service(i+ " Name",i));
            i++;
        }
        while(franchise.getCustomer().size() <501){ //adds random 501 customers ie too many customers
            franchise.getCustomer().add(new Customer(j+" Name",j,customer.getFranchise()));
            j++;
        }
        //checks if those criteria are not met.
        Assertions.assertFalse(service.addCustomerToService(customer));
    }


}
