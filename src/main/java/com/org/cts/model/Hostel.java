package com.org.cts.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Hostel {
    @Id
    private int id;
    private String name;
    private String hostelAddress;
    private Double hostelFee;

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

    public String getHostelAddress() {
        return hostelAddress;
    }

    public void setHostelAddress(String hostelAddress) {
        this.hostelAddress = hostelAddress;
    }

    public Double getHostelFee() {
        return hostelFee;
    }

    public void setHostelFee(Double hostelFee) {
        this.hostelFee = hostelFee;
    }
}
