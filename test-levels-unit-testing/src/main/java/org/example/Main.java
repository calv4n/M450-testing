package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();


        // Beispielberechnungen
        double sum = calculator.add(5, 3);
        double difference = calculator.subtract(10, 4);
        double product = calculator.multiply(2, 7);
        double quotient = calculator.divide(15, 3);

        // Ergebnisse ausgeben
        System.out.println("Addition: 5 + 3 = " + sum);
        System.out.println("Subtraktion: 10 - 4 = " + difference);
        System.out.println("Multiplikation: 2 * 7 = " + product);
        System.out.println("Division: 15 / 3 = " + quotient);

        // Division durch Null testen
        try {
            calculator.divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}
