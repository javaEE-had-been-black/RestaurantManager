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
@SuppressWarnings("unused")
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class RestaurantManager implements Serializable {
    @EJB
    private RequestBean request;
    private String userId;
    private String password;
    private String position;
    private String userName;
    private String salary;
    private Date startTime;
    private List<Dish> dishes;
    private String logInfo;

    public RestaurantManager() {
    }


    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public String getUserName() {
        return userName;
    }

    public String getSalary() {
        return salary;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    private static final Logger logger = Logger.getLogger("web.RestaurantManager");

    private Integer currentOrder;
    private String currentDish;
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
     *
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
    public void removeUser() {
        try {
            request.removeUser(userId);
        } catch (Exception e) {
            logger.warning("Remove User Failed,the reason is" + e.toString());
        }
    }

    public String updateUserInfo(String userId,
                                 String userName,
                                 String password,
                                 String position,
                                 String telNumber,
                                 String salary) {
        User user = request.getUserbyUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setPosition(position);
        user.setTelNumber(telNumber);
        user.setSalary(salary);
        return "success";
    }

    /**
     * @param
     * @return 是否运行登录
     */
    public String login() {
        try {
            if (userId == null || password == null) {
                logInfo = "请输入账号或密码";
                return "fail";
            } else if (request.getUserbyUserId(userId).getUserId() == null) {
                logInfo = "账号不存在";
                return "fail";
            } else if (password.equals(request.getUserbyUserId(userId).getPassword())) {
                User user = request.getUserbyUserId(userId);
                userId = user.getUserId();
                userName = user.getUserName();
                password = user.getPassword();
                position = user.getPosition();
                salary = user.getSalary();
                logInfo = "";
                return "success";
            } else {
                logInfo = "密码错误或账号不存在";
                return "fail";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
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


    public List<Dish> getAllDishes() {
        try {
            return request.getAllDishes();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * DishinOrder
     */

    public List<Dish> getDishsbyOrder(Integer orderId) {
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

    public List<User> getAllUsers() {
        try {
            return request.getAllUsers();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
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
//---------------点餐-------------

    /**
     * 开始点餐
     */
    void startOrder() {
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        this.startTime = new Date();
    }

    /**
     * 返回所有以点菜品
     */
    List<Dish> getAllDishesNow() {
        return dishes;
    }

    /**
     * 添加菜品
     */
    void addDishes(Dish dish) {
        dishes.add(dish);
    }

    /**
     * 删除菜品
     */
    void removeDish(Dish dish) {
        for (int i = this.dishes.size() - 1; i >= 0; i--) {
            Dish item = this.dishes.get(i);
            if (dish.equals(item)) {
                this.dishes.remove(item);
            }
        }
    }

    /**
     * 创建订单
     */
    String newOrder(Integer discount, String comment, String seatId, String userId, String customerTelNumber) {
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date endTime = new Date();
        int orderPrice = 0;
        for (Dish dish : this.dishes) {
            orderPrice += Integer.parseInt(dish.getDishPrice());
        }
        try {
            Seat seat = request.getSeatbySeatId(seatId);
            User user = request.getUserbyUserId(userId);
            Customer customer = request.getCustomerbyTelNumber(customerTelNumber);
            request.createOrder(this.startTime, endTime, String.valueOf(orderPrice), discount, comment, seat, user, customer, dishes);
            this.startTime = null;
            this.dishes.clear();
            return "success";
        } catch (Exception e) {
            logger.warning("Problem in create new Order.");
            return "fail";
        }
    }
//-------------------------------
}
