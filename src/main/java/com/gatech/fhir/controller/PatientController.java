package com.gatech.fhir.controller;

import com.gatech.fhir.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;

@Component
@Path("patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatient(@QueryParam("name") String name) throws URISyntaxException, IOException {
        return Response.ok(this.patientService.getPatientData(name)).build();
    }
}
