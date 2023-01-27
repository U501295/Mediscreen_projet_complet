package com.softwareacademy.projet9_front.proxy;

import com.softwareacademy.projet9_front.DTO.HistoryM;
import com.softwareacademy.projet9_front.DTO.NoteM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@FeignClient(name = "mediscreen-sprint-2", url = "${clients.patientnoteapiclienturl}")
    public interface Sprint2Proxy {

    @GetMapping("/patientHistory/{id}")
    public Optional<HistoryM> getHistoryById(@PathVariable("id") Long id);

    @GetMapping("/noteDate/{id}/{creationDate}")
    public NoteM getNoteByCreationDate(@PathVariable("id") Long id, @PathVariable("creationDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate creationDate);

    @PostMapping("/patientHistory/add")
    public ResponseEntity<Object> addPatientHistory(@RequestBody HistoryM patientHistory);

    @PutMapping("/patientHistory")
    public ResponseEntity<Object> updateOrAddNote(@RequestParam("id") Long id, @RequestBody NoteM note);
}
