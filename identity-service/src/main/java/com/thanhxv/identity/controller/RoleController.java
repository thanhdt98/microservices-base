package com.thanhxv.identity.controller;

import com.thanhxv.identity.dto.request.ApiResponse;
import com.thanhxv.identity.dto.request.RoleRequest;
import com.thanhxv.identity.dto.response.RoleResponse;
import com.thanhxv.identity.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class RoleController {
    RoleService roleService;

    @PostMapping()
    ApiResponse<RoleResponse> createRole(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping()
    ApiResponse<List<RoleResponse>> getAllRoles() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.findAll())
                .build();
    }

    @DeleteMapping("/{permission}")
    ApiResponse<Void> delete(@PathVariable String name) {
        roleService.delete(name);
        return ApiResponse.<Void>builder().build();
    }
}
