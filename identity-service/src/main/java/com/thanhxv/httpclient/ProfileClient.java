package com.thanhxv.httpclient;

import com.thanhxv.dto.request.ProfileCreationRequest;
import com.thanhxv.dto.response.ProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "profile-service", url = "${app.services.profile}")
public interface ProfileClient {

    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ProfileResponse createProfile(
            @RequestHeader("Authorization") String token,
            @RequestBody ProfileCreationRequest request);


}
