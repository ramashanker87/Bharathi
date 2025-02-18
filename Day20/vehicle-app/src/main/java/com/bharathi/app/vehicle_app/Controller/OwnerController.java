package com.bharathi.app.vehicle_app.Controller;{
        package com.vehicleapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Owner {

    @Id
    private String name;
    private String address;
    private int age;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

}
