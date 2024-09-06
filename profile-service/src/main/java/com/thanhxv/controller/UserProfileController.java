package com.thanhxv.controller;

import com.thanhxv.dto.request.ProfileCreationRequest;
import com.thanhxv.dto.response.ProfileResponse;
import com.thanhxv.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/{profileId}")
    ProfileResponse getProfileById(@PathVariable String profileId) {
        return userProfileService.getProfileById(profileId);
    }

    @GetMapping()
    List<ProfileResponse> getAllProfiles() {
        return userProfileService.getAllProfiles();
    }

}
