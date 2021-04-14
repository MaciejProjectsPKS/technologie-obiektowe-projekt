package com.MJ.converterMaciejJanik.api.services;

import com.MJ.converterMaciejJanik.db.collections.ConversionInfo;
import com.MJ.converterMaciejJanik.db.repositiories.ConversionRepo;
import com.MJ.converterMaciejJanik.models.enums.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ConvertAPIService {

    @Autowired
    private ConversionRepo conversionRepo;


    public Object convertBodyContent(String content, Extension sourceEXT, Extension targetEXT, String fileSavePath) {
        return new TestModel(content,sourceEXT,targetEXT,fileSavePath);
    }

    public Object convertFileContent(String filePath, Extension targetEXT, String fileSavePath) {
        return new TestModel("filePath: "+filePath,null,targetEXT,fileSavePath);
    }

    public Object getHistory(int lastCount) {
        if(lastCount>0){
            return  conversionRepo.findAll().stream().sorted(Comparator.comparing(ConversionInfo::getDateConversion).reversed()).limit(lastCount);
        }else{
            return conversionRepo.findAll();
        }
    }
}
