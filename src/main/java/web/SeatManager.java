package web;

import ejb.RequestBean;
import entity.Dish;
import entity.Seat;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.component.UIParameter;
import javax.inject.Named;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author zhao chenyang
 */
@Named
@SessionScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class SeatManager implements Serializable {
    @EJB
    private RequestBean request;
    private String newSeatId;
    private String newCapacity;
    private String newStatus;
    private boolean newIsPrivate;
    private static final Logger logger = Logger.getLogger("RestaurantManager.web.SeatManager");

    private String seatId;  // 根据此Id查询单个获取的状态
    private String seatsStatus; // 根据这个来获取seats
    private String seatCapacity;


    public String getSeatCapacity() {
        return seatCapacity;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getSeatsStatus() {
        return seatsStatus;
    }

    public String getNewSeatId() {
        return newSeatId;
    }

    public String getNewCapacity() {
        return newCapacity;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public boolean isNewIsPrivate() {
        return newIsPrivate;
    }


    // -----------------------------------------------------------------------------------
    public void setNewSeatId(String newSeatId) {
        this.newSeatId = newSeatId;
    }

    public void setNewCapacity(String newCapacity) {
        this.newCapacity = newCapacity;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public void setNewIsPrivate(boolean newIsPrivate) {
        this.newIsPrivate = newIsPrivate;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public void setSeatsStatus(String seatsStatus) {
        this.seatsStatus = seatsStatus;
    }

    public void setSeatCapacity(String seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    /**
     * 获得所有包厢
     *
     * @return 所有包厢的列表
     */
    public List<Seat> getAllPrivateSeats() {
        try {
            return request.getAllPrivateSeats();
        } catch (Exception e) {
            logger.warning("get all private seats failed,info is \n" + e.getMessage());
            throw e;
        }
    }


    /**
     * 添加Seat
     */
    private String createSeatInfo;

    public String getCreateSeatInfo() {
        return createSeatInfo;
    }
    public void setCreateSeatInfo(String createSeatInfo) {
        this.createSeatInfo = createSeatInfo;
    }
    public String createSeat() {
        try {
            createSeatInfo = null;
            if(request.getSeatbyId(newSeatId)!=null){
                createSeatInfo = "座位号冲突";
                return "fail";
            }
            request.createSeat(newSeatId, newCapacity, newStatus, newIsPrivate);
            this.newSeatId = null;
            this.newCapacity = null;
            this.newStatus = null;
            this.newIsPrivate = false;
            return "success";
        } catch (Exception e) {
            logger.warning("Problem creating seat in createSeat.");
            return "fail";
        }
    }

    /**
     * 根据Seat capacity 查询
     */
    public List<Seat> getSeatsbyCapacity() {
        try {
            return request.getSeatsbyCapacity(seatCapacity);
        } catch (Exception e) {
            logger.warning("Problem getSeatsbyCapacity.");
            throw e;
        }
    }

    /**
     * 查询所有
     */
    public List<Seat> getAllSeats() {
        try {
            return request.getAllSeats();
        } catch (Exception e) {
            logger.warning("Problem getAllSeats.");
            throw e;
        }
    }

    /**
     * 查询单个Seat状态
     */
    public String getStatus() {
        try {
            return request.getSeatStatus(seatId);
        } catch (Exception e) {
            logger.warning("Problem getSeatStatus.");
            throw e;
        }
    }

    /**
     * 根据状态查询所有seat
     */
    public List<Seat> getSeatsbyStatus() {
        try {
            return request.getSeatsbyStatus(seatsStatus);
        } catch (Exception e) {
            logger.warning("Problem getSeatsbyStatus.");
            throw e;
        }

    }
    /**
     * 删除Seat
     */
    public void removeSeat() {
        try {
            request.removeSeat(newSeatId);
        } catch (Exception e) {
            logger.warning("Problem removing seat in removeSeat.");
        }
    }
    /**
     * 点击桌子返回菜单
     */
    private String seatOrderInfo = null;
    public String getSeatOrderInfo() {
        return seatOrderInfo;
    }
    public void setSeatOrderInfo(String seatOrderInfo) {
        this.seatOrderInfo = seatOrderInfo;
    }

    public List<Dish> getOrderbySeat(String seatId){
        try{
            seatOrderInfo = null;
            if(request.getSeatStatus(seatId)!="已点单"){
                seatOrderInfo = "当前座位无订单";
                return null;
            }else{
                return request.getDishesbyOrder(request.getOrderIdbySeatIdandStatus(seatId,"未完成"));
            }
        }catch(Exception e){
            throw e;
        }
    }

    public Seat getSeatbyId(String seatId){
        try{
            return request.getSeatbyId(seatId);
        }catch (Exception e){
            throw e;
        }
    }
}
