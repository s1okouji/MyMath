import java.io.IOException;
import java.lang.*;
import java.io.*;
import java.util.*;

public class MakeCSV {
    private static List<String> strList = new ArrayList<>();
    public static void main(String args[]){        

        try{
            // 読み取り
            File file = new File(".\\out.txt");
            FileReader reader  = new FileReader(file);
            BufferedReader bf = new BufferedReader(reader);
            
            String line;

            while((line = bf.readLine()) != null){
                if(line.matches("Reply.*")){
                    String[] split = line.split(" ");
                    strList.add(split[3].replace("ms",""));                    
                }
            }

            
            file = new File(".\\out.csv");            
            FileWriter filewriter = new FileWriter(file);
            for(String str:strList){
                filewriter.write(str+",\n");
            }    
            filewriter.flush();
            filewriter.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Finish!");
    }
}