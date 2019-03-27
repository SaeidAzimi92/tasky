package com.saeed.tasky.models.dto;

import com.saeed.tasky.models.Role;
import com.saeed.tasky.models.User;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "All details about the customer. ")
public class ProjectDto {
    private User user;
    private Role role;
    private String name;
}