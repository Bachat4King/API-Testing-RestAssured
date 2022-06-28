# API-Testing-RestAssured
Proyecto Maven creado con RestAssured, Hamcrest, TestNG, Log4j, JavaFaker, Allure para automatizar lo siguente en el servicio de https://reqres.in/
1. Obtener un usuario específico
2. Obtener todos los usuarios
3. Verificar el orden de los usuarios por id
4. Registrar un usuario correctamente
5. Registrar un usuario con información nula
6. Actualizar un usuario usando PATCH y PUT
7. Borrar un usuario
# Estructura del proyecto
### Paquete utils
- Clase PropertiesFile contiene método para leer archivos properties
### Paquete tests
- Clase BaseTest para inicializar las especificaciones default para cada test
- Clase ReqResTests contiene todo los tests para ejecutar
### Paquete model
- Clase CreateUserRequest contiene el modelo del body
- Clase CreateUserResponse contiene el modelo de la respuesta
- Clase UpdateUserRequest contiene el modelo del body
- Clase UpdateUserResponse contiene el modelo del respuesta
### Paquete listeners
- Clase TestNGListeners contiene los listeners
### Paquete data.factory
- Clase CreateUserDataFactory generación de datos a partir JavaFaker y el builder
- Clase UpdateUserDataFactory generación de datos a partir JavaFaker y el builder
### Paquete builder
- Clase CreateUserRequestBuilder contiene el builder para la clase CreateUserRequest
- Clase UpdateUserRequestBuilder contiene el builder para la clase UpdateUserRequest
### Paquete resources
- Archivo config.properties contiene las configuraciones necesarias
- Archivo log4j2.properties contiene la estructura del log
# Generación de datos
## Java Faker
Uso de java faker para el body de las peticiones
## Datos estáticos
Configurables en el archivo config.properties
# Patrones de Diseño
- Builder Pattern
- Factory | Object Mother Pattern <br>
Usados para la generacion de datos usando java faker y modelar el cuerpo de las peticiones como clases

```
DEFAULT_EMAIL=DEFAULT_EMAIL
DEFAULT_JOB=DEFAULT_JOB
```
# Correr Tests

## Ejecutar desde la consola
```
mvn -Dtest=ReqResTests test
```
## Ejecutar tests en paralelo
- **Ejecutar desde la suite** <br>
Para ejecutarlo desde la suite de TestNG ejecutar el archivo llamado testng.xml y modificar el thread-count<br>

# Allure Report
Despues de haber ejecutado los tests, correr en la consola el siguiente comando
```
allure serve allure-results
```
# Listener de TestNG
listener de TestNG para ocupar log4j los cuales se guardaran en logs/automation.log
