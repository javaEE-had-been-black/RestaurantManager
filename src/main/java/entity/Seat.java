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
@NamedQueries(
        {@NamedQuery(
                name = "getSeatsbyCapacity",
                query = "SELECT s FROM Seat s WHERE s.capacity=:capacity"
        ),
        @NamedQuery(
                name = "getAllPrivateSeats",
                query = "SELECT s FROM Seat s WHERE s.private=true"
        ),
        @NamedQuery(
                name="getSeatStatus",
                query = "select s.status FROM Seat s WHERE s.seatId=:seatId"
        )}
)
public class Seat implements Serializable {
    private String seatId;
    private String capacity;
    private String status;
    private boolean isPrivate;

    public Seat(String seatId, String capacity, String status, boolean isPrivate) {
        this.seatId = seatId;
        this.capacity = capacity;
        this.status = status;
        this.isPrivate = isPrivate;
    }

    public Seat() {

    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    @Id
    public String getSeatId() {
        return seatId;
    }
}
