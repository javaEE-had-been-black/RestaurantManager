package web;

import ejb.RequestBean;
import entity.Customer;

import javax.ejb.EJB;
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
    private Date startTime;
    private Date endTime;
    private static final Logger logger = Logger.getLogger("RestaurantManager.web.CustomerManager");


    public RequestBean getRequest() {
        return request;
    }

    public void setRequest(RequestBean request) {
        this.request = request;
    }

    public String getNewCustomerName() {
        return newCustomerName;
    }

    public void setNewCustomerName(String newCustomerName) {
        this.newCustomerName = newCustomerName;
    }

    public String getNewTelNumber() {
        return newTelNumber;
    }

    public void setNewTelNumber(String newTelNumber) {
        this.newTelNumber = newTelNumber;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public static Logger getLogger() {
        return logger;
    }

    /**
     * 添加Customer
     */
    public String creatCustomer() {
        try {
            request.createCustomer(newTelNumber, newCustomerName);
            this.newCustomerName = null;
            this.newTelNumber = null;
            return "创建客户成功";
        } catch (Exception e) {
            logger.warning("Problem creating seat in createSeat.");
            return "创建客户失败";
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
     * 使用积分
     */
    public void usePoint() {
        try {
            request.usePoints(customerId, points);
        } catch (Exception e) {
            logger.warning("Problem usePoint.");
        }
    }


    /**
     * 通过电话号码得到顾客的信息
     *
     * @return 顾客信息
     */
    public Customer getCustomerbyTelNumber() {
        try {
            return request.getCustomerbyTelNumber(telNumber);
        } catch (Exception e) {
            logger.warning("Problem getCustomerbyTelNumber.");
            throw e;
        }
    }

    /**
     * 通过顾客姓名得到同名的顾客列表
     *
     * @return 顾客列表
     */

    public List<Customer> getCustomersbyCustomerName() {
        try {
            return request.getCustomerbyCustomerName(customerName);
        } catch (Exception e) {
            logger.warning("Problem getCustomerbyCustomerName.");
            throw e;
        }
    }

    /**
     * 通过顾客的id得到顾客信息
     *
     * @return 顾客信息
     */
    public Customer getCustomerbyCustomerId() {
        try {
            return request.getCustomerbyCustomerId(this.customerId);
        } catch (Exception e) {
            logger.warning("Problem getCustomerbyCustomerId");
            throw e;
        }
    }

    /**
     * 得到所有的顾客
     *
     * @return 所有的顾客列表
     */
    public List<Customer> getAllCustomers() {
        try {
            return request.getAllCustomers();
        } catch (Exception e) {
            logger.warning("Problem getAllCustomers");
            throw e;
        }
    }

    /**
     * 通过日期来得到该段时间注册的顾客
     *
     * @return 顾客列表
     */
    public List<Customer> getCustomerbyDate() {
        try {
            return request.getCustomersbyDate(startTime, endTime);
        } catch (Exception e) {
            logger.warning(("Problem getCustomebyDate"));
            throw e;
        }
    }

    /**
     * 删除Customer
     */
    public void removeCustomer() {
        try {
            request.removeCustomer(customerId);
        } catch (Exception e) {
            logger.warning("Problem removing customer in removeCustomer.");
        }
    }
}
