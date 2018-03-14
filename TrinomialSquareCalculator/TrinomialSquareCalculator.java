public class TrinomialSquareCalculator{
    public static void main(String[] args){
        if(args.length < 3){
            System.out.println("Not enough arguments");
            return;
        }
        try{
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);

            double delta = Math.pow(b,2) - 4 * a * c;

            if(a == 0){
                solveLinearEquation(b,c);
            }else{
                solveTrinomialSquareEquation(a, b, c);
            }
        }catch(NumberFormatException e){
            System.out.println("Passed arguments should be integers");
        }
    }

    private static void solveLinearEquation(int b, int c){
        if(b == 0){
            if(c == 0){
                System.out.println("This equation has infinite number of solutions");
            }else{
                System.out.println("This equation does not have any solution");
            }
        }else{
            double solution = -c/b;
            System.out.println("This equation has only one solution, x = " + solution);
        }
    }

    private static void solveTrinomialSquareEquation(int a, int b, int c){
        if(delta < 0){
            System.out.println("There is no solution in interval of real numbers for passed parameters");
        }else if(delta == 0){
            int solution = -b/(2*a);
            System.out.println("This equation has only one solution, x = " + solution);
        }else{
            double solution1 = (-b - Math.sqrt(delta))/(2*a);
            double solution2 = (-b + Math.sqrt(delta))/(2*a);
            System.out.println("This equation has two solutions, x1 = " + solution1 + ", x2 = " + solution2);
        }
    }
}
