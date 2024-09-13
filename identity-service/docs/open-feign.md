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
#### Implements
- Tao **class (Bean) interceptor** implement **RequestInterceptor**
- Modify request trong @Override method `apply` truoc khi call
- Feign se quet cac ben implement **RequestInterceptor** neu co thi tat ca cac request su dung `FeignClient` se deu apply interceptor
```java
package com.thanhxv.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Log4j2
@Component
public class AuthenticationRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        var authHeader = servletRequestAttributes.getRequest().getHeader("Authorization");
        log.info("Header: {}", authHeader);
        if (StringUtils.hasText(authHeader)) {
            requestTemplate.header("Authorization", authHeader);
        }
    }
}
```
- Tuy nhien viec config la 1 **Bean** thi ca cac request call den resource khac cung bi apply interceptor nay
  - vd can call request den ben thu 3
- Do do se k tao **Bean** ma se cau hinh o inteface `@FeignClient`
```java
@FeignClient(name = "profile-service", url = "${app.services.profile}",
        configuration = {AuthenticationRequestInterceptor.class})
public interface ProfileClient {
    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ProfileResponse createProfile(
            @RequestBody ProfileCreationRequest request);
}
```
- `configuration` nhan 1 list cac class