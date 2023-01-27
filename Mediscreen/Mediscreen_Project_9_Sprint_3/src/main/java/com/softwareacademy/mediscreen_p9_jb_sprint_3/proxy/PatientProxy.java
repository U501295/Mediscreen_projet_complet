package com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy;


import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(name = "mediscreen-sprint-1", url = "localhost:8081")
public interface PatientProxy {

    @RequestLine("GET /patient/{id}")
    //@Headers("Content-Type: application/json")
    Patient getPatientById(@Param("id") Long id);

    @RequestLine("GET /patients")
    List<Patient> getAllPatients();

}
