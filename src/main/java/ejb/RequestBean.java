package ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author zhao chenyang
 */
@Stateful
public class RequestBean {
    @PersistenceContext
    private EntityManager em;
    public void createUser(){

    };

}
