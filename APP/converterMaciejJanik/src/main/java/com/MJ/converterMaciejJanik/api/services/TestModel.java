package com.MJ.converterMaciejJanik.api.services;

import com.MJ.converterMaciejJanik.models.enums.Extension;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestModel {

    private String content;
    private Extension sourceEXT;
    private Extension targetEXT;
    private String fileSavePath;
}
