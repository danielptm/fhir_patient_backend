package com.gatech.fhir.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private String patientData;

    @PostConstruct
    private void setup() throws IOException, URISyntaxException {
        URI uri = this.getClass().getResource("/PatientData.json").toURI();
        patientData = Files.readAllLines(Paths.get(uri)).stream().collect(Collectors.joining());
    }

    public String getPatientData(String name) throws URISyntaxException, IOException {
        String patientData = null;
        try {
            String file = String.format("/%s.json", name);
            URI uri = this.getClass().getResource(file).toURI();
            patientData = Files.readAllLines(Paths.get(uri)).stream().collect(Collectors.joining());
        } catch (Exception e) {
            System.out.println(e);
        }
        return patientData;
    }
}
