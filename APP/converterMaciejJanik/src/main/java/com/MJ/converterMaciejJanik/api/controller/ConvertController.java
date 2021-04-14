package com.MJ.converterMaciejJanik.api.controller;


import com.MJ.converterMaciejJanik.api.services.ConvertAPIService;
import com.MJ.converterMaciejJanik.models.enums.Extension;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/converter")
@AllArgsConstructor
public class ConvertController {

    @Autowired
    private ConvertAPIService convertAPIService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String test(){
        return "Hello World";
    }

    @RequestMapping(path = "/content/{sourceEXT}/to/{targetEXT}", method = RequestMethod.POST, produces = "application/json")
    public Object convert(@PathVariable Extension sourceEXT, @PathVariable Extension targetEXT,
                          @RequestBody String content, @RequestParam(name="save") String fileSavePath){

        return convertAPIService.convertBodyContent(content, sourceEXT, targetEXT, fileSavePath);
    }

    @RequestMapping(path = "/file/to/{targetEXT}", method = RequestMethod.POST, produces = "application/json")
    public Object convertFromFile( @PathVariable Extension targetEXT, @RequestParam(name="path") String filePath,
                                   @RequestParam(name="save") String fileSavePath){

        return convertAPIService.convertFileContent(filePath, targetEXT, fileSavePath);
    }

    @RequestMapping(path = "/history", method = RequestMethod.POST, produces = "application/json")
    public Object getHistory( @RequestParam(name="lastCount") int lastCount){

        return convertAPIService.getHistory(lastCount);
    }
}
