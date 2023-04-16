package com.api.konthub.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
 private String username;
 private String avatarUrl;
 private String name;
 private String location;
 private String profileUrl;
 private Long followers;
 private Long following;
 private String created;
 private List<RepositoryBasicDTO> repositoriesList;
}
