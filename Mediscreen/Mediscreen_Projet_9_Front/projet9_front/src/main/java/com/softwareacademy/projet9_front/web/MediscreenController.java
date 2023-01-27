package com.softwareacademy.projet9_front.web;

import com.softwareacademy.projet9_front.DTO.*;
import com.softwareacademy.projet9_front.service.Sprint1Service;
import com.softwareacademy.projet9_front.service.Sprint2Service;
import com.softwareacademy.projet9_front.service.Sprint3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Mediscreen")
public class MediscreenController {

    @Autowired
    Sprint3Service sprint3Service;
    @Autowired
    Sprint2Service sprint2Service;
    @Autowired
    Sprint1Service sprint1Service;

    @GetMapping("/welcome")
    public String getWelcomePage() {
        return "Mediscreen/welcome";
    }

    @GetMapping("/home")
    public String getPaginatedString(Model model) {
        PatientsM patients = new PatientsM();
        patients.setPatientsM(sprint1Service.getPatients());
        model.addAttribute("patients", patients);
        return "Mediscreen/home";
    }

    @GetMapping("/AddPatient")
    public String addPatient(Model model) {
        PatientsM patients = new PatientsM();
        patients.setPatientsM(sprint1Service.getPatients());
        model.addAttribute("patients", patients);
        return "Mediscreen/addPatient";
    }

    @GetMapping("/info/{id}")
    public String getPaginatedString(Model model,@PathVariable("id") Long patientId){
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);
        return "Mediscreen/info";
    }

    @GetMapping("/addNote/{id}")
    public String addNote(Model model,@PathVariable("id") Long patientId){
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);

        return "Mediscreen/addNote";
    }

    @GetMapping("/modify/{id}")
    public String modifyPage(Model model,@PathVariable("id") Long patientId){
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);

        return "Mediscreen/modify";
    }

    @PostMapping("/modify/{id}")
    public String modifyPatientInfos(@PathVariable("id") Long patientId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("birthdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdate, @RequestParam("gender") String gender, @RequestParam("phone") String phone, @RequestParam("address") String address){
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        PatientM patientUpdated = new PatientM(firstName,lastName,birthdate,gender,phone,address);
        sprint1Service.updatePatient(patient.getId(),patientUpdated);
        return "redirect:/Mediscreen/info/{id}";
    }

    @PostMapping("/home/addpatient")
    public String addTransferApp(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("birthdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdate, @RequestParam("gender") String gender, @RequestParam("phone") String phone, @RequestParam("address") String address, Model model) {

        PatientM newPatient = new PatientM();
        newPatient.setFirstName(firstName);
        newPatient.setLastName(lastName);
        newPatient.setBirthdate(birthdate);
        newPatient.setGender(gender);
        newPatient.setPhone(phone);
        newPatient.setAddress(address);

        NoteM emptyNote = new NoteM("Début du suivi du patient");
        List<NoteM> emptyNoteList = new ArrayList<>();
        emptyNoteList.add(emptyNote);

        sprint1Service.addPatient(newPatient);
        newPatient.setId(sprint1Service.getPatients().get(sprint1Service.getPatients().size()-1).getId());
        sprint2Service.addPatientHistory(new HistoryM(newPatient.getId(), newPatient.getFirstName(), newPatient.getLastName(), emptyNoteList));
        return "redirect:/Mediscreen/home";

    }

    @PostMapping("/info/note/{id}")
    public String createNote(@PathVariable("id") Long patientId,@RequestParam("content") String content,Model model) {
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);
        model.addAttribute("newLineChar", '\n');
        NoteM noteToBePublished = new NoteM(content);
        sprint2Service.updateOrAddNote(patient.getId(), noteToBePublished);
        return "redirect:/Mediscreen/info/{id}";

    }

    @GetMapping("/info/updateNote/{id}/{creationDate}")
    public String updateNotePage(@PathVariable("id") Long patientId,Model model, @PathVariable("creationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate creationDate) {
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        NoteM noteDate = sprint2Service.getNoteByCreationDate(patientId,creationDate);
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);
        model.addAttribute("note",noteDate);
        return "Mediscreen/updateNote";

    }
    @PostMapping("/info/updateNote/{id}/{creationDate}")
    public String updateNote(@PathVariable("id") Long patientId,@PathVariable("creationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate creationDate,@RequestParam("content") String content,Model model) {
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);
        NoteM noteToBePublished = new NoteM(creationDate,content);
        sprint2Service.updateOrAddNote(patient.getId(), noteToBePublished);
        return "redirect:/Mediscreen/info/{id}";

    }



}
