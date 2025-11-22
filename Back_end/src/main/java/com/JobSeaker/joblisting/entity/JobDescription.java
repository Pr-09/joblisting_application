package com.JobSeaker.joblisting.entity;

import lombok.Getter;
import lombok.Setter;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


@Document(collection = "JobPost")
@Getter
@Setter

public class JobDescription {

    private String profile;
    private String desc;
    private int exp;
    private String techs[];

}
