package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhang
 */
@Entity
@Table(name = "RASTAURANT_REPOSITORY")
@NamedQueries(
        {
                @NamedQuery(
                        name = "getItemsbyName",
                        query = "SELECT r FROM Repository r WHERE r.itemName=:itemName"
                ),
                @NamedQuery(
                        name="getAllItems",
                        query = "SELECT r FROM Repository r"
                )

        }
)


public class Repository implements Serializable {

    private Integer itemId;
    private String itemName;
    private String quantity;

    public Repository(Integer itemId, String itemName, String quantity, String type) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.type = type;
    }

    public Repository() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Id
    public Integer getItemId() {
        return itemId;
    }
}
