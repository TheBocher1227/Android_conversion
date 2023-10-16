package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import Models.Celsius;
import Models.Farenheith;
import Models.Kelvin;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText txt2;
    TextView txt3;

    Spinner spinner1;

    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Grade, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);


        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapters = ArrayAdapter.createFromResource(this, R.array.Grades2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapters);
        spinner2.setOnItemSelectedListener(this);

        Button calcular = findViewById(R.id.btn1);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarCalculo();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void realizarCalculo() {

        String valorIngresado = txt2.getText().toString();

        String escalaEntrada = spinner1.getSelectedItem().toString();
        String escalaSalida = spinner2.getSelectedItem().toString();

        double resultado = 0.0;

        if (escalaEntrada.equals("Celsius") && escalaSalida.equals("Farenheith")) {
            Celsius celsius = new Celsius(Double.parseDouble(valorIngresado));
            Celsius fahrenheit = celsius.parse(new Farenheith(Double.parseDouble(valorIngresado)));

            resultado = fahrenheit.getValor();

            txt3.setText(String.valueOf(resultado));
        }

        if (escalaEntrada.equals("Celsius") && escalaSalida.equals("Kelvin")) {
            Celsius c = new Celsius(Double.parseDouble(valorIngresado));
            Celsius Kelvin = c.parse(new Kelvin(Double.parseDouble(valorIngresado)));
            resultado = Kelvin.getValor();
            txt3.setText(String.valueOf(resultado));
        }

        if(escalaEntrada.equals("Kelvin")&& escalaSalida.equals("Celsius")){
            Kelvin K=new Kelvin(Double.parseDouble(valorIngresado));
            Kelvin C=K.parse(new Celsius(Double.parseDouble(valorIngresado)));
            resultado=C.getValor();
            txt3.setText(String.valueOf(resultado));
        }

        if(escalaEntrada.equals("Kelvin")&& escalaSalida.equals("Farenheith")){
            Kelvin K=new Kelvin(Double.parseDouble(valorIngresado));
            Kelvin F=K.parse(new Farenheith(Double.parseDouble(valorIngresado)));
            resultado=F.getValor();
            txt3.setText(String.valueOf(resultado));
        }

        if(escalaEntrada.equals("Farenheith")&& escalaSalida.equals("Celsius")){
            Farenheith F=new Farenheith(Double.parseDouble(valorIngresado));
            Farenheith C=F.parse(new Celsius(Double.parseDouble(valorIngresado)));
            resultado=C.getValor();
            txt3.setText(String.valueOf(resultado));
        }





    }
}
