package com.lms.authservice.mapper;

import com.lms.authservice.dto.RegisterRequest;
import com.lms.authservice.dto.UserResponse;
import com.lms.authservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

//@Mapper(componentModel = "spring") is needed when you're
//using MapStruct with Spring Boot and you want Spring to manage your mapper.
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    //unmappedTargetPolicy = ReportingPolicy.IGNORE
    // "If some target fields aren't mapped,
    // don't generate a warning/error about them.

    /**
     * Map RegisterRequest to User entity.
     * Password will be explicitly encoded in the service layer, so we ignore it here.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(RegisterRequest request);

    /**
     * Map User entity to UserResponse DTO.
     */
    UserResponse toResponse(User user);
}