package com.MJ.converterMaciejJanik.api.services;

import com.MJ.converterMaciejJanik.models.enums.Extension;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    public String readFile(String path){
        return "test";
    }


    public boolean writeToFile(String path){
        return true;
    }

    public Extension getSourceExtension(String path){
        return Extension.JSON;
    }

}
