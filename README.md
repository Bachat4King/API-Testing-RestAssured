# API-Testing-RestAssured
Proyecto Maven creado con RestAssured, Hamcrest, TestNG, Log4j, JavaFaker, Allure para automatizar lo siguente en el servicio de https://reqres.in/
1. Obtener un usuario específico
2. Obtener todos los usuarios
3. Verificar el order de los usuarios por id
4. Registrar un usuario correctamente
5. Registrar un usuario con informacion nula
6. Actualizar un usuario usando PATCH y PUT
7. Borrar un usuario

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
