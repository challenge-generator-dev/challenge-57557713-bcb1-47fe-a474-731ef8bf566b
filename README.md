# Diseño y ejecución de pruebas de carga sobre una API

El sistema de la empresa de fintech 'FintechX' requiere pruebas de carga y estrés para garantizar su rendimiento bajo diferentes condiciones. La API 'PaymentAPI' es crítica para el negocio y debe soportar un throughput de 1000 transacciones por segundo con un tiempo de respuesta promedio de 200 milisegundos. Diseña y ejecuta pruebas de carga para validar estos umbrales.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Fundamentos de pruebas de carga y estrés |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 10 horas |

## Stack

- **Lenguaje:** Java
- **Framework:** JUnit 5 + k6
- **Version:** 21

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Definición de escenarios de prueba

**Objetivo:** Identificar y definir los escenarios de carga y estrés para la API 'PaymentAPI'.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identifica los diferentes tipos de carga (normal, pico, estrés) y define los escenarios de prueba correspondientes.
- Establece los umbrales de aceptación para cada escenario en términos de throughput y tiempo de respuesta.

**Entregable:** Documento que describe los escenarios de prueba, incluyendo los tipos de carga, los umbrales de aceptación y las métricas a medir.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las diferencias entre carga, estrés y picos de tráfico.
- Investiga métodos para generar carga en una API.

</details>

### Fase 2: Configuración y ejecución de pruebas

**Objetivo:** Configurar y ejecutar las pruebas de carga definidas en la fase anterior.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Configura la herramienta de pruebas de carga para ejecutar los escenarios definidos.
- Ejecuta las pruebas y recopila los datos de throughput y tiempo de respuesta.

**Entregable:** Reporte de las pruebas ejecutadas, incluyendo los datos de throughput y tiempo de respuesta para cada escenario.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza una herramienta de pruebas de carga para configurar y ejecutar las pruebas.
- Asegúrate de recopilar los datos necesarios para analizar el rendimiento de la API.

</details>

### Fase 3: Análisis y optimización

**Objetivo:** Analizar los resultados de las pruebas y proponer optimizaciones para mejorar el rendimiento de la API.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Revisar los reportes generados en la fase f2 para identificar cuellos de botella.
- Proponer optimizaciones técnicas (ej: caching, escalado horizontal) y validar su impacto potencial con métricas.
- Asegurar que las propuestas estén respaldadas por los casos de aceptación de la pieza p4.

**Entregable:** Documento de análisis con propuestas de optimización basadas en los resultados de las pruebas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera diferentes estrategias de optimización, como la mejora de la arquitectura, la optimización del código o la utilización de caché.
- Evalúa el impacto de las optimizaciones propuestas en el rendimiento de la API.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las pruebas de carga y estrés y por qué son importantes para la API 'PaymentAPI'?
- **paraQueSirve**: ¿Para qué sirven los umbrales de aceptación en las pruebas de carga y estrés?
- **comoSeUsa**: ¿Cómo se configura y ejecuta una prueba de carga utilizando una herramienta de pruebas de carga?
- **erroresComunes**: ¿Cuáles son los errores comunes al ejecutar pruebas de carga y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica el análisis de los resultados de las pruebas y la propuesta de optimizaciones?

## Criterios de Evaluacion

- Definición clara de escenarios de prueba con umbrales de aceptación.
- Configuración y ejecución correcta de las pruebas de carga.
- Análisis detallado de los resultados de las pruebas.
- Propuesta de optimizaciones basadas en los resultados obtenidos.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Definición de escenarios de prueba | Definición de escenarios de carga, estrés y picos con umbrales medibles | `src/main/java/core/LoadTestScenarios.java:LoadTestScenarios` | Los escenarios de prueba están documentados con tipos de carga (carga, estrés, pico), umbrales de aceptación y métricas a medir.; Los umbrales de aceptación incluyen límites para tiempo de respuesta y throughput. | — | — |
| f2 — Configuración y ejecución de pruebas | Ejecución de pruebas de carga con k6 y captura de métricas | `src/main/java/adapter/k6/LoadTestExecutor.java:k6.LoadTestExecutor` | Las pruebas de carga se ejecutan automáticamente para cada escenario definido.; Se generan reportes con métricas de throughput y tiempo de respuesta para cada escenario. | — | — |
| f2 — Configuración y ejecución de pruebas | Generación de reportes de pruebas con métricas procesadas | `src/main/java/adapter/report/LoadTestReporter.java:LoadTestReporter` | Las pruebas de carga se ejecutan automáticamente para cada escenario definido.; Se generan reportes con métricas de throughput y tiempo de respuesta para cada escenario. | — | — |
| f3 — Análisis y optimización | Análisis de métricas y propuesta de optimizaciones | `src/main/java/core/PerformanceAnalyzer.java:PerformanceAnalyzer` | El documento de análisis identifica al menos un cuello de botella y propone una optimización técnica.; Las propuestas de optimización están respaldadas por métricas de las pruebas ejecutadas. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Ha corrido pruebas de carga pero no sabe diferenciar carga, estrés y picos | sin ubicar | Restriccion no verificada en sin ubicar |

## Herramientas

- **Pruebas de Performance**: Tecnologia del perfil del candidato: el reto se resuelve con ella.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
