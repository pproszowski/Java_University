class BeginGreaterThanEndException extends Exception{
    private int begin;
    private int end;
    private int lengthOfString;
    private final String message;

    public BeginGreaterThanEndException(int _begin, int _end, int _lengthOfString){
        begin = _begin;
        end = _end;
        lengthOfString = _lengthOfString;

        if(end < begin){
            message = "Second Integer should be greater than first or equal. second = " + end;
        }else if(begin < 0){
            message = "First integer should be greater than zero. first = " + begin; 
        }else if(end > lengthOfString){
            end--;
            lengthOfString--;
            message = "Second integer should be euqal or less than length of string." + end + ">" + lengthOfString;
        }else{
            message = "";
        }
    }

    public String getMessage(){
        return message;
    }
}
public class StringCutter{
    public static void main(String[] args){
        if(args.length < 3){
            System.out.println("Three arguments should be provided");
            return;
        }

        try{
            int begin = Integer.parseInt(args[1]);
            int end = Integer.parseInt(args[2]) + 1;
            String str = args[0];

            if(end < begin || begin < 0 || end > str.length()){
                throw new BeginGreaterThanEndException(begin, end, str.length());
            }

            System.out.println(str.substring(begin, end));
        }catch(NumberFormatException e){
            System.out.println("Second and third argument should be integers");
        }catch(BeginGreaterThanEndException e){
            System.out.println(e.getMessage());
        }
    }
}
