public class NewtonRaphson {

    public static void main(String[] args) {

        NewtonRaphson newtonRaphson = new NewtonRaphson();

        newtonRaphson.findSquareRoot(4);
        newtonRaphson.findSquareRoot(6025);
        newtonRaphson.findSquareRoot(-4);
    }

    class cantFindSquareRootException extends Exception{
        public cantFindSquareRootException(String message){
            super(message);
        }
    }

    public void findSquareRoot(double num){
        try {
            double squareRoot = calculateSquareRoot(num);
            System.out.printf("Square root of %f is %f\n",num,squareRoot);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public double calculateSquareRoot(double num) throws cantFindSquareRootException {
        int count = 0;
        double squareRoot = num;
        double error = Math.pow(10,-10);

        while(Math.abs(num - Math.pow(squareRoot,2)) > error){
            if(count > 100){
                String errorMessage = String.format("Cant find square root of %f\n",num);
                throw new cantFindSquareRootException(errorMessage);
            } else {
                squareRoot = applyMethod(num, squareRoot);
                count++;
            }
        }

        return squareRoot;
    }

    public double applyMethod(double num, double squareRoot){
        return squareRoot - ((Math.pow(squareRoot, 2) - num) / (2 * squareRoot));
    }
}
