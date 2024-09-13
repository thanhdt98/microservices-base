# OpenFeign

## Dependency
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

## FeignClient set JWT token for microservices call microservices
### example for set JWT per request
```yaml
app:
  services:
    profile: http://localhost:8081/profile
```

```java
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
```
```java
ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
var authHeader = servletRequestAttributes.getRequest().getHeader("Authorization");
var profileResponse = profileClient.createProfile(authHeader, profileCreationRequest);
```

- Tuy nhien cach nay co han che la request nao cung phai them token khi call
- => **@FeignClient** cung cap 1 cach de set token tu intercepter cho tat ca request
### @FeignClient config intercepter for all request