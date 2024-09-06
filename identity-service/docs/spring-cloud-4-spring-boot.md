# Spring cloud for Spring boot
- Moi Spring Boot version tuong ung voi 1 Spring Cloud version de dam bao cac dependency tuong thich voi nhau

```xml
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.3</version>
	</parent>
```

```xml
    <properties>
        <spring-cloud.version>2023.0.1</spring-cloud.version>
    </properties>
```

```xml
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```

- Spring Cloud chi la collect cac dependency khac de dam bao khong conflict voi nhau
- De biet Spring Boot version nao tuong thich voi Spring Cloud version nao
  - Vao trang `https://spring.io/projects/spring-cloud` => **Adding Spring Cloud To An Existing Spring Boot Application**