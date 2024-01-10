package az.annotation.customannotation.controller;

import az.annotation.customannotation.annotation.Log;
import az.annotation.customannotation.model.DemoResponseModel;
import az.annotation.customannotation.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/hello")
    @Log
    ResponseEntity<DemoResponseModel> ping(@RequestParam String name, @RequestParam String surname) {
        DemoResponseModel demoResponseModel = new DemoResponseModel(name, surname);
        return ResponseEntity.ok(demoResponseModel);
//        return ResponseEntity.ok(String.format("Hello %s!", name, " %s! ", surname));
    }

    @GetMapping("/some")
    public String doSome() {
       return demoService.doSomething();
    }


}
