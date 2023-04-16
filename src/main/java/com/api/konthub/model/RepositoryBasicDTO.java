package com.api.konthub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryBasicDTO {
  private Long id;
  private String name;
  private String html_url;
  private String description;
}
