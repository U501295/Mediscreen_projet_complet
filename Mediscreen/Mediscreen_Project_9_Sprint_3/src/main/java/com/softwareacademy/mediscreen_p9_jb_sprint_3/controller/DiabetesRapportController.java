package com.softwareacademy.mediscreen_p9_jb_sprint_3.controller;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.Assess;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.Patient;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.PatientHistory;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.DiabetesRapportService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.PatientHistoryService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.PatientService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.RiskFactorsService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.utils.AgeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiabetesRapportController {

    @Autowired
    RiskFactorsService riskFactorsService;

    @Autowired
    DiabetesRapportService diabetesRapportService;

    @Autowired
    PatientHistoryService patientHistoryService;

    @Autowired
    PatientService patientService;

    AgeCalculator ageCalculator;

    public DiabetesRapportController(PatientHistoryService patientHistoryService, PatientService patientService) {
        this.patientHistoryService = patientHistoryService;
        this.patientService = patientService;
    }

    @GetMapping("/assess")
    public Assess getPatientAssess(@RequestParam("id") Long id) {
        PatientHistory patientHistory = patientHistoryService.getPatientsHistoryById(id);
        Patient patient = patientService.getPatientById(id);
        int age = AgeCalculator.calculateAge(patient.getBirthdate());
        String diabetesRapport = diabetesRapportService.diabetesRapport(age, riskFactorsService.getRiskFactorsCount(patientHistory.getNotes()), patient.getGender());

        return new Assess(id, age, diabetesRapport);
    }

    @GetMapping("/assess/{id}")
    public Assess getPatientAssessById(@PathVariable("id") Long id) {
        PatientHistory patientHistory = patientHistoryService.getPatientsHistoryById(id);
        Patient patient = patientService.getPatientById(id);
        int age = AgeCalculator.calculateAge(patient.getBirthdate());
        String diabetesRapport = diabetesRapportService.diabetesRapport(age, riskFactorsService.getRiskFactorsCount(patientHistory.getNotes()), patient.getGender());
        return new Assess(id, age, diabetesRapport);
    }

}
