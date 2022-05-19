package com.org.cts.repository;

import com.org.cts.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HostelRepo extends JpaRepository<Hostel,Integer> {
    @Transactional
    Hostel getByName(String name);

    @Transactional
    List<Hostel> findByHostelAddress(String HostelAddress) ;
    @Transactional
    List<Hostel> getByHostelAddress(String hostelAddress);


}
