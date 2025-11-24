package com.karthik.userinfo.mapper;

import com.karthik.userinfo.dto.UserDTO;
import com.karthik.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);

    UserDTO mapUserToUserDTO(User user);
}
