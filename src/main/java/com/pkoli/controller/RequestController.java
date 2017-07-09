package com.pkoli.controller;

import com.pkoli.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pkoli on 9/7/17.
 */
@RestController
public class RequestController {

    @Autowired
    private RequestService service;

    @GetMapping(value = "/request")
    public String fireRequest(){
        return service.fireRequest();
    }
}
