import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ReadFile {

    public void readFile(){

        try{
        
        System.out.println("");
        System.out.println("-------------Read From Text File---------------"+"\n");

        //File Reads here
        File file = new File("/home/visakh/Downloads/rainbitsSample.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bfr = new BufferedReader(reader);
        String str;

        while((str=bfr.readLine())!=null){
            System.out.println(str);
        }

        bfr.close();
        
        }catch(FileNotFoundException e1){
            System.out.println(e1.getMessage());
        }catch(IOException e2){
            System.out.println(e2.getMessage());
        }

    }

}

class ExtractFile extends ReadFile {

    public void extractFile(){     

    try{  
        
        System.out.println("");
        System.out.println("-----------Extract the Values----------------"+"\n");

        // Values Like Name, Email, Address, Phone
        String[] searchArray = { "Name","Phone", "Email", "Address"};
        File file = new File("/home/visakh/Downloads/rainbitsSample.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bfr = new BufferedReader(reader);
        String str;       

        while((str=bfr.readLine())!=null){
            for(int i=0; i<=searchArray.length - 1; i++){

                if(str.contains(searchArray[i])){
                    System.out.println(str);
                }
           }
        }  
        bfr.close(); 

    }catch(FileNotFoundException e1){
        System.out.println(e1.getMessage());
    }catch(IOException e2){
        System.out.println(e2.getMessage());
    }

    }

}

class Display extends ExtractFile{

    public void display(){
        super.readFile();
        super.extractFile();
    }
}

public class RainyBits{

    public static void main(String[] args) {

      Display dis = new Display();
      dis.display();
       
        
    }
}

