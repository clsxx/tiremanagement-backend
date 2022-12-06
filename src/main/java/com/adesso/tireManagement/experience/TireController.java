package com.adesso.tireManagement.experience;

import com.adesso.tireManagement.model.Tire;
import com.adesso.tireManagement.service.TireServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AccountController handles all REST-Calls to Tire.
 */
@RestController
@RequestMapping("tire")
@CrossOrigin
public class TireController {
    @Autowired
    TireServiceImpl tireService;

    /**
     * Creates a new tire
     * @param tire
     * @return tire
     */
    @PostMapping("/create")
    public Tire createTire(@RequestBody Tire tire) {
        return tireService.createTire(tire);
    }

    /**
     * Updates an existing tire
     * @param tire
     * @return tire
     */
    @PatchMapping("/update")
    public Tire updateTire(@RequestBody Tire tire) {
        return tireService.updateTire(tire);
    }

    /**
     * Gets all tires
     * @return tires
     */
    @GetMapping("")
    public List<Tire> getAllTires() {
        return tireService.getAllTires();
    }

    /**
     * Delete Tire
     */
    @DeleteMapping("/delete")
    public void deleteTire(@RequestBody ObjectNode json) {
        Long id = (json.get("id") != null) ? json.get("id").asLong() : null;
        tireService.deleteTire(id);
    }


}
