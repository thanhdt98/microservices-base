package com.thanhxv.identity.mapper;

import com.thanhxv.identity.dto.request.PermissionRequest;
import com.thanhxv.identity.dto.response.PermissionResponse;
import com.thanhxv.identity.entity.Permission;
import org.mapstruct.Mapper;

/**
 * componentModel = "spring"
 * bao cho mapstruct biet generate mapper nay su dung trong spring
 * do do no se theo kieu dependency injection
 */
@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
