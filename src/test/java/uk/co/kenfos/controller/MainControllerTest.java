package uk.co.kenfos.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import software.betamax.junit.Betamax;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class MainControllerTest extends BetamaxTest {

    @Autowired MainController controller;

    @Test
    @Betamax(tape = "payment_service_healthcheck")
    public void paymentServiceHealthcheck() {
        assertReflectionEquals(
            parse("{'status':'OK','dependencies':{'mysql':'OK','fiqas':'OK','braintree':'OK','paypal':'OK'}}"),
            parse(controller.index())
        );
    }

}