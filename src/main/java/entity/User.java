package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhang
 */
@Entity
@Table(name = "RESTAURANT_USER")
@NamedQueries({
        @NamedQuery(
                name = "getUserbyUserId",
                query = "SELECT u FROM User u WHERE u.userId=:userId"
        ),
        @NamedQuery(
                name = "searchUserbyTel",
                query = "SELECT u FROM User u WHERE u.telNumber=:telNumber"
        ),
        @NamedQuery(
                name = "getUsersbyPosition",
                query = "SELECT u FROM User u WHERE u.position=:position"
        ),
        @NamedQuery(
                name = "getUsersbyUserName",
                query = "SELECT u FROM User u WHERE u.userName=:userName"
        ),
        @NamedQuery(
                name = "getUsers",
                query = "SELECT u FROM User u"
        )
})

public class User implements Serializable {
    private String userId;
    private String userName;
    private String password;
    private String position;
    private String telNumber;
    private String salary;

    public User() {
    }

    public User(String userId, String userName, String password, String position, String telNumber, String salary) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.telNumber = telNumber;
        this.salary = salary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    public String getUserId() {
        return userId;
    }
}
