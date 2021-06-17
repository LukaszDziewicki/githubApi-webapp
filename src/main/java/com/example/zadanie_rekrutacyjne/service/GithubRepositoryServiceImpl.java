package com.example.zadanie_rekrutacyjne.service;

import com.example.zadanie_rekrutacyjne.model.GithubRepository;
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








}


