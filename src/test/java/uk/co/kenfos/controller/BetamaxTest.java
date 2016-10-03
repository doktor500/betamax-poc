package uk.co.kenfos.controller;

import org.apache.commons.lang.StringUtils;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import software.betamax.Configuration;
import software.betamax.TapeMode;
import software.betamax.junit.RecorderRule;
import uk.co.kenfos.Application;

import static java.lang.System.getProperty;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class BetamaxTest {

    @Rule
    public RecorderRule recorderRule = new RecorderRule(getConfig());
    private static final String TAPE_MODE = getProperty("betamax.defaultMode");

    private Configuration getConfig() {
        return Configuration.builder().defaultMode(getTapeMode()).build();
    }

    private TapeMode getTapeMode() {
        return StringUtils.isEmpty(TAPE_MODE) ? TapeMode.WRITE_ONLY : TapeMode.valueOf(TAPE_MODE);
    }

}
