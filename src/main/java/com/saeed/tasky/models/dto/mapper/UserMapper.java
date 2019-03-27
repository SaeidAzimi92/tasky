package com.saeed.tasky.models.dto.mapper;

import com.saeed.tasky.models.User;
import com.saeed.tasky.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto mapUserToDto(User user);

    User mapDtoToUser(UserDto userDto);
}