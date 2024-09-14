package com.thanhxv.identity.mapper;

import com.thanhxv.identity.dto.request.ProfileCreationRequest;
import com.thanhxv.identity.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);

}
