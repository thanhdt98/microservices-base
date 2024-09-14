package com.thanhxv.profile.mapper;

import com.thanhxv.profile.dto.request.ProfileCreationRequest;
import com.thanhxv.profile.dto.response.ProfileResponse;
import com.thanhxv.profile.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserProfile toUserProfile(ProfileCreationRequest request);

    ProfileResponse toProfileResponse(UserProfile entity);

}
