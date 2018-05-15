package com.test.many_to_one_test.controller;


import com.test.many_to_one_test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private TestService testService;


    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }


    @PostMapping("/many-to-one")
    public void testMapping() {
        testService.testMapping();
    }

}
