package com.thanhxv.service;

import com.thanhxv.dto.request.ProfileCreationRequest;
import com.thanhxv.dto.response.ProfileResponse;
import com.thanhxv.entity.UserProfile;
import com.thanhxv.mapper.UserProfileMapper;
import com.thanhxv.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
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

    public List<ProfileResponse> getAllProfiles() {
        return userProfileRepository.findAll()
                .stream()
                .map(userProfileMapper::toProfileResponse)
                .toList();
    }

}
