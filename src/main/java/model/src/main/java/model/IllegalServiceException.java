package model.src.main.java.model;

/**
 * Exception when a Customer cannot get a service.
 */
public class IllegalServiceException extends Exception {
	 public IllegalServiceException(String errorMessage) {
	        super(errorMessage);}
}
