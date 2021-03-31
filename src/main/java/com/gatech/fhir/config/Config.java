package com.gatech.fhir.config;

import com.gatech.fhir.controller.PatientController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config extends ResourceConfig {
    public Config() {
        register(PatientController.class);
    }

}
