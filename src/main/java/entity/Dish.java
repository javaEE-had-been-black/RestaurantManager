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
@NamedQuery(
        name="getDishbytype",
        query = "SELECT d FROM Dish d WHERE d.type=:type"
)

public class Dish implements Serializable{
    private String dishId;
    String dishName;
    String dishPrice;
    String imageUrl;
    String type;

    public Dish() {
    }

    public Dish(String dishId, String dishName, String dishPrice, String imageUrl, String type) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.imageUrl = imageUrl;
        this.type = type;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    @Id
    public String getDishId() {
        return dishId;
    }
}
