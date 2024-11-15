package com.example.factorialapp.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.factorialapp.R;
import com.example.factorialapp.model.FactorialModel;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Button btnCalcular;
    private TextView outputResultado;
    private FactorialModel modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el modelo
        modelo = new FactorialModel();

        // Referencias a la Vista
        inputNumber = findViewById(R.id.input_number);
        btnCalcular = findViewById(R.id.btn_calcular);
        outputResultado = findViewById(R.id.output_resultado);

        // Configurar el botón para calcular el factorial
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFactorial();
            }
        });
    }

    // Método para calcular el factorial y mostrar el resultado
    private void calcularFactorial() {
        try {
            // Obtener el número ingresado
            int numero = Integer.parseInt(inputNumber.getText().toString());

            // Calcular el factorial utilizando el modelo
            long resultado = modelo.calcularFactorial(numero);

            // Mostrar el resultado en el TextView
            outputResultado.setText("El factorial de " + numero + " es: " + resultado);
        } catch (NumberFormatException e) {
            // Si el usuario no ingresa un número válido
            outputResultado.setText("Por favor, introduce un número válido.");
        } catch (IllegalArgumentException e) {
            // Si el número no cumple con las restricciones
            outputResultado.setText(e.getMessage());
        }
    }
}
