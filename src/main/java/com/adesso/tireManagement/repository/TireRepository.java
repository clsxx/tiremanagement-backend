package com.adesso.tireManagement.repository;

import com.adesso.tireManagement.model.Tire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TireRepository extends CrudRepository<Tire, Long> {
    Optional<Tire> findById(Long id);
}
