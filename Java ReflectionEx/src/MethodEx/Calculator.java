package MethodEx;


import java.lang.reflect.Method;

public class Calculator {

    private int add(int a,int b){
        return a+b;
    }

    public int multiply(int a,int b){
        return a*b;
    }

    public static void main(String[] args) throws Exception{
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Accessing the public method "multiply"
        Method multiplyMethod = Calculator.class.getMethod("multiply", int.class, int.class);

        System.out.println("Method Name: " + multiplyMethod.getName());  // Output: multiply
        System.out.println("Return Type: " + multiplyMethod.getReturnType());  // Output: int
        //


        // Invoking the public method "multiply" using reflection
        int result = (int) multiplyMethod.invoke(calculator,4,5);
        System.out.println("Result of multiply(4, 5): " + result);

        // Accessing the private method "add"
        Method addMethod = Calculator.class.getDeclaredMethod("add",int.class,int.class);
        addMethod.setAccessible(true); // Make the private method accessible

        // Invoking the private method "add" using reflection
        int sum = (int) addMethod.invoke(calculator,10,20);
        System.out.println("Result of add(10, 20): " + sum);
    }

    }
