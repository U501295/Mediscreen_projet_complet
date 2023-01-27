package com.softwareacademy.mediscreen_p9_jb_sprint_3.service;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.constants.Constants;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.Notes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskFactorsService {

    public int getRiskFactorsCount(List<Notes> patientNotes) {
        int count = 0;
        for(Notes note : patientNotes) {
            String text = note.getContent().toLowerCase();
            count += Constants.riskFactors.stream().filter(riskFactors -> text.contains(riskFactors.toLowerCase())).count();
        }

        return count;
    }

}