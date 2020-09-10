package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author zhao chenyang
 */
@Startup
@Singleton

public class ConfigBean {
    @EJB
    private RequestBean request;

    private String testMassage;

    public String getTestMassage() {
        return testMassage;
    }

    public void setTestMassage(String testMassage) {
        this.testMassage = testMassage;
    }

    private static final Logger logger = Logger.getLogger("java.ejb.ConfigBean");

    @PostConstruct
    public void createData() {

        request.createSeat("2","3","3",false);
        request.createUser("33","3","3","3","e","d");
        request.createCustomer("df","df");
        request.createBill(1,new Date(),false,"d");
        request.createDish("d","d","d","d","d");
        request.createRepository(1,"d","d","d");

    }

    @PreDestroy
    public void deleteData() {
    }
}
