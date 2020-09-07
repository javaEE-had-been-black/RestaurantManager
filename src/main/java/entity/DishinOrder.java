package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhang
 */

@Entity

public class DishinOrder implements Serializable{
    private String dishId;
    private String orderId;

    public DishinOrder(String dishId, String orderId) {
        this.dishId = dishId;
        this.orderId = orderId;
    }

    public DishinOrder() {

    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    @Id
    public String getDishId() {
        return dishId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public List<String> getDishbyOrder(Integer orderId){
        return null;
    }
    public List<String> getOrderbyDish(String dishId){
        return null;
    }
}
