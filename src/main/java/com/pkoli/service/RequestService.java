package com.pkoli.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkoli.entity.EmployeeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by pkoli on 9/7/17.
 */
@Service
public class RequestService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${remote.url}")
    private String url;

    public String fireRequest() {

        PodamFactory factory = new PodamFactoryImpl();

        EmployeeSchema employee = factory.manufacturePojo(EmployeeSchema.class);
        HttpEntity entity = new HttpEntity(employee);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        if(200 == responseEntity.getStatusCode().value())
            return employee.toString();

        return "Fail";
    }

}
