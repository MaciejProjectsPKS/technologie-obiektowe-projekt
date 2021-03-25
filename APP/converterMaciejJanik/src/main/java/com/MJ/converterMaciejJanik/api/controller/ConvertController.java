package com.MJ.converterMaciejJanik.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class ConvertController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String test(){
        return "Hello World";
    }
}
