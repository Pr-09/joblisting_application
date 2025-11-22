package com.JobSeaker.joblisting.repository;

import com.JobSeaker.joblisting.entity.JobDescription;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface JobRepository extends MongoRepository<JobDescription,String> {

}