package com.tc.PlantNursery.controller;

import com.tc.PlantNursery.entity.CustomerOrder;
import com.tc.PlantNursery.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customer/getOrders/{uid}")
    public List<CustomerOrder> showUserOrders(@PathVariable Long uid){
        return customerOrderService.showUserOrders(uid);
    }

    @GetMapping("/staff/getAllOrders")
    public List<CustomerOrder> showAllOrders(){
        return customerOrderService.showAllOrders();
    }

    /*-------------------Nursery staff controllers----------------------*/
    @PatchMapping("/staff/updateOrderStatus")
    public ResponseEntity<String> updateOrderStatus(@RequestBody CustomerOrder customerOrder){
        if(customerOrder.getId() == null || customerOrder.getOrderStatus() == null){
            return ResponseEntity.badRequest().body("Order id and updated status are required");
        }

        boolean success = customerOrderService.updateOrderStatus(customerOrder.getId(), customerOrder.getOrderStatus());

        if (success) {
            return ResponseEntity.ok("Updated the Order status successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update the Order status");
        }
    }
}
