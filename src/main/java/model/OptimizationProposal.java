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