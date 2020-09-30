package com.rentcar.webapp.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.rentcar.webapp.Utility.Utility;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;

@Entity
@Table(name = "rentals")
public class Rentals implements Serializable {

    private static final long serialVersionUID = 8444388124254795531L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="rental_id")
    private Long rentalId;

    @Column(name="vehicle_id")
    private Long vehicleId;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

  //------------------------------------------------------------------------------------------------------------
    @JsonGetter("startDate")
    public String getJsonStartDate() {
      return Utility.formatDate(this.startDate);
  }
    @JsonSetter
    public void setJsonStartDate(String startDate) throws ParseException {
        this.startDate = Utility.parseDate(startDate);
    }

    @JsonGetter("endDate")
    public String getJsonEndDate() {
        return Utility.formatDate(this.endDate);
    }
    @JsonSetter
    public void setJsonEndDate(String endDate) throws ParseException {
        this.endDate = Utility.parseDate(endDate);
    }
//------------------------------------------------------------------------------------------------------------


    public Long getRentalId() {
        return rentalId;
    }
    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
