package com.org.cts.controller;

import com.org.cts.model.Hospital;
import com.org.cts.model.Hostel;
import com.org.cts.service.HostelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HostelControllerTest {
    @InjectMocks
    private HostelController hostelController;
    @Mock
    private HostelService hostelService;

    @Test
    void createHostel() {
        Hostel hostel = new Hostel();
        hostel.setId(100);
        hostel.setName("siri");
        hostel.setHostelFee(6345.0);
        hostel.setHostelAddress("blr");
        hostelController.createHostel(hostel);
        Mockito.verify(hostelService, Mockito.times(1)).createHostel(hostel);
    }

    @Test
    void updateHostel() {
        Hostel hostel = new Hostel();
        hostel.setId(100);
        hostel.setName("siri");
        hostel.setHostelFee(6345.0);
        hostel.setHostelAddress("blr");
        hostelController.updateHostel(hostel);
        Mockito.verify(hostelService, Mockito.times(1)).updateHostel(hostel);
    }

    @Test
    void getAll() {
        List<Hostel> list = new ArrayList<>();
        Hostel hostel = new Hostel();
        hostel.setId(100);
        hostel.setName("siri");
        hostel.setHostelFee(6345.0);
        hostel.setHostelAddress("blr");
        list.add(hostel);
        Hostel hostel1 = new Hostel();
        hostel1.setId(101);
        hostel1.setName("siri");
        hostel1.setHostelFee(6345.0);
        hostel1.setHostelAddress("blr");
        list.add(hostel1);
        Mockito.when(hostelService.getAll()).thenReturn(list);
        List<Hostel> list1 = hostelController.getAll();
        Assertions.assertEquals(list.size(), list1.size());
    }

    @Test
    void deleteById() {
        int id = 100;
        String value = "ss";
        Mockito.when(hostelService.deleteById(id)).thenReturn(value);
        String value2 = hostelController.deleteById(id);
        Assertions.assertEquals(value, value2);
    }

    @Test
    void updateNameById() {
        int id = 100;
        String name = "siri";
        String value = "ss";
        Mockito.when(hostelService.updateNameById(id, name)).thenReturn(value);
        String value2 = hostelController.updateNameById(id, name);
        Assertions.assertEquals(value, value2);
    }

    @Test
    void getByName() {
        String name = "siri";
        Hostel hostel = new Hostel();
        hostel.setId(100);
        hostel.setName("siri");
        hostel.setHostelFee(6345.0);
        hostel.setHostelAddress("blr");
        Mockito.when(hostelService.getByName(name)).thenReturn(hostel);
        Hostel hostel1 = hostelController.getByName(name);
        Assertions.assertEquals(hostel, hostel1);
    }

    @Test
    void hostelFeeBasedOnHostelAddress() {
        String hostelAddress = "blr";
        String value = "ss";
        Mockito.when(hostelService.hostelFeeBasedOnHostelAddress(hostelAddress)).thenReturn(value);
        String value2 = hostelController.hostelFeeBasedOnHostelAddress(hostelAddress);
        Assertions.assertEquals(value, value2);
    }

    @Test
    void updateHostelAddressBasedOnId() {
        int id = 100;
        String hostelAddress = "blr";
        String value = "ss";
        Mockito.when(hostelService.updateHostelAddressBasedOnId(id, hostelAddress)).thenReturn(value);
        String value2 = hostelController.updateHostelAddressBasedOnId(id, hostelAddress);
        Assertions.assertEquals(value, value2);
    }

    @Test
    void getByHostelAddress() {
        String hostelAddress = "blr";
        int value = 1;
        Mockito.when(hostelService.getByHostelAddress(hostelAddress)).thenReturn(value);
        int value2 = hostelController.getByHostelAddress(hostelAddress);
        Assertions.assertEquals(value, value2);
    }

}