package com.JobSeaker.joblisting.repository;

import com.JobSeaker.joblisting.entity.JobDescription;

import java.util.List;

public interface JobRepostitoryExtraMethod {
    List<JobDescription> findByText(String text);
}
