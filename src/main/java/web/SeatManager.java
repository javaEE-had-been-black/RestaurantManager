package web;

import ejb.RequestBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author zhao chenyang
 */
@Named
@SessionScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class SeatManager implements Serializable {
    @EJB
    private RequestBean request;

    /**
     * 添加Seat
     */

    /**
     * 根据Seat capacity 查询
     */

    /**
     * 查询所有
     */

    /**
     * 根据状态查询
     */

    /**
     * 删除Seat
     */
}
