package com.softwareacademy.mediscreen_p9_jb_sprint_3.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.MediscreenP9JbSprint3Application;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.Notes;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.Patient;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.PatientHistory;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.DiabetesRapportService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.PatientHistoryService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.PatientService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.service.RiskFactorsService;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.utils.AgeCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = DiabetesRapportController.class)
class DiabetesRapportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RiskFactorsService riskFactorsService;

    @MockBean
    DiabetesRapportService diabetesRapportService;

    @MockBean
    PatientHistoryService patientHistoryService;

    @MockBean
    PatientService patientService;

    AgeCalculator ageCalculator;

    private static Notes testNotes;
    private static List<Notes> testListNotes;
    private static PatientHistory patientsHistory;
    private static Patient patient;
    private static final String diabetesRapport = "None";

    @BeforeAll
    public static void setUpPatientInfo() {
        LocalDate creationDate = LocalDate.of(2022, 8, 15);
        String notes = "Test Notes";

        testNotes = new Notes(creationDate, notes);

        testListNotes = new ArrayList<>();
        testListNotes.add(testNotes);

        patientsHistory = new PatientHistory(0L, "Test", "TestNone", testListNotes);

        LocalDate birtDate = LocalDate.of(1994, 5, 29);
        String firstName = "Jean";
        String lastName = "Michel";
        String phone = "00403";
        String sex = "M";
        String address = "address";

        patient = new Patient(0L, firstName, lastName, birtDate, sex, phone, address);

    }

    @Test
    final void testGetPatientAssessShouldReturnPatientAssess() throws Exception {
        when(patientHistoryService.getPatientsHistoryById(Mockito.anyLong())).thenReturn(patientsHistory);
        when(patientService.getPatientById(Mockito.anyLong())).thenReturn(patient);
        when(diabetesRapportService.diabetesRapport(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(diabetesRapport);
        mockMvc.perform(get("/assess").param("id", "0")).andExpect(status().isOk());
    }

    @Test
    final void testGetPatientAssessLongShouldReturnPatientAssess() throws Exception {
        when(patientHistoryService.getPatientsHistoryById(Mockito.anyLong())).thenReturn(patientsHistory);
        when(patientService.getPatientById(Mockito.anyLong())).thenReturn(patient);
        when(diabetesRapportService.diabetesRapport(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(diabetesRapport);
        mockMvc.perform(get("/assess/{id}", 0L)).andExpect(status().isOk());
    }

}
