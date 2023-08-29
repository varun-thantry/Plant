package com.tc.PlantNursery.repository;

import com.tc.PlantNursery.entity.Queries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepo extends JpaRepository<Queries,Long> {
    @Query("SELECT q FROM Queries q WHERE q.user.id = :uid")
    List<Queries> findByUserId(Long uid);
}
