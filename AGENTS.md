# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Diseño y ejecución de pruebas de carga sobre una API**.

| | |
|---|---|
| Tema | Fundamentos de pruebas de carga y estrés |
| Nivel | advanced-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / JUnit 5 + k6 |
| Patron arquitectonico | patrón hexagonal con adaptadores para ejecución de pruebas y generación de reportes |
| Tiempo estimado | 10 horas |

## Herramientas

- **Pruebas de Performance**: Tecnologia del perfil del candidato: el reto se resuelve con ella.

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- com.github.kittinunf.fuel:fuel 2.3.1
- io.cucumber:cucumber-java 8.1.0
- io.cucumber:cucumber-junit 8.1.0
- io.rest-assured:rest-assured
- net.serenity-bdd:serenity-core 5.4.2
- org.apache.commons:commons-lang3
- org.junit.jupiter:junit-jupiter

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición de escenarios de prueba**: Documento que describe los escenarios de prueba, incluyendo los tipos de carga, los umbrales de aceptación y las métricas a medir.
- **Fase 2 — Configuración y ejecución de pruebas**: Reporte de las pruebas ejecutadas, incluyendo los datos de throughput y tiempo de respuesta para cada escenario.
- **Fase 3 — Análisis y optimización**: Documento de análisis con propuestas de optimización basadas en los resultados de las pruebas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/core/LoadTestScenarios.java` — La pieza p1 (Definición de escenarios de carga, estrés y picos con umbrales medibles, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/adapter/k6/LoadTestExecutor.java` — La pieza p2 (Ejecución de pruebas de carga con k6 y captura de métricas, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/adapter/report/LoadTestReporter.java` — La pieza p3 (Generación de reportes de pruebas con métricas procesadas, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/core/PerformanceAnalyzer.java` — La pieza p4 (Análisis de métricas y propuesta de optimizaciones, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Definición de escenarios de prueba | Definición de escenarios de carga, estrés y picos con umbrales medibles | `src/main/java/core/LoadTestScenarios.java:LoadTestScenarios` | Los escenarios de prueba están documentados con tipos de carga (carga, estrés, pico), umbrales de aceptación y métricas a medir.; Los umbrales de aceptación incluyen límites para tiempo de respuesta y throughput. | — | — |
| f2 — Configuración y ejecución de pruebas | Ejecución de pruebas de carga con k6 y captura de métricas | `src/main/java/adapter/k6/LoadTestExecutor.java:k6.LoadTestExecutor` | Las pruebas de carga se ejecutan automáticamente para cada escenario definido.; Se generan reportes con métricas de throughput y tiempo de respuesta para cada escenario. | — | — |
| f2 — Configuración y ejecución de pruebas | Generación de reportes de pruebas con métricas procesadas | `src/main/java/adapter/report/LoadTestReporter.java:LoadTestReporter` | Las pruebas de carga se ejecutan automáticamente para cada escenario definido.; Se generan reportes con métricas de throughput y tiempo de respuesta para cada escenario. | — | — |
| f3 — Análisis y optimización | Análisis de métricas y propuesta de optimizaciones | `src/main/java/core/PerformanceAnalyzer.java:PerformanceAnalyzer` | El documento de análisis identifica al menos un cuello de botella y propone una optimización técnica.; Las propuestas de optimización están respaldadas por métricas de las pruebas ejecutadas. | — | — |

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Ha corrido pruebas de carga pero no sabe diferenciar carga, estrés y picos | sin ubicar | Restriccion no verificada en sin ubicar |

## Lo que falta y tenes que completar

### 1. Boilerplate del stack (1)

Sin esto el proyecto no compila ni arranca. **Es tu trabajo crearlo**, y no toca nada de lo pedagogico: es andamiaje del stack.

- [ ] **XSteps.java** — Sin los step definitions, los pasos Gherkin no tienen implementacion y Cucumber falla con "step undefined".

### Presentes (11)

- `src/test/java/runners/RunCucumberTest.java`
- `pom.xml`
- `src/main/java/model/Scenario.java`
- `src/main/java/model/LoadThreshold.java`
- `src/main/java/model/TestReport.java`
- `src/main/java/model/ReportDocument.java`
- `src/main/java/core/LoadTestScenarios.java`
- `src/main/java/adapter/k6/LoadTestExecutor.java`
- `src/main/java/adapter/report/LoadTestReporter.java`
- `src/main/java/core/PerformanceAnalyzer.java`
- `src/main/java/model/OptimizationProposal.java`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/test/java/com/fintechx/loadtest/core` (ausente)
- `src/test/java/com/fintechx/loadtest/model` (ausente)
- `src/test/java/com/fintechx/loadtest/adapter/k6` (ausente)
- `src/test/java/com/fintechx/loadtest/adapter/report` (ausente)
- `src/test/resources/features` (ausente)
- `src/test/resources/scripts` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **patrón hexagonal con adaptadores para ejecución de pruebas y generación de reportes**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatización de pruebas, Tecnología Pruebas de Performance, Advanced L2
- Brecha que el reto ataca: Diseña y ejecuta pruebas de carga sobre una API: define escenarios, umbrales de aceptación y analiza métricas de tiempo de respuesta y throughput.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
