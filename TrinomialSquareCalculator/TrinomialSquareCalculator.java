public class TrinomialSquareCalculator{
    public static void main(String[] args){
        if(args.length < 3){
            System.out.println("Not enough arguments");
            return;
        }
        try{
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            if(a == 0){
                solveLinearEquation(b,c);
            }else{
                solveTrinomialSquareEquation(a, b, c);
            }
        }catch(NumberFormatException e){
            System.out.println("Passed arguments should be numbers");
        }
    }

    private static void solveLinearEquation(double b, double c){
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

    private static void solveTrinomialSquareEquation(double a, double b, double c){
        double delta = Math.pow(b,2) - 4 * a * c;
        if(delta < 0){
            double realSolution = (-b)/(2*a);
            double imagineSolution = (Math.sqrt(-delta))/(2*a);
            System.out.println("This equation has two solutions: x1=(" + realSolution + " + " + imagineSolution + "i)");
            System.out.println("x2=(" + realSolution + " - " + imagineSolution + "i)");
        }else if(delta == 0){
            double solution = -b/(2*a);
            System.out.println("This equation has only one solution, x = " + solution);
        }else{
            double solution1 = (-b - Math.sqrt(delta))/(2*a);
            double solution2 = (-b + Math.sqrt(delta))/(2*a);
            System.out.println("This equation has two solutions, x1 = " + solution1 + ", x2 = " + solution2);
        }
    }
}
