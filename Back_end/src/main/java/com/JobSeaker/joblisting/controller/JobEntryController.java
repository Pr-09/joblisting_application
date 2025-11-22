package com.JobSeaker.joblisting.controller;

import com.JobSeaker.joblisting.entity.JobDescription;
import com.JobSeaker.joblisting.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/job_listing")
public class JobEntryController {


    @Autowired
    JobService jobService;

    @PostMapping
    public JobDescription savePost(@RequestBody JobDescription jobDescription){
       return jobService.savePost(jobDescription);
    }
    @GetMapping
    public List<JobDescription> findAll(){
        return  jobService.findAllPosts();
    }
    @GetMapping("/{text}")
    public List<JobDescription> search(@PathVariable String text){
         return jobService.searchByText(text);
    }
}
