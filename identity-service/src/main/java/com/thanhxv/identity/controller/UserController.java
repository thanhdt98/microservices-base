package com.thanhxv.identity.controller;

import com.thanhxv.identity.dto.request.ApiResponse;
import com.thanhxv.identity.dto.request.UserCreationRequest;
import com.thanhxv.identity.dto.request.UserUpdateRequest;
import com.thanhxv.identity.dto.response.UserResponse;
import com.thanhxv.identity.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class UserController {
    UserService userService;

    @PostMapping("/registration")
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        log.info("UserController createUser");
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping()
    ApiResponse<List<UserResponse>> getUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info("GrantedAuthority: {}", grantedAuthority));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable(name = "userId") String userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/my-info")
    UserResponse getMyInfo() {
        return userService.getMyInfo();
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable(name = "userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
}
