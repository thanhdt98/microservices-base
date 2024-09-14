package com.thanhxv.profile.service;

import com.thanhxv.profile.dto.request.ProfileCreationRequest;
import com.thanhxv.profile.dto.response.ProfileResponse;
import com.thanhxv.profile.entity.UserProfile;
import com.thanhxv.profile.mapper.UserProfileMapper;
import com.thanhxv.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public ProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toProfileResponse(userProfile);
    }

    public ProfileResponse getProfileById(String id) {
        return userProfileMapper.toProfileResponse(userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found")));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<ProfileResponse> getAllProfiles() {
        return userProfileRepository.findAll()
                .stream()
                .map(userProfileMapper::toProfileResponse)
                .toList();
    }

}
