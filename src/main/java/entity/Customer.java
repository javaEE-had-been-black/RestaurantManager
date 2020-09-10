package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhang
 */
@Entity
@Table(name = "RESTAURANT_CUSTOMER")
@NamedQueries({
        @NamedQuery(
                name = "addPoints",
                query = "UPDATE Customer c SET c.points=c.points+:points WHERE c.customerId=:customerId"
        ),
        @NamedQuery(
                name = "usePoints",
                query = "UPDATE Customer c SET c.points=c.points-:points WHERE c.customerId=:customerId"
        ),
        @NamedQuery(
                name = "getCustomerbyCustomerName",
                query = "SELECT c FROM Customer c WHERE c.customerName=:customerName"
        ),
        @NamedQuery(
                name = "getCustomerbyTelNumber",
                query = "SELECT c FROM Customer c WHERE c.telNumber =:telNumber"
        ),
        @NamedQuery(
                name = "getCustomerbyCustomerId",
                query = "SELECT c FROM Customer c WHERE c.customerId=:customerId"
        ),
        @NamedQuery(
                name = "getAllCustomers",
                query = "SELECT c FROM Customer c"
        ),
        @NamedQuery(
                name = "getCustomersbyDate",
                query = "SELECT c FROM Customer c WHERE c.addTime>:startTime and c.addTime<:endTime"
        ),
        @NamedQuery(
                name="removeCustomer",
                query = "DELETE FROM Customer c WHERE c.customerId=:customerId"
        )
})
public class Customer implements Serializable {
    private Integer customerId;
    private String telNumber;
    private String customerName;
    private Integer points;
    private Date addTime;

    public Customer(String telNumber, String customerName) {
        this.telNumber = telNumber;
        this.customerName = customerName;
        this.addTime = new Date();
        this.points = 0;
    }

    public Customer() {

    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCustomerId() {
        return customerId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}

