package com.api.konthub.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDTO {
  private Long id;
  private String name;
  private String url;
  private String description;
  private Long forks;
  private Long watchers;
  private LocalDateTime createdAt;
}
