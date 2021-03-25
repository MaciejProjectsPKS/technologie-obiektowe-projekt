package com.MJ.converterMaciejJanik.api.services;

import com.MJ.converterMaciejJanik.models.enums.Extension;
import org.springframework.stereotype.Service;

@Service
public class ConvertAPIService {


    public Object convertBodyContent(String content, Extension sourceEXT, Extension targetEXT, String fileSavePath) {
        return new TestModel(content,sourceEXT,targetEXT,fileSavePath);
    }

    public Object convertFileContent(String filePath, Extension targetEXT, String fileSavePath) {
        return new TestModel("filePath: "+filePath,null,targetEXT,fileSavePath);
    }
}
