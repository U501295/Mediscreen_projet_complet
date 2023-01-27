package com.softwareacademy.projet9_front.proxy;

import com.softwareacademy.projet9_front.DTO.PatientM;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "mediscreen-sprint-1", url = "${clients.patientapiclienturl}")
public interface Sprint1Proxy {

    @GetMapping("/patients")
    List<PatientM> getPatients();

    @GetMapping("/patient/{id}")
    Optional<PatientM> getPatientById(@PathVariable("id") Long id);

    @PostMapping("/patient/add")
    public ResponseEntity<Object> addPatient(@RequestBody PatientM patient);

    @PutMapping("/patient")
    public PatientM updatePatient(@RequestParam("id") Long id, @RequestBody PatientM patientUpdated);

}
