package com.softwareacademy.mediscreen_p9_jb_sprint_3.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {

    public static int calculateAge(LocalDate birthDate) {
        return (int) birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
    }

}
