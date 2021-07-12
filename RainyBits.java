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
        File file = new File("/home/visakh/Downloads/resumesample.txt");
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

        System.out.println("");
        System.out.println("-----------Extract the Values----------------"+"\n");

           // if you wanna use array to extract value
           String[] searchArray = { "Name","Phone","Mobile" ,"Email","E-mail", "Address"}; 

        //if you wanna extact value by keyboard
        File file = new File("/home/visakh/Downloads/rainbitsSample.txt");
        FileReader reader = null;
        Scanner sc= new Scanner(System.in);
        String searchWord, str;
        int n;
        System.out.println("Please select mode:");
        System.out.println("1. By Keyboard");
        System.out.println("2. By Array");
        n = sc.nextInt();
       
    

    try{  
        
        reader = new FileReader(file);
        BufferedReader bfr = new BufferedReader(reader);

                if(n==1){
                    Scanner s = new Scanner(System.in);
                    System.out.println("Enter the word you want to search: ");
                    searchWord = s.nextLine();
                    while((str=bfr.readLine())!=null){
                        if(str.contains(searchWord)){
                            System.out.println(str);
                        }
                    }
                    s.close();
                }else if(n==2){ 

                       while((str=bfr.readLine())!=null){
                        for(int i=0; i<=searchArray.length - 1; i++){
            
                            if(str.contains(searchArray[i])){
                                System.out.println(str);
                            }
                        }
                    } 
                }else{
                    System.out.println("Invalid Option!");
                }

                bfr.close();
  
    

    }catch(FileNotFoundException e1){
        System.out.println(e1.getMessage());
    }catch(IOException e2){
        System.out.println(e2.getMessage());
    }finally{
        sc.close();
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

