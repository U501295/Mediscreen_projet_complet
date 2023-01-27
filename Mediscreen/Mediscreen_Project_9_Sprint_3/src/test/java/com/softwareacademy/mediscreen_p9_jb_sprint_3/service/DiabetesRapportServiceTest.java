package com.softwareacademy.mediscreen_p9_jb_sprint_3.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiabetesRapportServiceTest {

    @Autowired
    private DiabetesRapportService diabetesRapportService;

    @Test
    final void testDiabetesRapport() {

        String diabetesRapport1 = diabetesRapportService.diabetesRapport(5, 0, "M");
        assertThat(diabetesRapport1).isEqualTo("None");

        String diabetesRapport2 = diabetesRapportService.diabetesRapport(5, 2, "M");
        assertThat(diabetesRapport2).isEqualTo("None");

        String diabetesRapport21 = diabetesRapportService.diabetesRapport(45, 2, "M");
        assertThat(diabetesRapport21).isEqualTo("Borderline");

        String diabetesRapport3 = diabetesRapportService.diabetesRapport(5, 3, "M");
        assertThat(diabetesRapport3).isEqualTo("In Danger");

        String diabetesRapport31 = diabetesRapportService.diabetesRapport(5, 3, "F");
        assertThat(diabetesRapport31).isEqualTo("None");

        String diabetesRapport32 = diabetesRapportService.diabetesRapport(45, 3, "M");
        assertThat(diabetesRapport32).isEqualTo("Borderline");

        String diabetesRapport4 = diabetesRapportService.diabetesRapport(5, 4, "M");
        assertThat(diabetesRapport4).isEqualTo("In Danger");

        String diabetesRapport41 = diabetesRapportService.diabetesRapport(45, 4, "M");
        assertThat(diabetesRapport41).isEqualTo("Borderline");

        String diabetesRapport5 = diabetesRapportService.diabetesRapport(5, 5, "M");
        assertThat(diabetesRapport5).isEqualTo("Early onset");

        String diabetesRapport51 = diabetesRapportService.diabetesRapport(5, 5, "F");
        assertThat(diabetesRapport51).isEqualTo("In Danger");

        String diabetesRapport52 = diabetesRapportService.diabetesRapport(45, 5, "M");
        assertThat(diabetesRapport52).isEqualTo("Borderline");

        String diabetesRapport6 = diabetesRapportService.diabetesRapport(5, 6, "M");
        assertThat(diabetesRapport6).isEqualTo("Early onset");

        String diabetesRapport61 = diabetesRapportService.diabetesRapport(45, 6, "M");
        assertThat(diabetesRapport61).isEqualTo("In Danger");

        String diabetesRapport62 = diabetesRapportService.diabetesRapport(5, 6, "F");
        assertThat(diabetesRapport62).isEqualTo("In Danger");

        String diabetesRapport7 = diabetesRapportService.diabetesRapport(5, 7, "M");
        assertThat(diabetesRapport7).isEqualTo("Early onset");

        String diabetesRapport71 = diabetesRapportService.diabetesRapport(45, 7, "M");
        assertThat(diabetesRapport71).isEqualTo("In Danger");

        String diabetesRapport8 = diabetesRapportService.diabetesRapport(5, 8, "M");
        assertThat(diabetesRapport8).isEqualTo("Early onset");
    }

}
