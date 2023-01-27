package com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;


//@FeignClient(value = "mediscreen-sprint-2", url = "http://localhost:8082")
public interface PatientHistoryProxy {

    @RequestLine("GET /allPatientsHistory")
    //@RequestMapping(method = RequestMethod.GET, value = "/allPatientsHistory")
    List<PatientHistory> getAllPatientsHistories();

    @RequestLine("GET /patientHistory?firstName={firstName}&lastName={lastName}")
    @Headers("Content-Type: application/json")
    @RequestMapping(method = RequestMethod.GET, value = "/patientHistory?firstName={firstName}&lastName={lastName}")
    PatientHistory getPatientHistoryByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @RequestLine("GET /patientHistory/{id}")
    @Headers("Content-Type: application/json")
    //@RequestMapping(method = RequestMethod.GET, value = "/patientHistory/{id}")
    PatientHistory getPatientHistoryById(@Param("id") Long id);
}
