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