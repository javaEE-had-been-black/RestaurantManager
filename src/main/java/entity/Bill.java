package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author zhang
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name="getBillbyDate",
                query = "SELECT b FROM Bill b WHERE b.itemData>:startTime and b.itemData<:endTime"
        ),
        @NamedQuery(
                name="getBillbyType",
                query = "SELECT b FROM Bill b WHERE b.type=:type"
        ),
        @NamedQuery(
                name="getBillbyId",
                query = "SELECT b FROM Bill b WHERE b.itemId=:itemId"
        )
})
public class Bill implements Serializable {
    private Integer itemId;
    private Date itemData;
    boolean type;
    String amount;

    public Bill(Integer itemId, Date itemData, boolean type, String amount) {
        this.itemId = itemId;
        this.itemData = itemData;
        this.type = type;
        this.amount = amount;
    }

    public Bill() {

    }

    public boolean isType() {
        return type;
    }

    @Temporal(TIMESTAMP)
    public Date getItemData() {
        return itemData;
    }

    public void setItemData(Date itemData) {
        this.itemData = itemData;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Id
    public Integer getItemId() {
        return itemId;
    }
}
