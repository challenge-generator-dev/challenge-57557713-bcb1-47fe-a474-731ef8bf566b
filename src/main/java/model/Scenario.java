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