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
        // 配置文件
        final String config = "100_000_spans_per_second.json";
        // 启动延迟
        final String initialDelayMs = "100";
        // 发送周期
        final String periodMs = "10";
        // ===================================================
        Path configPath = Paths.get(System.getProperty("user.dir"), "topologies", config);
        if (!configPath.toFile().exists()) {
            Assert.fail("rollegg! config file not exists!");
        }

        App.main(new String[]{
                "--paramsFile",
                configPath.toString(),
                "--jaegerCollectorUrl",
                "http://localhost:5778",
                "--initialDelayMs", initialDelayMs,
                "--periodMs", periodMs
        });
    }
}
