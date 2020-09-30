package com.rentcar.webapp.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.rentcar.webapp.Utility.Utility;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 3445642286051121923L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private Long vehicleId;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="type")
    private String type;

    @Column(name="license_plate")
    private String licensePlate;

    @Column(name="registration_Year")
    private Date registrationYear;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="vehicle_id")
    private List<Rentals> rentalsList;

//-----------------------------------------------------------------------------------------------------------
    @JsonGetter("registrationYear")
    public String getJsonRegistrationYear() {
    return Utility.formatDate(this.registrationYear);
}
    @JsonSetter
    public void setJsonRegistrationYear(String registrationYear) throws ParseException {
        this.registrationYear = Utility.parseDate(registrationYear);
    }
//------------------------------------------------------------------------------------------------------------

    public Long getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Date getRegistrationYear() {
        return registrationYear;
    }
    public void setRegistrationYear(Date registrationYear) {
        this.registrationYear = registrationYear;
    }

    public List<Rentals> getRentalsList() {
        return rentalsList;
    }
    public void setRentalsList(List<Rentals> rentalsList) {
        this.rentalsList = rentalsList;
    }
}
