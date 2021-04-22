package com.MJ.converterMaciejJanik.converter.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sound.midi.Patch;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MiddleService {

    public List<Patch> parsePatchFiles(List<File> patchFiles) throws Exception {
        List<Patch> patches = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (File file : patchFiles) {
            Patch patch = readPatchFile(objectMapper, file);

            patches.add(patch);
        }

        return patches;
    }

    private Patch readPatchFile(ObjectMapper objectMapper, File file) throws Exception {
        Patch patch;

       patch = objectMapper.readValue(file, Patch.class);
       return patch;
    }
}
