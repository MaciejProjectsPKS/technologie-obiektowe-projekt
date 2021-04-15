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
import java.util.Objects;

import static org.springframework.http.ResponseEntity.ok;

@Service
@Slf4j
public class ConvertAPIService {

    @Autowired
    private ConversionRepo conversionRepo;

    @Autowired
    private MJConversionService conversionService;

    @Autowired
    private FileService fileService;


    public Object convertBodyContent(String content, Extension sourceEXT, Extension targetEXT, String fileSavePath) {
        String targetFileSave= "";
        String convertedContent =conversionService.convert(content);

        if(Objects.nonNull(fileSavePath)){
            targetFileSave = fileService.writeToFile(fileSavePath,convertedContent, targetEXT);
        }
        ConversionInfo currentConversion = new ConversionInfo(new Date(),sourceEXT,targetEXT,content,convertedContent, targetFileSave );
        conversionRepo.save(currentConversion);
     return ok(new ConversionComplete(convertedContent,sourceEXT,targetEXT,targetFileSave,Objects.nonNull(fileSavePath)));
    }

    public Object convertFileContent(String filePath, Extension targetEXT, String fileSavePath) {
        String targetFileSave= "";
        String fileContent = fileService.readFile(filePath);

       String convertedContent = conversionService.convert(fileService.readFile(filePath));

        if(Objects.nonNull(fileSavePath)){
            targetFileSave = fileService.writeToFile(fileSavePath, convertedContent, targetEXT);
        }

        ConversionInfo currentConversion =
                new ConversionInfo(new Date(), fileService.getSourceExtension(filePath),
                        targetEXT,fileContent, convertedContent, targetFileSave);

        conversionRepo.save(currentConversion);

        return ok(new ConversionComplete(convertedContent,fileService.getSourceExtension(filePath),targetEXT,targetFileSave,Objects.nonNull(fileSavePath)));
    }

    public Object getHistory(int lastCount) {
        if(lastCount>0){
            return  conversionRepo.findAll().stream().sorted(Comparator.comparing(ConversionInfo::getDateConversion).reversed()).limit(lastCount);
        }else{
            return conversionRepo.findAll();
        }
    }
}
