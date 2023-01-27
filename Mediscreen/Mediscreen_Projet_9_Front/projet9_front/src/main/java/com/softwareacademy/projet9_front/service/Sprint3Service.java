package com.softwareacademy.projet9_front.service;

import com.softwareacademy.projet9_front.DTO.AssessM;
import com.softwareacademy.projet9_front.proxy.Sprint3Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sprint3Service {


    @Autowired
    Sprint3Proxy proxy;

    public AssessM getDiabeteResultByName(String firstName, String lastName){
        return proxy.getDiabeteResultByName(firstName, lastName);
    }

    public AssessM getDiabeteResultById(Long id){
        return proxy.getDiabeteResultById(id);
    }



}
