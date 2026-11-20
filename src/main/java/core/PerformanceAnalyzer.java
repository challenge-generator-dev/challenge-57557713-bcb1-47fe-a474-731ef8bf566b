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