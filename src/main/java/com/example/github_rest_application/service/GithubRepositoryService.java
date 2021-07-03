package com.example.github_rest_application.service;

import com.example.github_rest_application.model.GithubRepository;



public interface GithubRepositoryService {

    GithubRepository getGithubRepository(String owner, String repositoryName);

    String getGithubRepositoryJson(String repositoryOwner, String repositoryName);

    GithubRepository getGithubRepositoryFromAPI(String owner, String repositoryName);

    String mapGithubRepositoryToJson(GithubRepository githubRepository);

    String getPathToRepositoryDetails(String repositoryOwner, String repositoryName);


}
