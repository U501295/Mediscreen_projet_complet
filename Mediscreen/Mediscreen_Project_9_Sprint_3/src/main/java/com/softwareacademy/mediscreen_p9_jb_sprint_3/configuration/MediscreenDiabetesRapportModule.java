package com.softwareacademy.mediscreen_p9_jb_sprint_3.configuration;

import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.PatientHistoryProxy;
import com.softwareacademy.mediscreen_p9_jb_sprint_3.proxy.PatientProxy;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediscreenDiabetesRapportModule {

    @Bean
    public PatientProxy getPatientProxy(@Value("${clients.patientapiclienturl}") final String url) {
        return Feign.builder().decoder(new JacksonDecoder()).target(PatientProxy.class, url);
    }

    @Bean
    public PatientHistoryProxy getPatientHistoryProxy(@Value("${clients.patientnoteapiclienturl}") final String url) {
        return Feign.builder().decoder(new JacksonDecoder()).target(PatientHistoryProxy.class, url);
    }

}
