package com.softwareacademy.mediscreen_p9_jb_sprint_3.service;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.PatientHistoryProxy;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.PatientHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientHistoryService {

    @Autowired
    PatientHistoryProxy proxy;

    public List<PatientHistory> getAllPatientsHistories() {
        return proxy.getAllPatientsHistories();

    }

    public PatientHistory getPatientsHistoryById(Long id) {
        return proxy.getPatientHistoryById(id);
    }
}
