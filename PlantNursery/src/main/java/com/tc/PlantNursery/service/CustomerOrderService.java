package com.tc.PlantNursery.service;

import com.tc.PlantNursery.entity.CustomerOrder;
import com.tc.PlantNursery.entity.OrderStatus;
import com.tc.PlantNursery.repository.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    public List<CustomerOrder> showAllOrders(){
        return customerOrderRepo.findAll();
    }

    /*------------------- Nursery staff ----------------------*/
    public boolean updateOrderStatus(Long oid, OrderStatus orderStatus){
        CustomerOrder customerOrder = customerOrderRepo.findById(oid).orElse(null);

        if(customerOrder != null){
            customerOrder.setOrderStatus(orderStatus);
            customerOrderRepo.save(customerOrder);
            return true;
        }else {
            return false;
        }


    }
}
