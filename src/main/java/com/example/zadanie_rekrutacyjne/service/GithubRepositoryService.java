package com.example.zadanie_rekrutacyjne.service;

import com.example.zadanie_rekrutacyjne.model.GithubRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public interface GithubRepositoryService {

    GithubRepository getGithubRepository(String owner, String repositoryName);

    String getGithubRepositoryJson(String repositoryOwner, String repositoryName);

    default GithubRepository getGithubRepositoryFromAPI(String owner, String repositoryName) {

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


    default String mapGithubRepositoryToJson(GithubRepository githubRepository) {
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

    default String getPathToRepositoryDetails(String repositoryOwner, String repositoryName) {
        StringBuilder urlBuilder = new StringBuilder("https://api.github.com/repos/");
        urlBuilder.append(repositoryOwner + "/" + repositoryName);
        return urlBuilder.toString();
    }


}
