package com.MJ.converterMaciejJanik.db.collections;

import com.MJ.converterMaciejJanik.models.enums.Extension;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collation = "Conversions")
@NoArgsConstructor
public class ConversionInfo {

    public ConversionInfo(Date dateConversion, Extension sourceExt, Extension targetExt, String sourceContent, String targetContent) {
        this.dateConversion = dateConversion;
        this.sourceExt = sourceExt;
        this.targetExt = targetExt;
        this.sourceContent = sourceContent;
        this.targetContent = targetContent;
    }

    @Id
    private String id;
    private Date dateConversion;
    private Extension sourceExt;
    private Extension targetExt;
    private String sourceContent;
    private String targetContent;

}
