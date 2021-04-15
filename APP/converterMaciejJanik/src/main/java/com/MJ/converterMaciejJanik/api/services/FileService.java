package com.MJ.converterMaciejJanik.api.services;

import com.MJ.converterMaciejJanik.models.enums.Extension;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileService {

    public String readFile(String path){
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            return br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Error";
    }


    public boolean writeToFile(String path){
        return true;
    }

    public Extension getSourceExtension(String path){
        return Extension.JSON;
    }

}
