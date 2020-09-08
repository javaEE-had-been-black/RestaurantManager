package web;

import ejb.RequestBean;
import entity.*;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author zhang wen tao
 */
@Named
@SessionScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class RestaurantManager implements Serializable {
    @EJB
    private RequestBean request;
    private static final Logger logger = Logger.getLogger("web.RestaurantManager");

    private Integer currentOrder;
    private String currentDish;
    // 添加座位
    // 删除座位
    // 修改状态
    /*
     * Seat
     */

    public void createSeat(String seatId,
                           String capacity,
                           String status,
                           boolean isPrivate) {
        try {
            request.createSeat(seatId, capacity, status, isPrivate);
        } catch (Exception e) {
            logger.warning("creat seat failed ,info is\n" + e.getMessage());
            throw e;
        }
    }

    /**
     * @param capacity 座位可容纳的人数
     * @return 一个包含所有符合条件的座位的列表
     */
    public List<Seat> getSeatsbyCapacity(String capacity) {
        try {
            return request.getSeatsbyCapacity(capacity);
        } catch (Exception e) {
            logger.warning("getSeatsbyCapacity failde" + e.getMessage());
            throw e;
        }
    }

    public List<Seat> getAllPrivateSeats() {
        //获得所有包厢
        try {
            return request.getAllPrivateSeats();
        } catch (Exception e) {
            logger.warning("get all private seats failed,info is \n" + e.getMessage());
            throw e;
        }
    }

    public String getSeatStatus(String seatId) {
        try {
            return request.getSeatStatus(seatId);
        } catch (Exception e) {
            logger.warning("get sear status failed ,info is\n" + e.getMessage());
            throw e;
        }
    }

    /*
      User
     */

    public boolean hasUser(String userId) {
        return request.getUserbyUserId(userId) != null;
    }

    public User getUser(String userId) {
        try {
            return request.getUserbyUserId(userId);
        } catch (EJBException e) {
            throw e;
        }
    }

    /**
     * 添加user
     */
    public void createUser(String userId,
                           String userName,
                           String password,
                           String position,
                           String telNumber,
                           String salary) {
        try {
            request.createUser(userId, userName, password, position, telNumber, salary);
        } catch (Exception e) {
            logger.warning("Create User Failed,the reason is" + e.getMessage());
            throw e;
        }
    }

    /**
     * 删除user
     */
    //TODO 等待张航编写新接口
    public void removeUser() {

    }

    /**
     * @param userId
     * @return 是否运行登录
     */
    public boolean login(String userId, String password) {
        return password.equals(request.getUserbyUserId(userId).getPassword());
    }
    //获取user信息

    /*
     * Repository
     */

    /**
     * 获取仓库所有item实体
     *
     * @return 仓库中所有实体的List
     */
    public List<Repository> getAllItems() {
        try {
            return request.getAllItems();
        } catch (Exception e) {
            logger.warning("Create User Failed,the reason is" + e.getMessage());
            throw e;
        }
    }

    /**
     * Order
     */
    public List<Order> getOrderbyTime(Date startTime, Date endTime) {
        try {
            return request.getOrderbyTime(startTime, endTime);
        } catch (EJBException e) {
            throw e;
        }
    }

    /**
     * Dish
     */
    public List<Dish> getDishesbyType(String type) {
        try {
            return request.getDishesbyType(type);
        } catch (EJBException e) {
            throw e;
        }
    }

    /**
     * DishinOrder
     */

    public List<String> getDishsbyOrder(Integer orderId) {
        try {
            return request.getDishesbyOrder(orderId);
        } catch (EJBException e) {
            throw e;
        }
    }

    public List<String> getOrdersbyDish(String dishId) {
        try {
            return request.getOrdersbyDish(dishId);
        } catch (EJBException e) {
            throw e;
        }
    }

    /**
     * Customer
     */
    public void addPoints(Integer customerId, Integer points) {
        try {
            request.addPoints(customerId, points);
        } catch (Exception e) {
            throw e;
        }
    }

    public void usePoints(Integer customerId, Integer points) {
        try {
            request.usePoints(customerId, points);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Customer> getCustomerbyName(String customerName) {
        try {
            return request.getCustomerbyName(customerName);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * bill
     */
    public List<Bill> getBillbyDate(Date startTime, Date endTime) {
        try {
            return request.getBillbyDate(startTime, endTime);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Bill> getBillbyType(boolean type) {
        try {
            return request.getBillbyType(type);
        } catch (Exception e) {
            throw e;
        }
    }

    public Bill getBillbyId(Integer itemId) {
        try {
            return request.getBillbyId(itemId);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Repository
     */
    public List<Repository> getItemsbyName(String itemName) {
        try {
            return request.getItemsbyName(itemName);
        } catch (Exception e) {
            throw e;
        }
    }
}
