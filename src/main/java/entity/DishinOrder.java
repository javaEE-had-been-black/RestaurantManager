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
                name = "getDishsbyOrder",
                query = "SELECT do FROM DishinOrder do WHERE do.orderId=:orderId"
        ),
        @NamedQuery(
                name = "getOrdersbyDish",
                query = "SELECT do FROM DishinOrder do WHERE do.dishId=:dishId"
        )
})
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
}
