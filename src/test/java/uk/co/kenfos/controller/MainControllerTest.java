package uk.co.kenfos.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import software.betamax.junit.Betamax;
import uk.co.kenfos.Application;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static software.betamax.TapeMode.READ_WRITE;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MainControllerTest extends BetamaxTest {

    @Autowired MainController controller;

    @Test
    @Betamax(tape = "payment_service_health_check", mode = READ_WRITE)
    public void paymentServiceHealthcheck() {
        assertReflectionEquals(
            parse("{'status':'OK','dependencies':{'mysql':'OK','fiqas':'OK','braintree':'OK','paypal':'OK'}}"),
            parse(controller.index())
        );
    }

}