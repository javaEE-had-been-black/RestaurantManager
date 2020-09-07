package ejb;

import entity.Customer;
import entity.Dish;

import javax.ejb.EJBException;
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
        try{
            User user = new User(userId,userName,password,position,telNumber,salary);
            em.persist(user);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    };
    public void createSeat(String seatId,
                    String capacity,
                    String status,
                    boolean isPrivate){
        try{
            Seat seat = new Seat(seatId,capacity,status,isPrivate);
            em.persist(seat);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public void createDish(String dishId,
                           String dishName,
                           String dishPrice,
                           String imageUrl,
                           String type){
        try{
            Dish dish = new Dish(dishId,dishName,dishPrice,imageUrl,type);
            em.persist(dish);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
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
        try{
            Order order = new Order(orderId,startTime,endTime,orderPrice,discount,
                                    comment,seatId,userId,customerId
                                    );
            em.persist(order);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public void createDishinOrder(String dishId,
                                  String orderId){
        try{
            DishinOrder dishinOrder = new DishinOrder(dishId,orderId);
            em.persist(dishinOrder);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public void createCustomer(String telNumber,
                               String customerName){
        try{
            Customer customer = new Customer(telNumber,customerName);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public void createBill(Integer itemId,
                           Date itemDate,
                           boolean type,
                           String amount){
        try{
            Bill bill = new Bill(itemId,itemDate,type,amount);
            em.persist(bill);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public void createRepository(String itemId,
                                 String itemName,
                                 String quantity,
                                 String type){
        try{
            Repository repository = new Repository(itemId,itemName,quantity,type);
            em.persist(repository);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
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
    public String getSeatStatus(Seat seat){

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
