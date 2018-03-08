public class StringCutter{
    public static void main(String[] args){
        if(args.length < 3){
            System.out.println("At least 3 arguments should be provided");
            return;
        }

        try{
            int begin = Integer.parseInt(args[0]);
            int end = Integer.parseInt(args[1]) + 1;
            if(end < begin){
                System.out.println("Second integer (endIndex) should be less or equal than first integer (beginIndex)");
            }
            String str = args[2];
            System.out.println(str.substring(begin, end));
        }catch(NumberFormatException e){
            System.out.println("Two first arguments should be integers");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Second integer should be less than string length and first should greater or equal 0\nIndex out of bounds exception");
        }
    }
}
