restful-springboot-data-mongodb
=========

Fuentes del arquetipo RestFul SpringBoot backend para crear CRUD con MongoDB.
Para compilar
```
mvn clean install
```
Para ejecutar
```
mvn spring-boot:run
```

##### USO
Documentacion y uso de Swagger
```
http://localhost:8080/swagger-ui.html#/
```

Para consultar por el estado (UP-DOWN) o la info que carga del ambiente
```
http://localhost:8080/actuator/health
http://localhost:8080/actuator/env
http://localhost:8080/actuator/info
```
