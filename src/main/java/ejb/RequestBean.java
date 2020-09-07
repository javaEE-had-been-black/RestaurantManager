package ejb;

import entity.*;

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
    public void createRepository(Integer itemId,
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
        try{
            return (User) em.createNamedQuery("getUser")
                    .setParameter("userId",userId)
                    .getSingleResult();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public String searchUserIdbytel(String telNumber){
        try{
            return (String)em.createNamedQuery("searchUserIdbytel")
                    .setParameter("telNumber",telNumber)
                    .getSingleResult();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }

    /**
     * Seat
     */
    public List<Seat> getSeatsbyCapacity(String capacity){
        try{
            return em.createNamedQuery("getSeatsbyCapacity")
                    .setParameter("capacity",capacity)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public List<Seat> getAllPrivateSeats(){
        //获得所有包间
        try{
            return em.createNamedQuery("getAllPrivateSeats")
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public String getSeatStatus(String seatId){
        try{
            return (String) em.createNamedQuery("getSeatStatus")
                    .setParameter("seatId",seatId)
                    .getSingleResult();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }

    /**
     * Dish
     */
    public List<Dish> getDishbyType(String type){
        try{
            return em.createNamedQuery("getDishbyType")
                    .setParameter("type",type)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }

    /**
     * Order
     */
    public List<Order> getOrderbyTime(Date startTime,Date endTime){
        try{
            return em.createNamedQuery("getOrderbyTime")
                    .setParameter("startTime",startTime)
                    .setParameter("endTime",endTime)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }

    /**
     * Dish_in_Order
     */
    public List<String> getDishsbyOrder(Integer orderId){
        try{
            return em.createNamedQuery("getDishsbyOrder")
                    .setParameter("orderId",orderId)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public List<String> getOrdersbyDish(String dishId){
        try{
            return em.createNamedQuery("getOrderbyDish")
                    .setParameter("dishId",dishId)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }

    /**
     * Customer
     */
    public void addPoints(Integer customerId,Integer points){
        try{
            em.createNamedQuery("addPoints")
                    .setParameter("customerId",customerId)
                    .setParameter("points",points);
        }catch(Exception e)
        {
            throw new EJBException(e.getMessage());
        }
    }
    public void usePoints(Integer customerId,Integer points){
        try{
            em.createNamedQuery("usePoints")
                    .setParameter("customerId",customerId)
                    .setParameter("points",points);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public List<Customer> getCustomerbyName(String customerName){
        try{
            return em.createNamedQuery("getCustomerbyName")
                    .setParameter("customername",customerName)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }

    /**
     * bill
     */
    public List<Bill> getBillbyDate(Date startTime,Date endTime){
        try{
            return em.createNamedQuery("getBillbyDate")
                    .setParameter("startTime",startTime)
                    .setParameter("endTime",endTime)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public List<Bill> getBillbyType(boolean type){
        try{
            return em.createNamedQuery("getBillbyType")
                    .setParameter("type",type)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
    public Bill getBillbyId(Integer itemId){
        try{
            return (Bill) em.createNamedQuery("getBillbyId")
                    .setParameter("itemId",itemId)
                    .getSingleResult();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }

    /**
     * Repository
     */
    public List<Repository> getItemsbyName(String itemName){
        try{
            return em.createNamedQuery("getItemsbyName")
                    .setParameter("itemName",itemName)
                    .getResultList();
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
}
