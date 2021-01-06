package io.omnition.loadgenerator;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void runLocalJaegerCollector() {
        App.main(new String[]{
                "--paramsFile",
                "100_000_spans_per_second.json",
                "--jaegerCollectorUrl",
                "http://localhost:14268",
                "--initialDelayMs", "100",
                "--periodMs", "100"
        });
    }
}
