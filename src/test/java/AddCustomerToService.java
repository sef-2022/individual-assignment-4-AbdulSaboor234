import model.src.main.java.model.Customer;
import model.src.main.java.model.Franchise;
import model.src.main.java.model.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    Service service;
    Franchise franchise;
    @BeforeEach
    void setup(){
        customer = new Customer("John Smith",1234,franchise);
        customer.setNumberOfCourses(1);
        service = new Service("cleaning",122,franchise);
        service = new Service("clothing",222,franchise);
        service = new Service("ppoo",123,franchise);


    }

    @Test
    void getNumberofServicesUsed(){
        assertEquals(1,customer.getNumberOfServices());
    }

    @Test
    void checkUserNameisJohnSmith(){
        assertEquals("John Smith", customer.getName());
    }





}
