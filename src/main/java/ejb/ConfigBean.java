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
    public void createData() {
    }

    @PreDestroy
    public void deleteData() {
    }
}
