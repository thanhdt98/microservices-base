# Spring Data Neo4j

## Offical docs
- https://docs.spring.io/spring-data/neo4j/reference/getting-started.html

## What?
- Neo4j la NoSql

---

## Prepare the database
### Install Neo4j with Docker
```shell
docker run --name neo4j --publish=7474:7474 --publish=7687:7687 -e 'NEO4J_AUTH=neo4j/12345678' neo4j:latest
```
- `-e 'NEO4J_AUTH=neo4j/12345678'` is credential
  - neu khong set NEO4J_AUTH thi user/pass mac dinh khi vao trang `localhost:7474` la `neo4j/neo4j`

## Config on the project
### Dependency
```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-neo4j</artifactId>
  </dependency>
```

### Config datasource
```properties
spring.neo4j.uri=bolt://localhost:7687
spring.neo4j.authentication.username=neo4j
spring.neo4j.authentication.password=12345678
```