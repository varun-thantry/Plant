package com.tc.PlantNursery.repository;

import com.tc.PlantNursery.entity.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

    @Query("SELECT c FROM Cart c WHERE c.user.id = :uid")
    List<Cart> getCartByUserId(Long uid);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cart WHERE uid = :uid AND pid = :pid", nativeQuery = true)
    void deleteByUserAndProduct(Long uid, Long pid);

    @Query(value = "SELECT * FROM cart WHERE uid = :uid AND pid = :pid", nativeQuery = true)
    Cart findByUserAndProduct(Long uid, Long pid);


    void deleteByUserId(Long uid);
    
}
