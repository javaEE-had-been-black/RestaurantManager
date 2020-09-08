package web;

import ejb.RequestBean;
import entity.Customer;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhang
 */
@Named
@SessionScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class CustomerManager implements Serializable {
    @EJB
    private RequestBean request;

    public Customer creatCustomer(String telNumber, String customerName) {
        try {
            request.createCustomer(telNumber, customerName);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        try {
            return request.getCustomerbyTelNumber(telNumber);
        } catch (Exception e) {
            throw new EJBException((e.getMessage()));
        }
    }

    public void addPoints(Customer customer, Integer points) {
        try {
            request.addPoints(customer.getCustomerId(), points);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void usePoint(Customer customer, Integer points) {
        try {
            request.usePoints(customer.getCustomerId(), points);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public Customer getCustomerbyTelNumber(String telNumber) {
        try {
            return request.getCustomerbyTelNumber(telNumber);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<Customer> getCustomersbyCustomerName(String customerName) {
        try {
            return request.getCustomerbyCustomerName(customerName);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    public Customer getCustomerbyCustomerId(String customerId){
        try {
            return request.getCustomerbyCustomerId(customerId);
        }catch (Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public List<Customer> getAllCustomers(){
        try{
            return request.getAllCustomers();
        }catch (Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public List<Customer> getCustomerbyDate(Date startTime,Date endTime){
        try {
            return request.getCustomersbyDate(startTime,endTime);
        }catch (Exception e){
            throw new EJBException(e.getMessage());
        }
    }
}
