package com.MJ.converterMaciejJanik.models.objects;

import com.MJ.converterMaciejJanik.models.enums.Extension;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConversionComplete {

    private String convertedContent;
    private Extension fromExtension;
    private Extension targetExtension;
    private String fileSavePath;
    private boolean savedInFile;
}
