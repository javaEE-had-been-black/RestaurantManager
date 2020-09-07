package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

/**
 * @author zhang
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name="addPoints",
                query = "UPDATE Customer c SET c.points=c.points+:points WHERE c.customerId=:customerid"
        ),
        @NamedQuery(
                name="usePoint",
                query="UPDATE Customer c SET c.points=c.points-:points WHERE c.customerId=:customerid"
        ),
        @NamedQuery(
                name="getCustomerbyName",
                query = "SELECT c FROM Customer c WHERE c.customerName=:customerName"
        )
})
public class Customer implements Serializable{

    private Integer customerId;
    private String telNumber;
    private String customerName;
    private Integer points;

    public Customer(String telNumber, String customerName) {
        this.telNumber = telNumber;
        this.customerName = customerName;
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
    public Integer getCustomerId() {
        return customerId;
    }
}
