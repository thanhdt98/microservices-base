package com.thanhxv.controller;

import com.thanhxv.dto.request.ProfileCreationRequest;
import com.thanhxv.dto.response.ProfileResponse;
import com.thanhxv.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping()
    ProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createProfile(request);
    }

}
