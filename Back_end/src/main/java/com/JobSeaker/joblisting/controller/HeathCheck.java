package com.JobSeaker.joblisting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health_check")
public class HeathCheck {
    @GetMapping
    public String healthcheck() {
        return "Ok";
    }
}
