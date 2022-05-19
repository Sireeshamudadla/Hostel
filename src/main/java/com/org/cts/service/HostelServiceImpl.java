package com.org.cts.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.cts.model.Hospital;
import com.org.cts.model.Hostel;
import com.org.cts.repository.HostelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HostelServiceImpl implements HostelService {
    @Autowired
    HostelRepo  hostelRepo;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Override
    public void createHostel(Hostel hostel) {
        hostelRepo.save(hostel);
    }

    @Override
    public void updateHostel(Hostel hostel) {
        hostelRepo.save(hostel);
    }

    @Override
    public List<Hostel> getAll() {
        List<Hostel> ll=  hostelRepo.findAll();
        return ll;
    }

    @Override
    public String deleteById(Integer id) {
        hostelRepo.deleteById(id);
        return "success";
    }

    @Override
    public String updateNameById(Integer id, String name) {
        Optional<Hostel> hostel=hostelRepo.findById(id);
        Hostel hostel1=hostel.get();
        hostel1.setName(name);
        hostelRepo.save(hostel1);
        return "update success";
    }

    @Override
    public Hostel getByName(String name) {
        Hostel hh=  hostelRepo.getByName(name);
        return hh;
    }

    @Override
    public String hostelFeeBasedOnHostelAddress(String HostelAddress) {
        List<Hostel> hostellist = hostelRepo.findByHostelAddress(HostelAddress);
        for (int i = 0; i < hostellist.size(); i++) {
            Hostel hostel = hostellist.get(i);
            hostel.setHostelFee(hostel.getHostelFee() * 2);
            hostelRepo.save(hostel);
        }return "update successfully";
    }
    @Override
    public String updateHostelAddressBasedOnId(Integer id, String hostelAddress) {
        Optional<Hostel> optional=hostelRepo.findById(id);
        Hostel hostel=optional.get();
        hostel.setHostelAddress(hostelAddress);
        hostelRepo.save(hostel);
        return "update successfully";
    }
    @Override
    public int getByHostelAddress(String hostelAddress) {
        List<Hostel> hostellist =hostelRepo. getByHostelAddress( hostelAddress);
        int i = hostellist.size();
        return i;
    }

    @Override
    public List<Hospital> getAllHospitalPeople() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String body = restTemplate().exchange("http://localhost:8980/api/getAll", HttpMethod.GET, entity, String.class).getBody();

        ObjectMapper mapper=new ObjectMapper();
        List<Hospital> hospitalList=null;
        try {
            hospitalList = mapper.readValue(body, new TypeReference<List<Hospital>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return hospitalList;
    }
}
