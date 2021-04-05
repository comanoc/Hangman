import java.util.ArrayList;

public class test{
  public static void main(String[] args){
    String file_name = "words.txt";
    FileLoad dict = new FileLoad(file_name);
    ArrayList<String> words = dict.load();

    for(String word:words){
      System.out.println(word);
    }
  }
}
