package com.tc.PlantNursery.repository;

import com.tc.PlantNursery.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Long> {
    List<CustomerOrder> findByUser_Id(Long uid);
}
