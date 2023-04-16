package com.api.konthub.controller;

import com.api.konthub.model.RepositoryBasicDTO;
import com.api.konthub.model.RepositoryDTO;
import com.api.konthub.model.UserDTO;
import com.api.konthub.service.GitHubService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private GitHubService service;

    @GetMapping("/{username}")
    public UserDTO searchUserInfo (@PathVariable() String username) {
        return service.getUserInfo(username);
    }

    @GetMapping("/{username}/repositories")
    public List<RepositoryBasicDTO> searchRepository (@PathVariable() String username) {
        return GitHubService.getRepositories(username);
    }
}
