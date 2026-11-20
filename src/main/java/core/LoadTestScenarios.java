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