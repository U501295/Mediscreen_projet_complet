package com.softwareacademy.projet9_front.proxy;

import com.softwareacademy.projet9_front.DTO.AssessM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mediscreen-sprint-3", url = "${clients.patientassessapiclienturl}")
public interface Sprint3Proxy {

    @GetMapping("/assess?firstName={firstName}&lastName={lastName}")
    AssessM getDiabeteResultByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName);

    @GetMapping("/assess/{id}")
    AssessM getDiabeteResultById(@PathVariable Long id);

}
