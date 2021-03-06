## Cryptis Web
**Cryptis project on GitHub - [1vahron/cryptis](https://github.com/1vahron/cryptis)**

**Cryptis web-site project on GitHub - [1vahron/cryptis-web](https://github.com/1vahron/cryptis-web)**

Website for Cryptis - Cryptographic NoSQL Cloud Database

Russian site - https://cryptis.ru/ru/

English site - https://cryptis.ru/en/

### Technology stack
* Spring Boot
* PostgreSQL
* Docker
* Bootstrap

### Build
* mvn clean compile - compilation
* mvn spring-boot:run - run server locally
* mvn clean package - create executable jar with Spring Boot
* ./create-docker.sh - make docker container with entire project

### Run
Project use Docker Compose, you have to tune settings below for container:
* `SPRING_DATASOURCE_PASSWORD` - postgres user password for PostgreSQL
* `SPRING_PROFILES_ACTIVE` - set to `production` to activate production mode (check resources/application-production.properties)

### Docker compose example
```
cryptis-web:
  image: ru.cryptis/web
  links:
    - postgres-db:postgres
  ports:
    - "127.0.0.1:your-port-here:8080"
  environment:
    SPRING_PROFILES_ACTIVE: production
    SPRING_DATASOURCE_PASSWORD: your-password-here

postgres-db:
  image: postgres
  restart: always
  environment:
    POSTGRES_PASSWORD: your-password-here
```
