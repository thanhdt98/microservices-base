package com.thanhxv.apigateway.service;

import com.thanhxv.apigateway.dto.request.IntrospectRequest;
import com.thanhxv.apigateway.dto.response.ApiResponse;
import com.thanhxv.apigateway.dto.response.IntrospectResponse;
import com.thanhxv.apigateway.repository.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class IdentityService {

    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token) {
        return identityClient.introspect(IntrospectRequest.builder().token(token).build());
    }

}
