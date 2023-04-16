package com.api.konthub.service;

import com.api.konthub.model.RepositoryBasicDTO;
import com.api.konthub.model.User;
import com.api.konthub.model.UserDTO;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GitHubService {

    @Autowired
    private final Converter converter;

    public UserDTO getUserInfo(String username){
        String url = String.format("https://api.github.com/users/%s", username);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        Gson gson = new Gson();
        User user = gson.fromJson(response.getBody(), User.class);

        return converter.toUserDto(user);
    }

    public static List<RepositoryBasicDTO> getRepositories(String username){
        String url = String.format("https://api.github.com/users/%s/repos", username);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<RepositoryBasicDTO>>(){}.getType();

        return gson.fromJson(response.getBody(), userListType);
    }

}
