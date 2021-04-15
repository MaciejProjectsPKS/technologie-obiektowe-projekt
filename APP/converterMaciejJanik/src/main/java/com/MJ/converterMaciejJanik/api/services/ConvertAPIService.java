package com.MJ.converterMaciejJanik.api.services;

import com.MJ.converterMaciejJanik.db.collections.ConversionInfo;
import com.MJ.converterMaciejJanik.db.repositiories.ConversionRepo;
import com.MJ.converterMaciejJanik.models.objects.ConversionComplete;
import com.MJ.converterMaciejJanik.models.enums.Extension;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;

@Service
@Slf4j
public class ConvertAPIService {

    @Autowired
    private ConversionRepo conversionRepo;

    @Autowired
    private MJConversionService MJConversionService;

    @Autowired
    private FileService fileService;


    public Object convertBodyContent(String content, Extension sourceEXT, Extension targetEXT, String fileSavePath) {
        ConversionInfo currentConversion = new ConversionInfo(new Date(),Extension.JSON,targetEXT,content,"todo-ready" );//TODO source ext

        //TODO conversion

        if(Strings.isNotEmpty(fileSavePath)){
            //tODO write to file
        }
        conversionRepo.save(currentConversion);
                return new ConversionComplete(content,sourceEXT,targetEXT,fileSavePath,true);
    }

    public Object convertFileContent(String filePath, Extension targetEXT, String fileSavePath) {
       String fileContent = fileService.readFile(filePath);
        ConversionInfo currentConversion =
                new ConversionInfo(new Date(),
                fileService.getSourceExtension(filePath),
                targetEXT,fileContent,
                "todo-ready" );//TODO source ext

        conversionRepo.save(currentConversion);

        return new ConversionComplete(fileContent,fileService.getSourceExtension(filePath),targetEXT,fileSavePath,true);
    }

    public Object getHistory(int lastCount) {
        if(lastCount>0){
            return  conversionRepo.findAll().stream().sorted(Comparator.comparing(ConversionInfo::getDateConversion).reversed()).limit(lastCount);
        }else{
            return conversionRepo.findAll();
        }
    }
}
