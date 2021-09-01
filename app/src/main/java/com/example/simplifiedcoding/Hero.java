package com.example.simplifiedcoding;

import java.io.Serializable;
/**
 * Created by Belal on 9/9/2017.
 */

class Hero {
    private final int id;
    private final String name;
    private final String phone;
    private final String address;
    private final String bill;
    private final String creation;
    private final String description;
    private final String type;
    private final String reference;
    private final String amount;
    private final String payed;
    private final String updated;


    public Hero(int id, String name, String phone,String address,String bill,String creation,String description,String type,String reference,String amount,String payed,String updated ) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.bill = bill;
        this.creation = creation;
        this.description = description;
        this.type = type;
        this.reference = reference;
        this.amount = amount;
        this.payed = payed;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getbill() {
        return bill;
    }
    public String getcreation() {
        return creation;
    }
    public String getdescription() {
        return description;
    }
    public String gettype() {
        return type;
    }
    public String getreference() {
        return reference;
    }

    public String getamount() {
        return amount;
    }
    public String getpayed() {
        return payed;
    }
    public String getupdated() {
        return updated;
    }


}
