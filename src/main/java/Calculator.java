import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator()
    {

    }

    public static void main(String[] args) {
        double num1, num2;
        Calculator cal = new Calculator();
        Scanner scn = new Scanner(System.in);
        while(true)
        {
            System.out.println("-----Calculator---DevOps-----");
            System.out.println("     Choose to perform operations");
            System.out.println("1. To find power");
            System.out.println("2. To find square root");
            System.out.println("3. To find factorial");
            System.out.println("4. To find natural Logarithm");
            System.out.println("5. To find sine of an angle in degrees");
            System.out.println("6. To find cosine of an angle in degrees");
            System.out.println("7. To find tan of an angle in degrees");
            System.out.println("8. To exit");
            int ch;
            try{
                ch = scn.nextInt();
            }catch (InputMismatchException error)
            {
                System.out.println(error.getMessage());
                return;
            }
            switch (ch)
            {
                case 1:
                    System.out.print("Enter the first number : ");
                    num1 = scn.nextDouble();
                    System.out.print("Enter the second number : ");
                    num2 = scn.nextDouble();
                    System.out.println(num1+ " raised to power "+num2+" is : " + cal.power(num1, num2));
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.print("Enter a number : ");
                    num1 = scn.nextDouble();
                    System.out.println("Square root of "+num1+" is : " + cal.sqroot(num1));
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.print("Enter a number; ");
                    num1 = scn.nextDouble();
                    System.out.println("Factorial of " + num1 + " is : " + cal.factorial(num1));
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.print("Enter a number : ");
                    num1 = scn.nextDouble();
                    System.out.println("Natural log of "+num1+" is : " + cal.naturalLog(num1));
                    System.out.println("\n");
                    break;

                case 5:
                    System.out.print("Enter an angle(degrees) : ");
                    num1 = scn.nextDouble();
                    System.out.println("Sine of "+num1+" is : " + cal.sin(num1));
                    System.out.println("\n");
                    break;

                case 6:
                    System.out.print("Enter an angle(degrees) : ");
                    num1 = scn.nextDouble();
                    System.out.println("Cosine of "+num1+" is : " + cal.cos(num1));
                    System.out.println("\n");
                    break;

                case 7:
                    System.out.print("Enter an angle(degrees) : ");
                    num1 = scn.nextDouble();
                    System.out.println("Tan of "+num1+" is : " + cal.tan(num1));
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Khatam Tata Goodbye.....");
                    return;
            }
        }
    }

    public double sin(double num1)
    {
        logger.info("[SIN] - " + num1);
        num1 = Math.toRadians(num1);
        double result = Math.sin(num1);
        logger.info("[RESULT - SIN] - " + result);
        return result;
    }

    public double cos(double num1)
    {
        logger.info("[COS] - " + num1);
        num1 = Math.toRadians(num1);
        double result = Math.cos(num1);
        logger.info("[RESULT - COS] - " + result);
        return result;
    }

    public double tan(double num1)
    {
        logger.info("[TAN] - " + num1);
        double result = 0;
        try{
            if(num1 % 180 == 90)
            {
                result = Double.POSITIVE_INFINITY;
                throw new ArithmeticException("Case of Positive infinity 1.0/0.0");
            }
            else if(num1 % 180 == -90)
            {
                result = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("Case of Negative infinity -1.0/0.0");
            }
            else
            {
                num1 = Math.toRadians(num1);
                result = Math.tan(num1);
            }
        }catch(ArithmeticException err)
        {
            System.out.println("[EXCEPTION - TAN] - UNDEFINED " + err.getLocalizedMessage());
        }
        logger.info("[RESULT - TAN] - " + result);
        return result;
    }

    public double factorial(double num1)
    {
        logger.info("[FACTORIAL] - " + num1);
        double result = fact(num1);
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }

    public double sqroot(double num1) {
        logger.info("[SQUARE ROOT] - " + num1);
        double result = Math.sqrt(num1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }

    public double power(double num1, double num2) {
        logger.info("[POWER - " + num1 + " RAISED TO] " + num2);
        double result = Math.pow(num1,num2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double num1) {
        logger.info("[NATURAL LOG] - " + num1);
        double result = 0;
        try {

            if (num1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(num1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }


    public double fact(double num)
    {
        double f = 1;
        for(int i = 1; i <= num; i++)
        {
            f *= i;
        }
        return f;
    }
}
