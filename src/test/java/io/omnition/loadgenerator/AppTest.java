package io.omnition.loadgenerator;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void runLocalJaegerCollector() {
        // ===================================================
        // opts
        // ===================================================
        final String config = "100_000_spans_per_second.json";
        final String initialDelayMs = "100";
        final String periodMs = "1000";
        // ===================================================
        Path path = Paths.get(System.getProperty("user.dir"), "topologies", config);
        if (!path.toFile().exists()) {
            Assert.fail("rollegg!");
        }
        App.main(new String[]{
                "--paramsFile",
                path.toString(),
                "--jaegerCollectorUrl",
                "http://localhost:14268",
                "--initialDelayMs", initialDelayMs,
                "--periodMs", periodMs
        });
    }
}
