import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WriteAndReadRandomSigns{

    final static int length = 1000;
    final static String path1 = "fileIO.txt";
    final static String path2 = "fileNIO.txt";

    public static void main(String[] args){
        String randomString = generateRandomString(length);
        
        writeToFileIO(path1, randomString);
        writeToFileNIO(path2, randomString);

        System.out.println(readFromFileIO(path1));
        System.out.println(readFromFileNIO(path2));
    }
    
    private static String generateRandomString(int length){
        String alphabetAndFewSpecialSigns = "ABCDEFGHIJKLMNOPQRSTUVWXYZ;.<,{}':/+-\\\")(^%&";
        int randomIndex = 0;
        StringBuilder sB = new StringBuilder();
        for(int i = 0; i < length; i ++){
            randomIndex = ThreadLocalRandom.current().nextInt(0, alphabetAndFewSpecialSigns.length());
            sB.append(alphabetAndFewSpecialSigns.charAt(randomIndex));
        }

        return sB.toString();
    }

    private static void writeToFileIO(String path, String randomString){
        long start = System.nanoTime();

        PrintWriter writer = null;
        try{
            writer = new PrintWriter(path, "UTF-8");
            writer.println(randomString);
        }catch(IOException e){
            System.out.println("Problem with writing to file (IO)");
        }finally{
            if(writer != null){
                writer.close();
            }
        }

        System.out.println("Write to file (IO time): "+(System.nanoTime()-start));
    }

    private static void writeToFileNIO(String path, String randomString){
        long start = System.nanoTime();
        try{
            Files.write(Paths.get(path), randomString.getBytes());
        }catch(IOException e){
            System.out.println("Problem with writing to file (NIO)");
        }

        System.out.println("Write to file (NIO time): "+(System.nanoTime()-start));
    }

    private static String readFromFileIO(String path){
        long start = System.nanoTime();
        StringBuilder sB = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            sB = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sB.append(line);
                sB.append(System.lineSeparator());
                line = br.readLine();
            }
        }catch(IOException e){
            System.out.println("Problem with reading from file (IO)");
        }finally {
            try{
                br.close();
            }catch(IOException e){
                System.out.println("Problem with opening/closing file (IO)");
            }
        }

        System.out.println("Read from file (IO time): "+(System.nanoTime()-start));
        return sB.toString();
    }
    
    private static String readFromFileNIO(String path){
        long start = System.nanoTime();
        StringBuilder sB = null;
        try{
            sB = new StringBuilder();
            List<String> strings = Files.readAllLines(Paths.get(path));

            for(String str : strings){
               sB.append(str); 
            }

        }catch(IOException e){
            System.out.println("Problem with reading from file (NIO)");
        }

        System.out.println("Read from file (NIO time): "+(System.nanoTime()-start));
        return sB.toString();
    }
}
