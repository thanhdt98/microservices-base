package com.thanhxv.mapper;

import com.thanhxv.dto.request.ProfileCreationRequest;
import com.thanhxv.dto.response.ProfileResponse;
import com.thanhxv.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserProfile toUserProfile(ProfileCreationRequest request);

    ProfileResponse toProfileResponse(UserProfile entity);

}
