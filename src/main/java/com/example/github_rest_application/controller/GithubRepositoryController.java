package com.example.github_rest_application.controller;

import com.example.github_rest_application.model.GithubRepository;
import com.example.github_rest_application.service.GithubRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GithubRepositoryController {

    @Autowired
    private GithubRepositoryService githubRepositoryService;

    @GetMapping("/repositories/{owner}/{repository-name}/designed")
    public String ShowRepositoryDescription(Model model,
                                            @PathVariable(name = "owner") String owner,
                                            @PathVariable(name = "repository-name") String repositoryName) {

        GithubRepository githubRepository = githubRepositoryService.getGithubRepository(owner, repositoryName);
        String githubRepositoryJson = githubRepositoryService.getGithubRepositoryJson(owner, repositoryName);

        model.addAttribute("githubRepository", githubRepository);
        model.addAttribute("githubRepositoryJson", githubRepositoryJson);

        return "home";
    }
}
