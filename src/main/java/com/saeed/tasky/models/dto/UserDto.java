package com.saeed.tasky.models.dto;

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
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String avatar;
}