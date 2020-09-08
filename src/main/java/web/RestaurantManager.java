package web;

import ejb.RequestBean;
import entity.Repository;
import entity.Seat;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
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

    /*
     * Seat
     */

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

    /*
      User
     */

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
     *
     * @param telNumber 电话号码
     * @return 是否运行登录
     */
    public boolean checkUser(String telNumber,String password){
        if("10086".equals(telNumber) && "123456".equals(password)){
            return true;
        }
        return false;
    }
    //获取密码(拥有账号)

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

    /**
     * Dish
     */

    /**
     * DishinOrder
     */

    /**
     * Customer
     */

    /**
     * Bill
     */
}
