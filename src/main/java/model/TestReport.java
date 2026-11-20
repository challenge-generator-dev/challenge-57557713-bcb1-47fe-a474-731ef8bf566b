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