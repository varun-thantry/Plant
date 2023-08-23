package com.tc.PlantNursery.repository;

import com.tc.PlantNursery.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Long> {
}
