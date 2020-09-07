package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.inject.Singleton;

/**
 * @author zhao chenyang
 */
@Singleton
@Startup
public class ConfigBean {
    @EJB
    private RequestBean request;

    @PostConstruct
    public void createData(){
        request.createCustomer("18279","hanhan");
        request.createUser("1111","zcy","dfdff","wt","234444","0000");

    }

    @PreDestroy
    public void deleteData(){

    }
}
