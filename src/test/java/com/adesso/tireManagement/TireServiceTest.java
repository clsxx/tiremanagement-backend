package com.adesso.tireManagement;

import com.adesso.tireManagement.error.*;
import com.adesso.tireManagement.model.Tire;
import com.adesso.tireManagement.model.TireDesignType;
import com.adesso.tireManagement.repository.TireRepository;
import com.adesso.tireManagement.service.TireServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TireServiceTest {

    @Mock
    TireRepository tireRepository;

    @InjectMocks
    TireServiceImpl tireService;

    Tire testTire;

    @BeforeEach
    public void init() {
        testTire = new Tire(205, 55, TireDesignType.RADIAL, 16, 91, 'H');
//        updatedTestTire = new Tire(195, 90, TireDesignType.DIAGONAL, 10, 50, 'X');
    }

    @Test
    public void createTireTest() {
        // Test create tire
        Mockito.when(tireRepository.save(Mockito.any(Tire.class))).thenReturn(testTire);

        Tire storedTire = tireService.createTire(testTire);

        Assertions.assertNotNull(storedTire);
        Assertions.assertEquals(storedTire, testTire);
    }

    @Test
    public void updateTireTest() {
        // Update tire when tire exists
        Mockito.when(tireRepository.findById(Mockito.anyLong())).
                thenReturn(Optional.of(new Tire(195, 90, TireDesignType.DIAGONAL,
                                                10, 50, 'X')));
        Mockito.when(tireRepository.save(Mockito.any(Tire.class))).thenReturn(testTire);

        Tire storedTire = tireService.updateTire(testTire);

        Assertions.assertNotNull(storedTire);
        Assertions.assertEquals(storedTire, testTire);

        // Update tire when tire does not exist
        Mockito.when(tireRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(TireNotFoundException.class, () -> {
            tireService.updateTire(testTire);
        });

        Assertions.assertNotNull(storedTire);
        Assertions.assertEquals(storedTire, testTire);
    }

    @Test
    public void getAllTiresTest() {
        // Update tire when tire exists
        Iterable<Tire> tireListIterable = Arrays.asList(new Tire[]{testTire});
        Mockito.when(tireRepository.findAll()).thenReturn(tireListIterable);

        List<Tire> iterableAsList= new ArrayList<>();
        tireListIterable.forEach(iterableAsList::add);

        List<Tire> tireList = tireService.getAllTires();

        Assertions.assertNotNull(tireList);
        Assertions.assertEquals(tireList, iterableAsList);
    }

}
