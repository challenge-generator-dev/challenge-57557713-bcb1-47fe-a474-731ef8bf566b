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