package com.kd.user.portal.user.configuration;

import com.kd.user.portal.user.dto.UserDTO;
import com.kd.user.portal.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(UserDTO.class, User.class)
                .addMappings(mapper -> {
                    mapper.map(UserDTO::getUserId, User::setUserId);
                    mapper.skip(User::setId);
                });

        return modelMapper;
    }

    private String mapNickname(String name){

        return name == null ? "NULL NICKNAME" : "NONO NULL NICKNAME";
    }
}
