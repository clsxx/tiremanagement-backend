package com.adesso.tireManagement.service;

import com.adesso.tireManagement.model.Tire;

import java.util.List;

public interface TireService {
    public Tire createTire(Tire tire);
    public Tire updateTire(Tire tire);
    public List<Tire> getAllTires();
    public void deleteTire(Long id);
}
