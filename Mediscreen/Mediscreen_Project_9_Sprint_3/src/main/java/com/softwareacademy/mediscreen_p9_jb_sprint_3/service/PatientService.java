package com.softwareacademy.mediscreen_p9_jb_sprint_3.service;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.Patient;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientProxy proxy;

    public List<Patient> getAllPatients() {
        return proxy.getAllPatients();
    }

    public Patient getPatientById(Long id) {
        return proxy.getPatientById(id);
    }
}
