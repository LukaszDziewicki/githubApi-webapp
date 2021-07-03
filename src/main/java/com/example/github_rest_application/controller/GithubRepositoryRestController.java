package com.example.github_rest_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.github_rest_application.service.GithubRepositoryService;



@RestController
public class GithubRepositoryRestController {

    @Autowired
    private GithubRepositoryService githubRepositoryService;


    @GetMapping("/repositories/{owner}/{repository-name}")
    public String ShowRepositoryDescription(@PathVariable(name = "owner") String owner,
                                            @PathVariable(name = "repository-name") String repositoryName) {

        String githubRepositoryJson = githubRepositoryService.getGithubRepositoryJson(owner, repositoryName);

        return githubRepositoryJson;
    }


}
