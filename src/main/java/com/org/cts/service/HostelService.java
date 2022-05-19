package com.org.cts.service;

import com.org.cts.model.Hospital;
import com.org.cts.model.Hostel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface HostelService {
    public void createHostel(Hostel hostel);
    public void updateHostel(Hostel hostel);
    public List<Hostel> getAll();
    public String deleteById( Integer id);
    public String updateNameById(Integer id, String name);
    public Hostel getByName( String name);
    public String hostelFeeBasedOnHostelAddress( String HostelAddress);
    public String updateHostelAddressBasedOnId( Integer id, String hostelAddress);
    public int getByHostelAddress( String hostelAddress);

    public List<Hospital> getAllHospitalPeople();
    }
