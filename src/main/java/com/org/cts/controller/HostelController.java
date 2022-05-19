package com.org.cts.controller;

import com.org.cts.model.Hospital;
import com.org.cts.model.Hostel;
import com.org.cts.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class HostelController {
    @Autowired
    HostelService hostelService;

    @PostMapping("/create")
    public void createHostel(@RequestBody Hostel hostel){

        hostelService.createHostel(hostel);
    }
    @PutMapping("/update")
    public void updateHostel(@RequestBody Hostel hostel){
        hostelService.updateHostel(hostel);
    }

     @GetMapping("/getAll")
    public List<Hostel> getAll(){
         List<Hostel>kk=   hostelService.getAll();
         return kk;
     }
     @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
         String ss=   hostelService.deleteById(id);
        return ss;
     }
     @PatchMapping("/updateNameById/{id}/{name}")
     public String updateNameById(@PathVariable Integer id,@PathVariable String name) {
        String ss= hostelService.updateNameById(id,name);
       return ss;
     }
     @GetMapping("/getByName/{name}")
    public Hostel getByName(@PathVariable String name){
         Hostel hostel=   hostelService.getByName(name);
        return  hostel;
     }
     @PutMapping("/updateHostelFeeBasedOnHostelAddress/{HostelAddress}")
    public String hostelFeeBasedOnHostelAddress(@PathVariable String hostelAddress){
        String gg=    hostelService.hostelFeeBasedOnHostelAddress(hostelAddress);
      return gg;
     }

     @PutMapping("/updateHostelAddressBasedOnId/{id}/{address}")
    public String updateHostelAddressBasedOnId(@PathVariable Integer id ,@PathVariable String hostelAddress){
         String ss=    hostelService.updateHostelAddressBasedOnId(id,hostelAddress);
         return ss;
     }
     @GetMapping("/getByAddress/{hostelAddress}")
    public int getByHostelAddress(@PathVariable String hostelAddress){
         int k=   hostelService.getByHostelAddress(hostelAddress);
         return k;
     }

    @GetMapping("/getAllHospitalPeople")
    public List<Hospital> getAllHospitalPeople(){
        List<Hospital> list =   hostelService.getAllHospitalPeople();
        return list;
    }
}


