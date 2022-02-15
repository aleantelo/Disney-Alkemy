# Challenge de Disney para pre-aceleracion de Alkemy 

## Breve introducción

## Cómo funciona
La aplicación utiliza Spring Boot (Web, Hibernate).
+ Usa Hibernate para implementar el patrón [Data Mapper](https://martinfowler.com/eaaCatalog/dataMapper.html) para la persistencia.

Y el código está organizado así:
+ ```entities``` capa que representa las tablas en la base de datos.
  
## Configuracion

**1. Clonar la aplicación**

```bash
https://github.com/aleantelo/Disney-Alkemy.git
```

**2. Ver archivo de configuracion ->  application.properties**
+ abrir `src/main/resources/application.properties`

+ modificar 
`spring.datasource.url`, `spring.datasource.username` `spring.datasource.password`segun la instalación de su base de datos


**4. Ejecutando la aplicación localmente**

La forma sencilla es ejecutar el método `main` en src/main/java/com.alkemy.disney.DisneyApplication desde su IDE.

La aplicación estará corriendo en  <http://localhost:8080>.
