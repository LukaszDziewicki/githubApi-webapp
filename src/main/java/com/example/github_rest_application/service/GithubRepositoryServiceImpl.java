package com.example.github_rest_application.service;

import com.example.github_rest_application.model.GithubRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@Service
public class GithubRepositoryServiceImpl implements GithubRepositoryService {

    @Override
    public GithubRepository getGithubRepository(String owner, String repositoryName) {
        GithubRepository githubRepository = getGithubRepositoryFromAPI(owner, repositoryName);
        return githubRepository;
    }

    @Override
    public String getGithubRepositoryJson(String repositoryOwner, String repositoryName) {

        GithubRepository githubRepository = getGithubRepository(repositoryOwner, repositoryName);

        String githubRepositoryJson = mapGithubRepositoryToJson(githubRepository);

        return githubRepositoryJson;
        }

    @Override
    public GithubRepository getGithubRepositoryFromAPI(String owner, String repositoryName) {

        GithubRepository githubRepository = null;

        try {
            URL url = new URL(getPathToRepositoryDetails(owner, repositoryName));
            InputStreamReader reader = new InputStreamReader(url.openStream());
            githubRepository = new Gson().fromJson(reader, GithubRepository.class);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Objects.isNull(githubRepository)) {
            throw new NullPointerException("Object githubRepository cannot be null");
        } else {
            return githubRepository;
        }
    }

    @Override
    public String mapGithubRepositoryToJson(GithubRepository githubRepository) {
        ObjectMapper objectMapper = new ObjectMapper();

        String githubRepositoryJson = null;
        try {
            githubRepositoryJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(githubRepository);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (Objects.isNull(githubRepositoryJson)) {
            throw new NullPointerException("Object githubRepositoryJson cannot be null");
        } else {
            return githubRepositoryJson;
        }
    }

    @Override
    public String getPathToRepositoryDetails(String repositoryOwner, String repositoryName) {
        StringBuilder urlBuilder = new StringBuilder("https://api.github.com/repos/");
        urlBuilder.append(repositoryOwner + "/" + repositoryName);
        return urlBuilder.toString();
    }







}


