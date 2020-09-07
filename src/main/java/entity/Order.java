package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhang
 */
@Entity
@NamedQueries(
        {@NamedQuery(
                name = "getOrderbyTime",
                query = "SELECT o FROM Order o WHERE o.startTime>:startTime and o.endTime<:entTime "
        ), @NamedQuery(
                name = "getOrderbyId",
                query = "SELECT o FROM Order o WHERE o.orderId=:orderId"
        )
        }
)

public class Order implements Serializable {
    private Integer orderId;
    private Date startTime;
    private Date endTime;
    private String orderPrice;
    private Integer discount;
    private String comment;
    private String seatId;
    private String userId;
    private String customerId;

    public Order() {
    }

    public Order(Integer orderId, Date startTime, Date endTime, String orderPrice, Integer discount, String comment, String seatId, String userId, String customerId) {
        this.orderId = orderId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderPrice = orderPrice;
        this.discount = discount;
        this.comment = comment;
        this.seatId = seatId;
        this.userId = userId;
        this.customerId = customerId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Id
    public Integer getOrderId() {
        return orderId;
    }
}
