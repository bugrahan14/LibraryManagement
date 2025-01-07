package com.Library.library_management.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name="first_name",nullable = false)
    private String first_name;

    @Column(name="last_name",nullable = false)
    private String last_name;

    @Column(name="email",unique = true,nullable = false)
    private String email;

    @Column(name="phone_number")
    private String phone_number ;

    @Column(name="membership_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date membership_date;

    public Member() {
    }

    public Member(Long id, String first_name, String last_name, String email, String phone_number, Date membership_date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.membership_date = membership_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getMembership_date() {
        return membership_date;
    }

    public void setMembership_date(Date membership_date) {
        this.membership_date = membership_date;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", membership_date=" + membership_date +
                '}';
    }
}
