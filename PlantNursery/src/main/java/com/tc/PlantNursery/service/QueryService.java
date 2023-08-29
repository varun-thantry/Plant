package com.tc.PlantNursery.service;

import com.tc.PlantNursery.entity.Query;
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
        Query query = new Query();
        query.setUser(user);
        query.setQueryDesc(queryDesc);
        query.setQueryStatus(false); // Assuming it's initially not answered
        queryRepository.save(query);
    }

    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }

    public void answerQuery(Long queryId, String answer) {
        Optional<Query> optionalQuery = queryRepository.findById(queryId);
        if (optionalQuery.isPresent()) {
            Query query = optionalQuery.get();
            query.setQueryAnswer(answer);
            query.setQueryStatus(true); // Mark as answered
            queryRepository.save(query);
        }
    }
}
