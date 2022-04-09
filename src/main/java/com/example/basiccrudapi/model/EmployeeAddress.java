package com.example.basiccrudapi.model;

public class EmployeeAddress {
    private Integer id;
    private String po;
    private String district;

    public EmployeeAddress(Integer id, String po, String district) {
        this.id = id;
        this.po = po;
        this.district = district;
    }

    public EmployeeAddress() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
