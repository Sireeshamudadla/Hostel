package com.org.cts.service;

import com.org.cts.model.Hostel;
import com.org.cts.repository.HostelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HostelServiceImplTest {
    @InjectMocks
   private HostelServiceImpl hostelServiceImpl;
    @Mock
   private HostelRepo  hostelRepo;

    @Test
    void createHostel() {
     Hostel hostel =new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(6345.0);
     hostel.setHostelAddress("blr");
     hostelServiceImpl.createHostel(hostel);
     Mockito.verify(hostelRepo,Mockito.times(1)).save(hostel);
    }

    @Test
    void updateHostel() {
     Hostel hostel =new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(6345.0);
     hostel.setHostelAddress("blr");
     hostelServiceImpl.updateHostel(hostel);
     Mockito.verify(hostelRepo,Mockito.times(1)).save(hostel);

    }

    @Test
    void getAll() {
     List<Hostel> list = new ArrayList<>();
     Hostel hostel =new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(6345.0);
     hostel.setHostelAddress("blr");
     list.add(hostel);
     Hostel hostel1 =new Hostel();
     hostel1.setId(101);
     hostel1.setName("siri");
     hostel1.setHostelFee(6345.0);
     hostel1.setHostelAddress("blr");
     list.add(hostel1);
     Mockito.when(hostelRepo.findAll()).thenReturn(list);
     List<Hostel> list2= hostelServiceImpl.getAll();
     Assertions.assertEquals(list.size(),list2.size());
    }

    @Test
    void deleteById() {
     Integer id=100;
     String value="success";
   String value2=  hostelServiceImpl.deleteById(id);
   Assertions.assertEquals(value,value2);
    }

    @Test
    void updateNameById() {
     int id=100;
     String name="siri";
     String value = "update success";
     Hostel hostel=new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(900.0);
     hostel.setHostelAddress("blr");
     Optional<Hostel> hostel1=Optional.of(hostel);
     Mockito.when(hostelRepo.findById(id)).thenReturn(hostel1);
     String value2=hostelServiceImpl.updateNameById(id,name);
     Assertions.assertEquals(value,value2);
     Mockito.verify(hostelRepo,Mockito.times(1)).save(hostel);

    }

    @Test
    void getByName() {
     String name="siri";
     Hostel hostel=new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(900.0);
     hostel.setHostelAddress("blr");
     Mockito.when(hostelRepo.getByName(name)).thenReturn(hostel);
     Hostel hostel1=hostelServiceImpl.getByName(name);
     Assertions.assertEquals(hostel,hostel1);
    }

    @Test
    void hostelFeeBasedOnHostelAddress() {
     String HostelAddress="blr";
     String value= "update successfully";
     List<Hostel> hostellist=new ArrayList<>();
     Hostel hostel=new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(900.0);
     hostel.setHostelAddress("blr");
    hostellist.add(hostel);
     Mockito.when( hostelRepo.findByHostelAddress(HostelAddress)).thenReturn(hostellist);
    String value2= hostelServiceImpl.hostelFeeBasedOnHostelAddress(HostelAddress);
     Assertions.assertEquals(value,value2);
    }

    @Test
    void updateHostelAddressBasedOnId() {
     int id=100;
     String hostelAddress="blr";
     String value="update successfully";
     Hostel hostel=new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(900.0);
     hostel.setHostelAddress("blr");
     Optional<Hostel> optional=Optional.of(hostel);
     Mockito.when(hostelRepo.findById(id)).thenReturn(optional);
     String value2=hostelServiceImpl.updateHostelAddressBasedOnId(id,hostelAddress);
     Assertions.assertEquals(value,value2);
    }

    @Test
    void getByHostelAddress() {
     String hostelAddress="blr";
     List<Hostel> hostellist=new ArrayList<>();
     Hostel hostel=new Hostel();
     hostel.setId(100);
     hostel.setName("siri");
     hostel.setHostelFee(900.0);
     hostel.setHostelAddress("blr");
     hostellist.add(hostel);
     int value2=hostellist.size();
     Mockito.when(hostelRepo. getByHostelAddress( hostelAddress)).thenReturn(hostellist);
      int value=hostelServiceImpl.getByHostelAddress(hostelAddress);
      Assertions.assertEquals(value,value2);
    }
}