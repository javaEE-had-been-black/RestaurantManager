package web;

import ejb.RequestBean;
import entity.Repository;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author zhang wen tao
 */
@Named
@SessionScoped
public class RestaurantManager implements Serializable {
    @EJB
    private RequestBean request;
    private static final Logger logger = Logger.getLogger("web.RestaurantManager");
    /**
     * Seat
     */
    private Integer currentOrder;
    private String currentDish;

    /*
      User
     */

    /**
     * 添加user
     */
    public void addUser(String userId,
                        String userName,
                        String password,
                        String position,
                        String telNumber,
                        String salary) {
        request.createUser(userId, userName, password, position, telNumber, salary);
    }

    /**
     * 删除user
     */
    //TODO 等待张航编写新接口
    public void removeUser() {

    }
    //获取密码(拥有账号)

    /*
     * Repository
     */

    /**
     * 获取仓库所有item实体
     * @return 仓库中所有实体的List
     */
    public List<Repository> getAllItems(){
        return request.getAllItems();
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
