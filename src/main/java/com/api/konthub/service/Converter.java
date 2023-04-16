package com.api.konthub.service;

import com.api.konthub.model.Repository;
import com.api.konthub.model.RepositoryBasicDTO;
import com.api.konthub.model.RepositoryDTO;
import com.api.konthub.model.User;
import com.api.konthub.model.UserDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Converter {
  private final ModelMapper modelMapper = new ModelMapper();

  public UserDTO toUserDto(final User model) {
    UserDTO userDTO = modelMapper.map(model, UserDTO.class);
    userDTO.setUsername(model.getLogin());
    userDTO.setAvatarUrl(model.getAvatar_url());
    userDTO.setProfileUrl(model.getHtml_url());
    userDTO.setCreated(model.getCreated_at());
    List<RepositoryBasicDTO> repositories = GitHubService.getRepositories(model.getLogin());
    userDTO.setRepositoriesList(repositories);
    return userDTO;
  }

  public RepositoryDTO toRepositoryDto(final Repository model) {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
    LocalDateTime date = LocalDateTime.parse(model.getCreated_at(), formatter);
    RepositoryDTO repositoryDTO =  modelMapper.map(model, RepositoryDTO.class);
    repositoryDTO.setId(model.getId());
    repositoryDTO.setUrl(model.getHtml_url());
    repositoryDTO.setCreatedAt(date);
    return repositoryDTO;
  }
}
