package uk.co.kenfos.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    private static final URL = 'http://localhost:3000/healthcheck'

    @RequestMapping('/')
    String index() {
        new URL(URL).text
    }

}
