package com.MJ.converterMaciejJanik.converter.services;


import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class Elements<T extends Object> {


  private Map<String, List<T>> itemsByFileName = new HashMap<>();
  private Map<String, T> itemsByName = new HashMap<>();

  public boolean exists(Object object) {

    return !Objects.isNull(object);

  }

  public boolean add(String fileName, T object) {

    if (exists(object)) {

      return false;
    }

    if (Objects.isNull(object)){
      return false;
    }

    if (Objects.isNull(fileName)){
      return false;
    }


    if (!Objects.isNull(object)) {
      itemsByName.put(object.getClass().toString(), object);
    }

    if (itemsByFileName.containsKey(fileName)) {
      itemsByFileName.get(fileName).add(object);
    } else {
      itemsByFileName.put(fileName, new ArrayList<>());
      itemsByFileName.get(fileName).add(object);
    }

    return true;
  }

  public Map<String, List<T>> getItemsByFileName() {
    return this.itemsByFileName;
  }

  public Map<String, T> getItemsByName() {
    return this.itemsByName;
  }

  public void delete(String fileName, T myObject) {
    if (Objects.isNull(myObject)){
      return;
    }

    if (Objects.isNull(fileName)){
      return;
    }

    itemsByName.remove(myObject);

    if (itemsByFileName.containsKey(fileName)) {
      itemsByFileName.get(fileName).remove(myObject);
    }

  }
}
