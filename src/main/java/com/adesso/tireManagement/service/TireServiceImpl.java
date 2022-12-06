package com.adesso.tireManagement.service;

import com.adesso.tireManagement.error.TireNotFoundException;
import com.adesso.tireManagement.model.Tire;
import com.adesso.tireManagement.repository.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The business implementation of the TireManagementApplication.
 */
@Service
public class TireServiceImpl implements TireService {

    @Autowired
    TireRepository tireRepository;

    /**
     * Creates a new tire.
     * @param tire
     */
    public Tire createTire(Tire tire){
        return tireRepository.save(tire);
    }

    /**
     * Updates a tire with its attributes.
     * @param tire
     */
    public Tire updateTire(Tire tire) {
        Optional<Tire> tireOptional = tireRepository.findById(tire.getId());
        if(tireOptional.isPresent()){
            Tire storedTire = tireOptional.get();
            storedTire.setDesignType(tire.getDesignType());
            storedTire.setWidth(tire.getWidth());
            storedTire.setLoadIndex(tire.getLoadIndex());
            storedTire.setSpeedIndex(tire.getSpeedIndex());
            storedTire.setHeightWidthRatio(tire.getHeightWidthRatio());
            storedTire.setDiameter(tire.getDiameter());
            return tireRepository.save(storedTire);
        }
        throw new TireNotFoundException();
    }

    /**
     * Retrieves all tires.
     * @return tires
     */
    public List<Tire> getAllTires() {
        Iterable<Tire> tireListIterable = tireRepository.findAll();
        List<Tire> tireList = new ArrayList<>();
        tireListIterable.forEach(tireList::add);
        return tireList;
    }

    /**
     * Deletes a tire by its id.
     * @param id
     */
    public void deleteTire(Long id) {
        try {
            tireRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new TireNotFoundException();
        }
    }
}
