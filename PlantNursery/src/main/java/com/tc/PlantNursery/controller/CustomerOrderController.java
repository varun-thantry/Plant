package com.tc.PlantNursery.controller;

import com.tc.PlantNursery.entity.CustomerOrder;
import com.tc.PlantNursery.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    @PostMapping("/customer/addOrders")
    public List<CustomerOrder> saveOrder(@RequestBody List<CustomerOrder> customerOrders){
        return  customerOrderService.saveOrder(customerOrders);
    }
}
