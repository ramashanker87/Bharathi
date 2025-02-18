package com.bharathi.app.vehicle_app.model;

public class Registration package com.vehicleapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Registration {

    @Id
    private Long registrationId;

    @OneToOne
    private Owner vehicleOwner;

    @OneToOne
    private Vehicle vehicle;

    // Getters and Setters

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Owner getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(Owner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
{
}
