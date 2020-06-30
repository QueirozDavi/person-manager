package com.personmanager.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.personmanager.manager.util.Constants.*;

@RestController
@RequestMapping("/v1/public/")
public class OpenController implements MVCController{

    @GetMapping("/project-repository")
    public String getProjectRepository() {
        return PROJECT_REPOSITORY_URL;
    }

    @GetMapping("/swagger-api-url")
    public String getProjectSwaggerApiUrl() {
        return SWAGGER_API_URL;
    }

    @GetMapping("/project-repository")
    public String getProjectSwaggerApiDocsUrl() {
        return SWAGGER_API_DOCS_URL;
    }
}
