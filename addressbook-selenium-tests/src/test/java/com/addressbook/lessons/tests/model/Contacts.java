package com.addressbook.lessons.tests.model;

public class Contacts {
    public String firstname;
    public String lastname;
    public String address;
    public String email;
    public String mobile;

    public Contacts setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Contacts setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Contacts setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contacts setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contacts setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}
