package com.budhathoki.edu.map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.budhathoki.edu.entities.UserEntity;
import com.budhathoki.edu.model.UserDto;

@Component
public class UserMap {
	@Autowired
private ModelMapper modelMapper;
	public UserDto mapUserEntityToUserDto(UserEntity userEntity) {
		return modelMapper.map(userEntity, UserDto.class);
	}
	public UserEntity mapUserDtoToUserEntity(UserDto userDto) {
		return modelMapper.map(userDto, UserEntity.class);
	}
	
}
