package com.tc.PlantNursery.service;

import com.tc.PlantNursery.entity.CustomerOrder;
import com.tc.PlantNursery.repository.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {
    @Autowired
    CustomerOrderRepo customerOrderRepo;

    public List<CustomerOrder> saveOrder(List<CustomerOrder> customerOrders){
        return customerOrderRepo.saveAll(customerOrders);
    }

    public List<CustomerOrder> showUserOrders(Long uid){
        return customerOrderRepo.findByUser_Id(uid);
    }
}
