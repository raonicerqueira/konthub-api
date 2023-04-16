package com.api.konthub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String login;
  private String avatar_url;
  private String name;
  private String location;
  private String html_url;
  private Long followers;
  private Long following;
  private String created_at;
  private String repos_url;
}
