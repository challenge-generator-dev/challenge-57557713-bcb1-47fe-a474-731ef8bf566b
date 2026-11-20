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