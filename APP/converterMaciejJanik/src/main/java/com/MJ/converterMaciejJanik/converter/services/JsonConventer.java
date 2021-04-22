package com.MJ.converterMaciejJanik.converter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public abstract class JsonConventer <T>{

  private final String jsonFileName;
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final Type type=((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

  public JsonConventer(String jsonFileName) {
    this.jsonFileName = jsonFileName;
  }

  public void toJson(final T object){


    try(FileWriter fileWriter = new FileWriter(jsonFileName,true)) {

      if (object == null) {
        throw new NullPointerException("OBJECT IS NULL");
      }
      gson.toJson(object, fileWriter);

    }catch (NullPointerException e){
     // System.err.println(e.getMessage());
    } catch (IOException e) {
      //System.err.println("EXCEPTION FILE IN TO JSON");
    }
  }



  public Optional<T> fromJson(){
    try(FileReader fileReader=new FileReader(jsonFileName)){
      return Optional.of(gson.fromJson(fileReader,type));
    }catch (IOException e){
      //System.err.println("EXCEPTION FILE READER");
    }

    return Optional.empty();
  }
}
