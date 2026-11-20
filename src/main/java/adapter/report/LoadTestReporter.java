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