package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.faces.component.FacesComponent;
import javax.inject.Singleton;
import java.util.logging.Logger;

/**
 * @author zhao chenyang
 */
@Startup
@Singleton

public class ConfigBean {
    @EJB
    private RequestBean request;
    private static final Logger logger = Logger.getLogger("java.ejb.ConfigBean");

    @PostConstruct
    public void createData() {
        logger.warning("NOW RUNNING!!!!!!!!!!!!!!!");
        request.createUser("18055548766", "任梦婕", "1234", "外卖小哥", "18055548766", "7777");
        request.createUser("18055548765", "任梦婕", "1234", "外卖小哥", "18055548766", "7777");
    }

    @PreDestroy
    public void deleteData() {
    }
}
