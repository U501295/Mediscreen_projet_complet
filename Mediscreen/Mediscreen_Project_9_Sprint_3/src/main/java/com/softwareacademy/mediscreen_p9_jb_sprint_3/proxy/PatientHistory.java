package com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientHistory {

    private Long patientId;
    private String firstName;
    private String lastName;
    private List<Notes> notes;


}