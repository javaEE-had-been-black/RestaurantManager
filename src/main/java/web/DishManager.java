package web;

import ejb.RequestBean;
import entity.Dish;

import javax.ejb.EJB;
import java.util.List;

/**
 * @author zwt
 */
public class DishManager {
    @EJB
    private RequestBean request;
    private String searchKey;
    private String type;
    private List<Dish> dishResult;

    public void getDishesbyNameAndType() {
        dishResult = request.getDishesbyNameAndType(searchKey, type);
        return;
    }

}
