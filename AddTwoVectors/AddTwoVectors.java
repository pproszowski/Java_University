import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import java.lang.Exception;
import java.io.*;
import java.util.stream.Collectors;

class DifferentVectorsLengths extends Exception{
    private int firstLength;
    private int secondLength;

    public DifferentVectorsLengths(int a, int b){
        super();
        firstLength = a;
        secondLength = b;
    }

    public String getMessage(){
        return "Provided vectors have different lengths (first: " + firstLength + " second: " + secondLength + ")";
    }


};

public class AddTwoVectors{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        boolean repeat = true;

        List<Double> result;
        List<List<Double>> vectors;
        while(repeat){
            System.out.println("Type two vectors (each number in vector should be separated by space and each vector should be seperated by enter key):");
            vectors = readVectors();
            try{
                result = addTwoVectors(vectors);
                repeat = false;
                writeResultOfAdditionToFile(result);
            }catch(DifferentVectorsLengths e){
                System.out.println(e.getMessage());
            }
        }
        
    }

    private static List<List<Double>> readVectors(){

        List<List<Double>> vectors = new ArrayList<>();

            while(vectors.size() < 2){
                String temp = scanner.nextLine();
                try{
                     List<Double> vector = convertStringToDoubleList(temp);
                     vectors.add(vector);
                }catch(NumberFormatException e){
                    System.out.println("Vectors can consist doubles only.");
                }
            }
            return vectors;
    }

    private static List<Double> convertStringToDoubleList(String string) throws NumberFormatException{

        String[] strArray = string.split(" ");

        ArrayList<Double> vector = new ArrayList<Double>();

        for(int i = 0; i < strArray.length; i++){
            vector.add(Double.parseDouble(strArray[i]));
        }

        return vector;
    }

    private static List<Double> addTwoVectors(List<List<Double>> vectors) throws DifferentVectorsLengths{
        List<Double> result = new ArrayList<>();
        if(vectors.get(0).size() != vectors.get(1).size()){
            throw new DifferentVectorsLengths(vectors.get(0).size(), vectors.get(1).size()); 
        }
        
        int size = vectors.get(0).size();

        for(int i = 0; i < size; i++){
           result.add(vectors.get(0).get(i) + vectors.get(1).get(i));
        }

        return result;
    }

    private static void writeResultOfAdditionToFile(List<Double> result){
        PrintWriter writer = null;
        String toPrint = result.stream().map(Object::toString).collect(Collectors.joining(" "));
        try{
            writer = new PrintWriter("result.txt", "UTF-8");
            writer.print(toPrint);
            System.out.println("Result of addition has been saved to a file.");
        }catch(IOException e){
            System.out.println("Problem with writing to file");
        }finally{
            if(writer != null){
                writer.close();
            }
        }
    }


}

