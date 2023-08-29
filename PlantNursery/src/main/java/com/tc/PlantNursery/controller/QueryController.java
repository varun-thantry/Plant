package com.tc.PlantNursery.controller;

import com.tc.PlantNursery.entity.Query;
import com.tc.PlantNursery.entity.User;
import com.tc.PlantNursery.repository.UserRepo;
import com.tc.PlantNursery.service.QueryService;
import com.tc.PlantNursery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class QueryController {
    @Autowired
    private QueryService queryService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/customer/postQuery")
    public ResponseEntity<String> postQuery(@RequestBody Query queryRequest) {
        Long userId = queryRequest.getId(); //id of the user to be provided in json
        User user = userRepo.findById(userId).orElse(null);
        queryService.postQuery(user, queryRequest.getQueryDesc());
        return ResponseEntity.ok("Query posted successfully");
    }

    @GetMapping("/staff/getAllQueries")
    public List<Query> getAllQueries() {
        return queryService.getAllQueries();

    }

    @PostMapping("/staff/answer")
    public ResponseEntity<String> answerQuery(@RequestBody Query answerRequest) {
        queryService.answerQuery(answerRequest.getId(), answerRequest.getQueryAnswer());// id of query to be given in json
        return ResponseEntity.ok("Query answered successfully");
    }
}
