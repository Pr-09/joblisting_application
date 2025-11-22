package com.JobSeaker.joblisting.service;

import com.JobSeaker.joblisting.entity.JobDescription;
import com.JobSeaker.joblisting.repository.JobRepository;

import com.JobSeaker.joblisting.repository.JobRepostitoryExtraMethodImps;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

@Autowired
JobRepository jobRepository;
@Autowired
JobRepostitoryExtraMethodImps jobRepostitoryExtraMethodImps;

public JobDescription savePost(JobDescription post){
    return jobRepository.save(post);
}
public List<JobDescription> findAllPosts(){
    return jobRepository.findAll();
}

public List<JobDescription> searchByText(String text){
    return jobRepostitoryExtraMethodImps.findByText(text);
}
}
