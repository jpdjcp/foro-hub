# 🚀 Foro Hub

Foro Hub es una API RESTful desarrollada con Spring Boot que permite la gestión de foros con autenticación JWT.

## Funcionalidades

- Autenticación JWT
- Publicación de tópicos
- Actualización de tópicos
- Eliminación de tópicos
- Listado de todos los tópicos

## 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Security
- JWT (JSON Web Tokens)
- MySQL 8.0
- Maven
- Hibernate/JPA

## 📋 Requisitos Previos

- Java 17 o superior
- MySQL 8.0 o superior
- Maven 3.8 o superior

## 🚀 Configuración del Entorno

1. Clona el repositorio:
   ```bash
   git clone https://github.com/jpdjcp/foro-hub.git
   cd foro-hub
   ```

2. Configura la base de datos:
   - Crea una base de datos MySQL llamada `foro_hub`
   - Asegúrate de que el usuario tenga los permisos necesarios

3. Configura las variables de entorno:
   - Copia el archivo `application.properties` a `application-local.properties`
   - Actualiza las credenciales de la base de datos según tu configuración local

## ⚙️ Configuración

El archivo `application.properties` contiene las siguientes configuraciones:

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT
api.security.token.secret=tu_clave_secreta_aqui
```

## 🏃‍♂️ Ejecutando la Aplicación

1. Compila el proyecto:
   ```bash
   mvn clean install
   ```

2. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

La aplicación estará disponible en: `http://localhost:8080`

## 🔒 Autenticación

La autenticación se realiza mediante JWT. Para acceder a los endpoints protegidos:

1. Realiza una petición POST a `/login` con las credenciales:
   ```json
   {
     "login": "usuario",
     "contrasena": "contraseña"
   }
   ```

2. Usa el token JWT devuelto en el encabezado `Authorization` de las peticiones subsiguientes:
   ```
   Authorization: Bearer [token_jwt]
   ```

## 📝 Licencia

Este proyecto es de código abierto.

## 🤝 Contribución

Las contribuciones son bienvenidas. Por favor, lee las directrices de contribución antes de enviar un pull request.

## 📧 Contacto

Marcelo Palacios - https://github.com/jpdjcp

---

Desarrollado con ❤️ por Marcelo
