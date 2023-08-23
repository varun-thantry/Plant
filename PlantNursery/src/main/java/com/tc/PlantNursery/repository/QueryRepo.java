package com.tc.PlantNursery.repository;

import com.tc.PlantNursery.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepo extends JpaRepository<Query,Long> {

}
