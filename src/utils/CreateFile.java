package utils;

import java.io.File;
import java.io.IOException;

public class CreateFile {
  public void create(String fileName, OnFileCreated callback) {
    try {
      File myObj = new File(fileName + ".txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName() + " in " + myObj.getAbsolutePath());
        callback.onCreated(myObj);
      } else {
        System.out.println("File already exists "+ " in " + myObj.getAbsolutePath());
        callback.onCreated(myObj);
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      callback.onFailed();
      e.printStackTrace();
    }
  }
  
  public interface OnFileCreated {
	  void onCreated(File file);
	  void onFailed();
  }
}
