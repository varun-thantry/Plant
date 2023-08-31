package com.tc.PlantNursery.controller;

import com.tc.PlantNursery.entity.Queries;
import com.tc.PlantNursery.entity.User;
import com.tc.PlantNursery.repository.UserRepo;
import com.tc.PlantNursery.service.QueryService;
import com.tc.PlantNursery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> postQuery(@RequestBody Queries queryRequest) {
        Long userId = queryRequest.getId(); //id of the user to be provided in json
        User user = userRepo.findById(userId).orElse(null);
        queryService.postQuery(user, queryRequest.getQueryDesc());
        return ResponseEntity.ok("Query posted successfully");
    }

    @GetMapping("/staff/getAllQueries")
    public List<Queries> getAllQueries() {
        return queryService.getAllQueries();

    }

    @GetMapping("/getAllQueries/true")
    public List<Queries> getAllTrueQueries() {
        return queryService.getAllQueriesByStatus(true);
    }

    @GetMapping("/getAllQueries/false")
    public List<Queries> getAllFalseQueries() {
        return queryService.getAllQueriesByStatus(false);
    }

    @PostMapping("/staff/answer")
    public ResponseEntity<String> answerQuery(@RequestBody Queries answerRequest) {
        queryService.answerQuery(answerRequest.getId(), answerRequest.getQueryAnswer());// id of query to be given in json
        return ResponseEntity.ok("Query answered successfully");
    }

    @GetMapping("/customer/getUserQueries/{uid}")
    public List<Queries> getUserQueries(@PathVariable Long uid){
        return queryService.getUserQueries(uid);
    }

    @GetMapping("/customer/getUserQueries/true/{userId}")
    public List<Queries> getAllTrueQueriesForUser(@PathVariable Long userId) {
        return queryService.getAllQueriesByStatusForUser(userId, true);
    }

    @GetMapping("/customer/getUserQueries/false/{userId}")
    public List<Queries> getAllFalseQueriesForUser(@PathVariable Long userId) {
        return queryService.getAllQueriesByStatusForUser(userId, false);
    }
}
