import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {
    static int chromosome_size = 0;
      //Read in the file and determine the chrome size
    public static String readFile() throws FileNotFoundException, IOException{
        StringBuilder sb = new StringBuilder();
        String file = "C:\\Users\\samue\\Desktop\\Genetic_Algorithm\\Genetic_Algorithm\\GA\\Data1.txt";
        try(BufferedReader buffer = new BufferedReader(new FileReader(file))){
            String number = buffer.readLine();
            if(number !=null && !number.isEmpty()){
                chromosome_size = Integer.valueOf(number.trim());
                Parameters.CHROMOSOME_SIZE = ReadFile.chromosome_size;
                System.out.println("Read chromosome size: " + chromosome_size);
            }
             
            String line = buffer.readLine();

            while(line!=null){
                sb.append(line);
                line = buffer.readLine();
            }
            
        } catch(IOException e){
            e.printStackTrace();
        }
         return sb.toString();
    }
}
