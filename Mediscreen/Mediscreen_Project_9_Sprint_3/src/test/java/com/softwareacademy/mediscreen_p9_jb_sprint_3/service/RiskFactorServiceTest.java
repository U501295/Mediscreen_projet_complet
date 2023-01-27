package com.softwareacademy.mediscreen_p9_jb_sprint_3.service;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.Notes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RiskFactorServiceTest {
    @Autowired
    private RiskFactorsService riskFactorsService;

    private static Notes testNotes;
    private static List<Notes> testListNotes;

    @BeforeAll
    public static void setUpNotes() {
        LocalDate creationDate = LocalDate.of(2022, 8, 15);
        String notes = "HEMOGLOBIN A1C MICROALBUMIN HEIGHT WEIGHT SMOKE ABNORMAL CHOLESTEROL DIZZINESS RELAPSE REACTION ANTIBODIES";

        testNotes = new Notes(creationDate, notes);

        testListNotes = new ArrayList<>();
        testListNotes.add(testNotes);
    }

    @Test
    final void testGetRiskFactorsCount() {
        int count = riskFactorsService.getRiskFactorsCount(testListNotes);
        assertThat(count).isEqualTo(11);
    }
}
