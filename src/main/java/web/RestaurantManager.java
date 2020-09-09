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

    private String userId;
    private String password;
    // 添加座位
    // 删除座位
    // 修改状态
    /*
     * Seat
     */


    /*
      User
     */

    /**
     * 判断User是否存在
     * @param userId userid
     * @return 返回bool值表示user是否存在
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
     * @return 是否运行登录
     */
    public boolean login() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
