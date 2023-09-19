package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller. Versiones antiguas de Spring
@RestController //Controller para SpringBoot
@RequestMapping("/hello") //Que ruta de HTTP esta siguiendo el metodo
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "Hello World from Mexico Coacalco";
    }
}
