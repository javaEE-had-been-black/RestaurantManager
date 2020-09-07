package ejb;

import entity.Customer;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * @author zhao chenyang
 */
@Stateful
public class RequestBean {
    @PersistenceContext
    private EntityManager em;

    /**
    *  Creator
    */
    public void createUser(String userId,
                           String userName,
                           String password,
                           String position,
                           String telNumber,
                           String salary){

    };
    public void createSeat(String seatId,
                    String capacity,
                    String state,
                    boolean isPrivate){

    }
    public void createDish(String dishId,
                           String dishName,
                           String dishPrice,
                           String imageUrl,
                           String type){

    }
    public void createOrder(Integer orderId,
                            Date startTime,
                            Date endTime,
                            String orderPrice,
                            Integer discount,
                            String comment,
                            String seatId,
                            String userId,
                            String customerId){

    }
    public void createDishinOrder(String dishId,
                                  String orderId){

    }
    public void createCustomer(String telNumber,
                               String customerName){

    }
    public void createBill(Integer itemId,
                           Date itemDate,
                           boolean type,
                           String amount){

    }
    public void createRepository(String itemId,
                                 String itemName,
                                 String quantity,
                                 String type){

    }

    /**
     * User
     */
    public User getUser(String userId){

    }
    public String searchUserIdbytel(String telNumber){

    }
    /**
     * Seat
     */
    public List<Seat> getSeatsbyCapacity(String capacity){

    }
    public List<Seat> getAllPrivateSeats(){
        //获得所有包间
    }
    public String getSeatState(Seat seat){

    }
    /**
     * Dish
     */
    public List<Dish> getDishbyType(String type){

    }
    /**
     * Order
     */
    public List<Order> getOrderbyTime(Date startTime,Date endTime){

    }
    /**
     * Dish_in_Order
     */
    public List<String> getDishsbyOrder(Integer orderId){

    }
    public List<String> getOrdersbyDish(String dishId){

    }
    /**
     * Customer
     */
    public void addPoints(Customer customer,Integer points){

    }
    public void usePoints(Customer customer,Integer points){

    }
    public List<Customer> getCustomerbyname(String customerName){

    }
    /**
     * bill
     */
    public List<Bill> getBillbyDate(Date startTime,Date endTime){

    }
    public List<Bill> getBillbyType(boolean type){

    }
    public Bill getBillbyId(Integer itemId){

    }
    /**
     * Repository
     */
    public List<Repository> getItemsbyName(String itemName){

    }
}
