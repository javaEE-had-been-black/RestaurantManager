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
import java.util.logging.Logger;

/**
 * @author zhang
 */
@Named
@SessionScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class CustomerManager implements Serializable {
    @EJB
    private RequestBean request;
    private String newCustomerName;
    private String newTelNumber;
    private String telNumber;
    private Integer customerId;
    private Integer points;
    private String customerName;
    private static final Logger logger = Logger.getLogger("RestaurantManager.web.CustomerManager");


    /**
     * 添加Customer
     */
    public void creatCustomer() {
        try {
            request.createCustomer(newTelNumber, newCustomerName);
            this.newCustomerName=null;
            this.newTelNumber=null;
        } catch (Exception e) {
            logger.warning("Problem creating seat in createSeat.");
        }
    }

    /**
     * 增加积分
     */

    public void addPoints() {
        try {
            request.addPoints(customerId, points);
        } catch (Exception e) {
            logger.warning("Problem addPoints.");
        }
    }

    /**
     *使用积分
     */
    public void usePoint() {
        try {
            request.usePoints(customerId, points);
        } catch (Exception e) {
            logger.warning("Problem usePoint.");
        }
    }

    public Customer getCustomerbyTelNumber() {
        try {
            return request.getCustomerbyTelNumber(telNumber);
        } catch (Exception e) {
            logger.warning("Problem getCustomerbyTelNumber.");
            throw e;
        }
    }

    public List<Customer> getCustomersbyCustomerName() {
        try {
            return request.getCustomerbyCustomerName(customerName);
        } catch (Exception e) {
            logger.warning("Problem getCustomerbyCustomerName.");
            throw e;
        }
    }
    public Customer getCustomerbyCustomerId(){
        try {
            return request.getCustomerbyCustomerId(this.customerId);
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
    public void addPoints(Integer customerId, Integer points) {
        try {
            request.addPoints(customerId, points);
        } catch (Exception e) {
            throw e;
        }
    }

    public void usePoints(Integer customerId, Integer points) {
        try {
            request.usePoints(customerId, points);
        } catch (Exception e) {
            throw e;
        }
    }
}
