package uk.co.kenfos.controller;

import org.junit.Rule;
import software.betamax.Configuration;
import software.betamax.junit.RecorderRule;

import java.io.File;

public class BetamaxTest {

    @Rule public RecorderRule recorderRule = new RecorderRule(getConfiguration());

    private static final String TAPES_DIR = "src/test/resources/betamax/tapes";

    private Configuration getConfiguration() {
        return Configuration.builder()
            .tapeRoot(new File(TAPES_DIR))
            .build();
    }
}
