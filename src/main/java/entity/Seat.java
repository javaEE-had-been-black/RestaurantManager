package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhang
 */

@Entity
@Table(name = "RESTAURANT_SEAT")
@NamedQueries({
        @NamedQuery(
                name = "getSeatsbyCapacity",
                query = "SELECT s FROM Seat s WHERE s.capacity=:capacity"
        ),
        @NamedQuery(
                name = "getAllPrivateSeats",
                query = "SELECT s FROM Seat s WHERE s.private=true"
        ),
        @NamedQuery(
                name = "getSeatStatus",
                query = "SELECT s.status FROM Seat s WHERE s.seatId=:seatId"
        ),
        @NamedQuery(
                name = "getAllSeats",
                query = "SELECT s FROM Seat s"
        ),
        @NamedQuery(
                name = "getSeatsbyStatus",
                query = "SELECT s FROM Seat s WHERE s.status=:status"
        ),
        @NamedQuery(
                name="removeSeat",
                query = "DELETE FROM Seat s WHERE s.seatId=:seatId"
        ),
        @NamedQuery(
                name = "getSeatbySeatId",
                query = "SELECT s FROM Seat s WHERE s.seatId=:seatId"
        )
}
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
