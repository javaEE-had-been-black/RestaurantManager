package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author zhang
 */
@Entity

public class Order implements Serializable{
    private Integer orderId;
    private Date startTime;
    private Date endTime;
    private String orderPrice;
    private Integer discount;
    private String comment;
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Id
    public Integer getOrderId() {
        return orderId;
    }
}
