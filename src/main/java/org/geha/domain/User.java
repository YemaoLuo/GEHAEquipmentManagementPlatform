package org.geha.domain;
/*
  User: Yemao Luo
  Date: 2021/10/17
  Time: 9:38
*/

import java.util.List;

public class User {

    private int id;
    private String name;
    private String gender;
    private String role;
    private int year;
    private List<Equipment> inUse;
    private String email;
    private String phone;
    private String password;

    public User(int id, String name, String gender, String role, int year, List<Equipment> inUse, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.year = year;
        this.inUse = inUse;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public User() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", year=" + year +
                ", inUse=" + inUse +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }

    public List<Equipment> getInUse() {
        return inUse;
    }

    public void setInUse(List<Equipment> inUse) {
        this.inUse = inUse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
