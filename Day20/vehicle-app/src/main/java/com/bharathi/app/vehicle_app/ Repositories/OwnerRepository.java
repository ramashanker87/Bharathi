public class OwnerRepository {package com.vehicleapp.repository;

import com.vehicleapp.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface OwnerRepository extends JpaRepository<Owner, String> {
    }

}
