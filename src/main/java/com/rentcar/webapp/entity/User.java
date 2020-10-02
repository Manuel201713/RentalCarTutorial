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
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 5719482924436581537L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fiscal_code", unique = true)
    private String fiscalCode;

    @Column(name = "admin")
    private Boolean admin;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private List<Rentals> rentalsList;

    //-------------------------------------------------------------------------------------------------------------
    public User() {
        super();
    }

    public User(User user) {
        super();
        this.userId = user.userId;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.phone = user.phone;
        this.fiscalCode = user.fiscalCode;
        this.birthDate = user.birthDate;
        this.admin = user.admin;
        this.password = user.password;
    }
    //---------------------------------------------------------------------------------------------------------------
    @JsonGetter("birth_date")
    public String getJsonBirthDate() {
        return Utility.formatDate(this.birthDate);
    }

    @JsonSetter("birth_date")
    public void setJsonBirthDate(String birthDate) throws ParseException {
        this.birthDate = Utility.parseDate(birthDate);
    }
    //------------------------------------------------------------------------------------------------------------------


    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public Boolean getAdmin() {
        return admin;
    }
    public Boolean isAdmin() {
        return this.admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Rentals> getRentalsList() {
        return rentalsList;
    }
    public void setRentalsList(List<Rentals> rentalsList) {
        this.rentalsList = rentalsList;
    }
}