package com.JobSeaker.joblisting.repository;

import com.JobSeaker.joblisting.entity.JobDescription;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class JobRepostitoryExtraMethodImps implements JobRepostitoryExtraMethod{
   @Autowired
    MongoClient mongoClient;
   @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<JobDescription> findByText(String text) {
      final List<JobDescription> jobs=new ArrayList<>();
        
        MongoDatabase database = mongoClient.getDatabase("JobSeaker");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
                 new Document("text", new Document("query", text)                       
                .append("path", Arrays.asList("techs", "desc", "profile"))))                
                , new Document("$sort"
                , new Document("exp", 1L))
                , new Document("$limit", 5L)));
        for (Document doc : result) {
            jobs.add(mongoConverter.read(JobDescription.class, doc));
        }
        return jobs;
    }
}
