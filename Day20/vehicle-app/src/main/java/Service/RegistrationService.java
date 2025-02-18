package Service;

public class RegistrationService package com.vehicleapp.service;

import com.vehicleapp.model.Registration;
import com.vehicleapp.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration registerVehicle(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration getRegistration(Long registrationId) {
        return registrationRepository.findById(registrationId).orElse(null);
    }
}
{
}
