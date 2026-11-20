# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/core/LoadTestScenarios.java` — La pieza p1 (Definición de escenarios de carga, estrés y picos con umbrales medibles, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/adapter/k6/LoadTestExecutor.java` — La pieza p2 (Ejecución de pruebas de carga con k6 y captura de métricas, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/adapter/report/LoadTestReporter.java` — La pieza p3 (Generación de reportes de pruebas con métricas procesadas, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/core/PerformanceAnalyzer.java` — La pieza p4 (Análisis de métricas y propuesta de optimizaciones, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).

## Herramientas

- **Pruebas de Performance**: Tecnologia del perfil del candidato: el reto se resuelve con ella.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **XSteps.java** — Sin los step definitions, los pasos Gherkin no tienen implementacion y Cucumber falla con "step undefined".

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatización de pruebas, Tecnología Pruebas de Performance, Advanced L2

### Brecha de conocimiento
Diseña y ejecuta pruebas de carga sobre una API: define escenarios, umbrales de aceptación y analiza métricas de tiempo de respuesta y throughput.

### Reto
- Tema: Fundamentos de pruebas de carga y estrés
- Seniority: advanced-l2
- Tipo: practical
- Título: Diseño y ejecución de pruebas de carga sobre una API
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de escenarios de prueba — objetivo: Identificar y definir los escenarios de carga y estrés para la API 'PaymentAPI'. — entregable (NO resolver): Documento que describe los escenarios de prueba, incluyendo los tipos de carga, los umbrales de aceptación y las métricas a medir.
- Fase 2: Configuración y ejecución de pruebas — objetivo: Configurar y ejecutar las pruebas de carga definidas en la fase anterior. — entregable (NO resolver): Reporte de las pruebas ejecutadas, incluyendo los datos de throughput y tiempo de respuesta para cada escenario.
- Fase 3: Análisis y optimización — objetivo: Analizar los resultados de las pruebas y proponer optimizaciones para mejorar el rendimiento de la API. — entregable (NO resolver): Documento de análisis con propuestas de optimización basadas en los resultados de las pruebas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/test/java/runners/RunCucumberTest.java ===
package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    tags = "@loadtest"
)
public class RunCucumberTest {
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.github.kittinunf.fuel</groupId>
            <artifactId>fuel</artifactId>
            <version>2.3.1</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>8.1.0</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>8.1.0</version>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>5.4.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/model/Scenario.java ===
package model;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * Escenario de prueba de carga: describe el endpoint, la concurrencia, la duración
 * y los umbrales de aceptación. La validación de umbrales pertenece a la pieza
 * de escenarios de carga, no a este modelo.
 */
public record Scenario(
    String name,
    String description,
    String endpoint,
    int virtualUsers,
    int durationSeconds,
    Map<String, String> headers,
    String requestBody,
    List<LoadThreshold> thresholds,
    String scriptPath
) {

    /**
     * Tipo de prueba que representa el escenario: carga, estrés o picos.
     */
    public enum TipoPrueba {
        CARGA,
        ESTRES,
        PICOS
    }

    public Scenario {
        Objects.requireNonNull(name, "El nombre del escenario no puede ser nulo");
        Objects.requireNonNull(endpoint, "El endpoint no puede ser nulo");
        if (virtualUsers <= 0) {
            throw new IllegalArgumentException("El número de usuarios virtuales debe ser positivo");
        }
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("La duración debe ser positiva");
        }
        headers = headers == null ? Map.of() : Map.copyOf(headers);
        thresholds = thresholds == null ? List.of() : List.copyOf(thresholds);
    }

    /**
     * Identificador estable del escenario, construido a partir de su nombre,
     * su concurrencia y su duración.
     *
     * @return identificador como cadena, por ejemplo "carga-100users-300s".
     */
    public String getScenarioId() {
        return String.format("%s-%dusers-%ds", name, virtualUsers, durationSeconds);
    }

    /**
     * Indica si el escenario declara al menos un umbral de aceptación.
     *
     * @return true si existe algún umbral definido.
     */
    public boolean hasThresholds() {
        return !thresholds.isEmpty();
    }

    /**
     * Determina el tipo de prueba del escenario a partir de su nombre.
     * Los nombres que contienen "estres"/"estrés"/"stress" corresponden a estrés,
     * los que contienen "pico"/"spike" corresponden a picos, y el resto a carga.
     *
     * @return el {@link TipoPrueba} del escenario.
     */
    public TipoPrueba getTipoPrueba() {
        String n = name.toLowerCase(Locale.ROOT);
        if (n.contains("estres") || n.contains("estrés") || n.contains("stress")) {
            return TipoPrueba.ESTRES;
        }
        if (n.contains("pico") || n.contains("spike")) {
            return TipoPrueba.PICOS;
        }
        return TipoPrueba.CARGA;
    }
}

// === ARCHIVO: src/main/java/model/LoadThreshold.java ===
package model;

import java.util.Objects;

/**
 * Representa un umbral de aceptación para métricas de rendimiento en pruebas de carga.
 * Define los valores mínimos/máximos aceptables para throughput y tiempo de respuesta.
 */
public record LoadThreshold(
    String metricName,
    double minValue,
    double maxValue,
    String unit,
    String condition
) {
    /**
     * Constructor con validaciones básicas.
     */
    public LoadThreshold {
        Objects.requireNonNull(metricName, "El nombre de la métrica no puede ser nulo");
        Objects.requireNonNull(unit, "La unidad no puede ser nula");
        Objects.requireNonNull(condition, "La condición no puede ser nula");
        if (minValue < 0 || maxValue < 0) {
            throw new IllegalArgumentException("Los valores de umbral no pueden ser negativos");
        }
        if (minValue > maxValue) {
            throw new IllegalArgumentException("El valor mínimo no puede ser mayor que el máximo");
        }
    }

    /**
     * Valida si un valor medido cumple con el umbral definido.
     * @param measuredValue Valor medido de la métrica.
     * @return true si el valor cumple con el umbral, false en caso contrario.
     */
    public boolean validate(double measuredValue) {
        return switch (condition) {
            case ">" -> measuredValue > minValue;
            case ">=" -> measuredValue >= minValue;
            case "<" -> measuredValue < maxValue;
            case "<=" -> measuredValue <= maxValue;
            case "between" -> measuredValue >= minValue && measuredValue <= maxValue;
            default -> throw new IllegalArgumentException("Condición no soportada: " + condition);
        };
    }

    /**
     * Valida throughput y tiempo de respuesta simultáneamente.
     * @param throughput Throughput medido en transacciones por segundo.
     * @param responseTime Tiempo de respuesta promedio en milisegundos.
     * @return true si ambos valores cumplen con sus umbrales respectivos.
     */
    public boolean validate(double throughput, double responseTime) {
        if (metricName.equalsIgnoreCase("throughput")) {
            return validate(throughput);
        } else if (metricName.equalsIgnoreCase("responseTime")) {
            return validate(responseTime);
        }
        return false;
    }

    /**
     * Genera una descripción legible del umbral.
     * @return Descripción en formato "metricName condition [minValue, maxValue] unit".
     */
    public String getDescription() {
        return switch (condition) {
            case ">" -> String.format("%s > %.2f %s", metricName, minValue, unit);
            case ">=" -> String.format("%s >= %.2f %s", metricName, minValue, unit);
            case "<" -> String.format("%s < %.2f %s", metricName, maxValue, unit);
            case "<=" -> String.format("%s <= %.2f %s", metricName, maxValue, unit);
            case "between" -> String.format("%s between [%.2f, %.2f] %s", metricName, minValue, maxValue, unit);
            default -> throw new IllegalArgumentException("Condición no soportada para descripción");
        };
    }
}

// === ARCHIVO: src/main/java/model/TestReport.java ===
package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Representa el reporte de ejecución de una prueba de carga para un escenario específico.
 * Contiene los resultados medidos, las métricas calculadas y el estado de validación
 * de los umbrales definidos.
 */
public record TestReport(
    String scenarioId,
    String scenarioName,
    LocalDateTime executionTime,
    int virtualUsers,
    int durationSeconds,
    double avgThroughput,
    double avgResponseTime,
    double p95ResponseTime,
    int successfulRequests,
    int failedRequests,
    Map<String, Double> customMetrics,
    List<ThresholdValidation> thresholdValidations,
    String executorType,
    String executorVersion
) {
    /**
     * Constructor con validaciones básicas.
     */
    public TestReport {
        Objects.requireNonNull(scenarioId, "El ID del escenario no puede ser nulo");
        Objects.requireNonNull(scenarioName, "El nombre del escenario no puede ser nulo");
        Objects.requireNonNull(executionTime, "La fecha de ejecución no puede ser nula");
        if (virtualUsers <= 0) {
            throw new IllegalArgumentException("El número de usuarios virtuales debe ser positivo");
        }
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("La duración debe ser positiva");
        }
        if (avgThroughput < 0 || avgResponseTime < 0 || p95ResponseTime < 0) {
            throw new IllegalArgumentException("Las métricas no pueden ser negativas");
        }
    }

    /**
     * Calcula el porcentaje de éxito de la prueba.
     * @return Porcentaje de éxito como double entre 0 y 100.
     */
    public double getSuccessRate() {
        int totalRequests = successfulRequests + failedRequests;
        return totalRequests == 0 ? 0 : (double) successfulRequests / totalRequests * 100;
    }

    /**
     * Determina si la prueba pasó todos los umbrales definidos.
     * @return true si todos los umbrales se cumplieron, false en caso contrario.
     */
    public boolean passedAllThresholds() {
        return thresholdValidations.stream().allMatch(ThresholdValidation::isValid);
    }

    /**
     * Genera un resumen ejecutivo del reporte.
     * @return String con el resumen en formato legible.
     */
    public String generateSummary() {
        return String.format(
            "Reporte de prueba para escenario '%s' (ID: %s)%n" +
            "Ejecutado el: %s%n" +
            "Usuarios virtuales: %d | Duración: %d segundos%n" +
            "Throughput promedio: %.2f tps | Tiempo de respuesta promedio: %.2f ms%n" +
            "Tiempo de respuesta P95: %.2f ms | Tasa de éxito: %.2f%%%n" +
            "Umbrales validados: %s%n" +
            "Resultado: %s",
            scenarioName, scenarioId, executionTime, virtualUsers, durationSeconds,
            avgThroughput, avgResponseTime, p95ResponseTime, getSuccessRate(),
            passedAllThresholds() ? "TODOS CUMPLIDOS" : "ALGUNOS NO CUMPLIDOS",
            passedAllThresholds() ? "APROBADO" : "REPROBADO"
        );
    }

    /**
     * Representa el resultado de validación de un umbral específico.
     */
    public record ThresholdValidation(
        String metricName,
        String thresholdDescription,
        double measuredValue,
        boolean isValid
    ) {
        public ThresholdValidation {
            Objects.requireNonNull(metricName, "El nombre de la métrica no puede ser nulo");
            Objects.requireNonNull(thresholdDescription, "La descripción del umbral no puede ser nula");
        }

        public String getValidationResult() {
            return isValid ? "CUMPLIDO" : "NO CUMPLIDO";
        }
    }
}

// === ARCHIVO: src/main/java/model/ReportDocument.java ===
package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Documento final de reporte que consolida múltiples pruebas de carga.
 * Incluye metadatos del proyecto, resumen ejecutivo y detalles de cada prueba ejecutada.
 */
public record ReportDocument(
    String projectName,
    String projectVersion,
    LocalDateTime reportDate,
    String author,
    String environment,
    List<TestReport> testReports,
    Map<String, String> metadata,
    String conclusion,
    List<OptimizationProposal> optimizationProposals
) {

    public ReportDocument {
        Objects.requireNonNull(projectName, "El nombre del proyecto no puede ser nulo");
        Objects.requireNonNull(reportDate, "La fecha del reporte no puede ser nula");
        Objects.requireNonNull(author, "El autor no puede ser nulo");
        Objects.requireNonNull(environment, "El ambiente no puede ser nulo");
        Objects.requireNonNull(testReports, "La lista de reportes no puede ser nula");
    }

    /**
     * Calcula el porcentaje global de pruebas que pasaron todos sus umbrales.
     * @return Porcentaje de éxito global como double entre 0 y 100.
     */
    public double getGlobalSuccessRate() {
        if (testReports.isEmpty()) {
            return 0;
        }
        long passedTests = testReports.stream().filter(TestReport::passedAllThresholds).count();
        return (double) passedTests / testReports.size() * 100;
    }

    /**
     * Genera el contenido del reporte en formato Markdown.
     * @return String con el contenido completo del reporte en Markdown.
     */
    public String generateMarkdown() {
        StringBuilder sb = new StringBuilder();
        sb.append("# Reporte de Pruebas de Carga\n\n");
        sb.append(String.format("**Proyecto:** %s\n", projectName));
        sb.append(String.format("**Versión:** %s\n", projectVersion));
        sb.append(String.format("**Fecha:** %s\n", reportDate));
        sb.append(String.format("**Autor:** %s\n", author));
        sb.append(String.format("**Ambiente:** %s\n\n", environment));

        sb.append("## Resumen Ejecutivo\n");
        sb.append(String.format("- **Pruebas ejecutadas:** %d\n", testReports.size()));
        sb.append(String.format("- **Tasa de éxito global:** %.2f%%\n", getGlobalSuccessRate()));
        sb.append(String.format("- **Conclusión:** %s\n\n", conclusion));

        sb.append("## Detalle de Pruebas\n");
        for (TestReport report : testReports) {
            sb.append(String.format("### Escenario: %s\n", report.scenarioName()));
            sb.append(String.format("- **ID:** %s\n", report.scenarioId()));
            sb.append(String.format("- **Fecha de ejecución:** %s\n", report.executionTime()));
            sb.append(String.format("- **Usuarios virtuales:** %d\n", report.virtualUsers()));
            sb.append(String.format("- **Duración:** %d segundos\n", report.durationSeconds()));
            sb.append(String.format("- **Throughput promedio:** %.2f tps\n", report.avgThroughput()));
            sb.append(String.format("- **Tiempo de respuesta promedio:** %.2f ms\n", report.avgResponseTime()));
            sb.append(String.format("- **Tiempo de respuesta P95:** %.2f ms\n", report.p95ResponseTime()));
            sb.append(String.format("- **Tasa de éxito:** %.2f%%\n", report.getSuccessRate()));
            sb.append("- **Validación de umbrales:**\n");

            for (TestReport.ThresholdValidation validation : report.thresholdValidations()) {
                sb.append(String.format("  - %s: %s (Valor medido: %.2f)\n",
                    validation.metricName(),
                    validation.getValidationResult(),
                    validation.measuredValue()));
            }

            sb.append("\n");
        }

        if (!optimizationProposals.isEmpty()) {
            sb.append("## Propuestas de Optimización\n");
            for (OptimizationProposal proposal : optimizationProposals) {
                sb.append(String.format("- **%s**: %s\n",
                    proposal.optimizationType(),
                    proposal.description()));
            }
        }

        return sb.toString();
    }

    /**
     * Genera un resumen ejecutivo en formato texto plano.
     * @return String con el resumen ejecutivo.
     */
    public String generateExecutiveSummary() {
        return String.format(
            "Reporte de Pruebas de Carga - %s\n" +
            "Proyecto: %s (v%s)\n" +
            "Fecha: %s\n" +
            "Ambiente: %s\n" +
            "Pruebas ejecutadas: %d\n" +
            "Tasa de éxito global: %.2f%%\n" +
            "Conclusión: %s",
            reportDate.toLocalDate(),
            projectName,
            projectVersion,
            reportDate,
            environment,
            testReports.size(),
            getGlobalSuccessRate(),
            conclusion
        );
    }
}

// === ARCHIVO: src/main/java/core/LoadTestScenarios.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package core;

import model.LoadThreshold;
import model.Scenario;

import java.util.ArrayList;
import java.util.List;

public class LoadTestScenarios {

    private static final double DEFAULT_LOAD_USERS = 100.0;
    private static final double DEFAULT_STRESS_USERS = 1000.0;
    private static final double DEFAULT_SPIKE_USERS = 500.0;
    private static final double DEFAULT_LOAD_DURATION_MINUTES = 5.0;
    private static final double DEFAULT_STRESS_DURATION_MINUTES = 1.0;
    private static final double DEFAULT_SPIKE_DURATION_MINUTES = 0.5;

    private static final double LOAD_RESPONSE_TIME_THRESHOLD_MS = 500.0;
    private static final double LOAD_THROUGHPUT_THRESHOLD_RPS = 100.0;
    private static final double STRESS_RESPONSE_TIME_THRESHOLD_MS = 2000.0;
    private static final double STRESS_THROUGHPUT_THRESHOLD_RPS = 50.0;
    private static final double SPIKE_RESPONSE_TIME_THRESHOLD_MS = 1000.0;
    private static final double SPIKE_THROUGHPUT_THRESHOLD_RPS = 80.0;

    public LoadTestScenarios() {
    }

    public Scenario[] defineScenarios() {
      throw new UnsupportedOperationException("TODO(reto): defineScenarios");
    }

    private Scenario createLoadScenario() {
      throw new UnsupportedOperationException("TODO(reto): createLoadScenario");
    }

    private Scenario createStressScenario() {
      throw new UnsupportedOperationException("TODO(reto): createStressScenario");
    }

    private Scenario createSpikeScenario() {
      throw new UnsupportedOperationException("TODO(reto): createSpikeScenario");
    }

    private Scenario createZeroLoadScenario() {
      throw new UnsupportedOperationException("TODO(reto): createZeroLoadScenario");
    }

    public boolean validateThresholds(Scenario scenario) {
      throw new UnsupportedOperationException("TODO(reto): validateThresholds");
    }

    private boolean validateSingleThreshold(LoadThreshold threshold) {
      throw new UnsupportedOperationException("TODO(reto): validateSingleThreshold");
    }

    public boolean validateScenarioType(String scenarioType) {
      throw new UnsupportedOperationException("TODO(reto): validateScenarioType");
    }

    public LoadThreshold createThreshold(String metricName, double value, boolean isUpperBound) {
      throw new UnsupportedOperationException("TODO(reto): createThreshold");
    }
}

// === ARCHIVO: src/main/java/adapter/k6/LoadTestExecutor.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package adapter.k6;

import model.Scenario;
import model.TestReport;

import java.time.LocalDateTime;
import java.util.Map;

public class LoadTestExecutor {

    private final String k6Path;

    public LoadTestExecutor() {
        this("k6");
    }

    public LoadTestExecutor(String k6Path) {
        this.k6Path = k6Path;
    }

    public TestReport execute(Scenario scenario) {
      throw new UnsupportedOperationException("TODO(reto): execute");
    }

    public Map<String, String> captureMetrics(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): captureMetrics");
    }
}

// === ARCHIVO: src/main/java/adapter/report/LoadTestReporter.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package adapter.report;

import model.ReportDocument;
import model.TestReport;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadTestReporter {

    private static final DateTimeFormatter TIMESTAMP_FORMAT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault());

    private final String reportTitle;
    private final boolean includeRawData;

    public LoadTestReporter() {
        this("Reporte de Pruebas de Carga", true);
    }

    public LoadTestReporter(String reportTitle, boolean includeRawData) {
        this.reportTitle = reportTitle;
        this.includeRawData = includeRawData;
    }

    public ReportDocument generateReport(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): generateReport");
    }

    private Map<String, MetricComparison> buildComparisons(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): buildComparisons");
    }

    private double getThresholdForMetric(TestReport report, String metricName) {
      throw new UnsupportedOperationException("TODO(reto): getThresholdForMetric");
    }

    private String buildExecutiveSummary(TestReport report, Map<String, MetricComparison> comparisons) {
      throw new UnsupportedOperationException("TODO(reto): buildExecutiveSummary");
    }

    private String buildDetailedMetrics(TestReport report, Map<String, MetricComparison> comparisons) {
      throw new UnsupportedOperationException("TODO(reto): buildDetailedMetrics");
    }

    private String buildMarkdown(TestReport report, String timestamp,
                                  Map<String, MetricComparison> comparisons) {
                                    throw new UnsupportedOperationException("TODO(reto): buildMarkdown");
                                  }

    public String formatMetrics(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): formatMetrics");
    }

    public ReportDocument generateComparisonReport(List<TestReport> reports) {
      throw new UnsupportedOperationException("TODO(reto): generateComparisonReport");
    }

    private String buildComparisonMarkdown(List<TestReport> reports) {
      throw new UnsupportedOperationException("TODO(reto): buildComparisonMarkdown");
    }

    public record MetricComparison(
        String metricName,
        double measuredValue,
        double threshold,
        boolean passed
    ) {}
}

// === ARCHIVO: src/main/java/core/PerformanceAnalyzer.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package core;

import model.OptimizationProposal;
import model.TestReport;

import java.util.ArrayList;
import java.util.List;

public class PerformanceAnalyzer {

    private static final double HIGH_LATENCY_THRESHOLD_MS = 2000.0;
    private static final double LOW_THROUGHPUT_THRESHOLD_RPS = 50.0;
    private static final double HIGH_THROUGHPUT_THRESHOLD_RPS = 200.0;
    private static final double LOW_LATENCY_THRESHOLD_MS = 200.0;
    private static final double OPTIMIZATION_MARGIN_PERCENT = 10.0;

    private final double latencyThreshold;
    private final double throughputThreshold;

    public PerformanceAnalyzer() {
        this(HIGH_LATENCY_THRESHOLD_MS, LOW_THROUGHPUT_THRESHOLD_RPS);
    }

    public PerformanceAnalyzer(double latencyThreshold, double throughputThreshold) {
        this.latencyThreshold = latencyThreshold;
        this.throughputThreshold = throughputThreshold;
    }

    public OptimizationProposal[] analyze(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): analyze");
    }

    private boolean isHighLatencyScenario(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): isHighLatencyScenario");
    }

    private boolean isLowThroughputScenario(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): isLowThroughputScenario");
    }

    private boolean isHighThroughputLowLatency(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): isHighThroughputLowLatency");
    }

    private boolean isDatabaseBottleneck(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): isDatabaseBottleneck");
    }

    private boolean hasOptimizationMargin(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): hasOptimizationMargin");
    }

    private List<OptimizationProposal> proposeHighLatencyOptimizations(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): proposeHighLatencyOptimizations");
    }

    private List<OptimizationProposal> proposeLowThroughputOptimizations(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): proposeLowThroughputOptimizations");
    }

    private OptimizationProposal proposeCaching(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): proposeCaching");
    }

    public OptimizationProposal[] proposeOptimizations(TestReport report) {
      throw new UnsupportedOperationException("TODO(reto): proposeOptimizations");
    }

    public String generateAnalysisSummary(TestReport report, OptimizationProposal[] proposals) {
      throw new UnsupportedOperationException("TODO(reto): generateAnalysisSummary");
    }

    public boolean validateProposalViability(OptimizationProposal proposal) {
      throw new UnsupportedOperationException("TODO(reto): validateProposalViability");
    }

    public double calculateExpectedImprovement(TestReport report, OptimizationProposal proposal) {
      throw new UnsupportedOperationException("TODO(reto): calculateExpectedImprovement");
    }
}

// === ARCHIVO: src/main/java/model/OptimizationProposal.java ===
package model;

import java.util.List;
import java.util.Map;

/**
 * Representa una propuesta de optimización derivada del análisis de métricas de rendimiento.
 * Contiene la descripción técnica, el impacto esperado y la viabilidad de la optimización.
 */
public record OptimizationProposal(
    String proposalId,
    String optimizationType,
    String description,
    double expectedImprovementPercent,
    boolean isViable,
    List<String> affectedMetrics,
    Map<String, Double> currentValues,
    Map<String, Double> expectedValues,
    String rationale
) {
    /**
     * Crea una propuesta de optimización con valores vacíos para inicialización.
     */
    public static OptimizationProposal empty() {
        return new OptimizationProposal(
            "",
            "",
            "",
            0.0,
            false,
            List.of(),
            Map.of(),
            Map.of(),
            ""
        );
    }

    /**
     * Verifica si la propuesta tiene un impacto significativo en el rendimiento.
     */
    public boolean hasSignificantImpact() {
        return expectedImprovementPercent > 10.0;
    }

    /**
     * Retorna el tipo de optimización en formato legible.
     */
    public String getOptimizationTypeDisplay() {
        return switch (optimizationType.toLowerCase()) {
            case "caching" -> "Implementación de caché";
            case "scaling" -> "Escalado horizontal/vertical";
            case "database" -> "Optimización de base de datos";
            case "connection_pool" -> "Ajuste de pool de conexiones";
            case "async" -> "Procesamiento asíncrono";
            case "load_balancing" -> "Balanceo de carga";
            default -> optimizationType;
        };
    }

    /**
     * Valida que la propuesta tenga los campos mínimos requeridos.
     */
    public boolean isValid() {
        return proposalId != null && !proposalId.isBlank()
            && optimizationType != null && !optimizationType.isBlank()
            && description != null && !description.isBlank();
    }
}
```
