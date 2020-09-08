package web;

import ejb.RequestBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author zhang wen tao
 */
@Named
@SessionScoped
public class RestaurantManager implements Serializable {
    @EJB
    private RequestBean request;
    private Integer curr
    /**
     *  Seat
     */
    private Integer currentOrder;
    private String currentDish;
    /**
     *  User
     */
    //添加user

    //删除user

    //获取密码(拥有账号)

    /**
     * Repository
     */
    //获取仓库所有item实体

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
