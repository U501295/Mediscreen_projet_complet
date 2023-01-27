package com.softwareacademy.mediscreen_p9_jb_sprint_3.service;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.constants.Constants;
import org.springframework.stereotype.Service;

    @Service
    public class DiabetesRapportService {

        public String diabetesRapport(int age, int riskFactorsCount, String gender) {
            String rapport = null;

            switch (riskFactorsCount) {
                case 0:
                case 1:
                    rapport = Constants.NONE;
                    break;
                case 2:
                    if (age >= Constants.LIMIT) {
                        rapport = Constants.BORDERLINE;
                    } else {
                        rapport = Constants.NONE;
                    }
                    break;
                case 3:
                    if ((age < Constants.LIMIT) && (gender.equals("M"))) {
                        rapport = Constants.DANGER;
                    } else if (age < Constants.LIMIT) {
                        rapport = Constants.NONE;
                    } else {
                        rapport = Constants.BORDERLINE;
                    }
                    break;
                case 4:
                    if (age < Constants.LIMIT) {
                        rapport = Constants.DANGER;
                    } else {
                        rapport = Constants.BORDERLINE;
                    }
                    break;
                case 5:
                    if ((age < Constants.LIMIT) && (gender.equals("M"))) {
                        rapport = Constants.EARLY;
                    } else if (age < Constants.LIMIT) {
                        rapport = Constants.DANGER;
                    } else {
                        rapport = Constants.BORDERLINE;
                    }
                    break;
                case 6:
                    if (age < Constants.LIMIT && (gender.equals("M"))) {
                        rapport = Constants.EARLY;
                    } else {
                        rapport = Constants.DANGER;
                    }
                    break;
                case 7:
                    if (age < Constants.LIMIT) {
                        rapport = Constants.EARLY;
                    } else {
                        rapport = Constants.DANGER;
                    }
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    rapport = Constants.EARLY;
                    break;
                default:
                    break;
            }
            return rapport;
        }
    }


