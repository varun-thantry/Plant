package com.tc.PlantNursery.service;

import com.tc.PlantNursery.entity.Queries;
import com.tc.PlantNursery.entity.User;
import com.tc.PlantNursery.repository.QueryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QueryService {

    @Autowired
    private QueryRepo queryRepository;

    public void postQuery(User user, String queryDesc) {
        Queries query = new Queries();
        query.setUser(user);
        query.setQueryDesc(queryDesc);
        query.setQueryStatus(false); // Assuming it's initially not answered
        queryRepository.save(query);
    }

    public List<Queries> getAllQueries() {
        return queryRepository.findAll();
    }

    public List<Queries> getAllQueriesByStatus(Boolean queryStatus) {
        return queryRepository.findByQueryStatus(queryStatus);
    }

    public void answerQuery(Long queryId, String answer) {
        Optional<Queries> optionalQuery = queryRepository.findById(queryId);
        if (optionalQuery.isPresent()) {
            Queries query = optionalQuery.get();
            query.setQueryAnswer(answer);
            query.setQueryStatus(true); // Mark as answered
            queryRepository.save(query);
        }
    }

    public List<Queries> getUserQueries(Long uid) {
        return queryRepository.findByUserId(uid);
    }

    public List<Queries> getAllQueriesByStatusForUser(Long userId, Boolean queryStatus) {
        return queryRepository.findByUserIdAndQueryStatus(userId, queryStatus);
    }
}
