package uk.co.kenfos.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import spock.lang.Specification
import uk.co.kenfos.Application

@RunWith(SpringJUnit4ClassRunner)
@SpringBootTest(classes = Application)
class MainControllerSpec extends Specification {

  @Autowired MainController controller

  @Test
  void 'returns payment service health-check'() {
    expect:
    controller.index() == '{"status":"OK","dependencies":{"mysql":"OK","fiqas":"OK","braintree":"OK","paypal":"OK"}}'
  }
}
