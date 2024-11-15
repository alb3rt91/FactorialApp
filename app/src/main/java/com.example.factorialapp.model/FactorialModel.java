package com.example.factorialapp.model;

public class FactorialModel {

    // Método para calcular el factorial
    public long calcularFactorial(int numero) throws IllegalArgumentException {
        // Validar que el número sea positivo
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser positivo.");
        }
        // Validar que el número no sea mayor a 20
        if (numero > 20) {
            throw new IllegalArgumentException("El número es demasiado grande (máximo: 20).");
        }

        // Calcular el factorial
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
