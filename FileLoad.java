import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;


public class FileLoad{
  private String file_name;
  private ArrayList<String> words = new ArrayList<String>();

  public FileLoad(String file){
    this.file_name = file;
  }
  public ArrayList<String> load(){
    //File file = new File(file_name);
    InputStream i = FileLoad.class.getResourceAsStream(file_name);
    try{
      //FileReader fr = new FileReader(i);
      BufferedReader br = new BufferedReader(new InputStreamReader(i));
      String word = br.readLine();

      while(word != null){
        words.add(word);
        word = br.readLine();
      }
    }catch(IOException e){
        System.out.println("Unable to read from file");
      }
    return words;
    }
}
