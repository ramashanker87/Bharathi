package Service;

public class OwnerService package com.vehicleapp.service;

import com.vehicleapp.model.Owner;
import com.vehicleapp.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner getOwner(String name) {
        return ownerRepository.findById(name).orElse(null);
    }
}
{
}
