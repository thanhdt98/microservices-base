package com.thanhxv.mapper;

import com.thanhxv.dto.request.ProfileCreationRequest;
import com.thanhxv.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);

}
