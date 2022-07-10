package com.dailycodebuffer.springboot.tutorial.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @Column(nullable = false)
    private String departmentName;
    @Column(nullable = false)
    private String departmentCode;
    @Column(nullable = false, length =3000)
    private String departmentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hod", referencedColumnName = "id")
    private Hod hod;

    public Department() {

    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public Department(Long departmentId, String departmentName, String departmentCode, String departmentAddress, Hod hod) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.departmentAddress = departmentAddress;
        this.hod = hod;
    }

    public Department(Hod hod) {
        this.hod = hod;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                '}';
    }

    public Hod getHod() {
        return hod;
    }

    public void setHod(Hod hod) {
        this.hod = hod;
    }
}
