package com.app.rbusesycamiones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivityCarros extends AppCompatActivity {

    private Spinner spinner;
    ImageView imagen_car;
    TextView name_car;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_carros);

        //Cargar vehiculos
        imagen_car = findViewById(R.id.imageCarros);
        name_car = findViewById(R.id.nameCar);

        String imageUrl = "https://www.carfiao.com/Carfiao.Inventario/ImagesVehicle//17c8eaa8-27bb-4a6e-809b-6f9e3167656f.jpg";
        String texto = "VOLKSWAGEN\n" +
                "NIVUS\n" +
                "|\n" +
                "2022";

        //creamos la imagen desde la url
        Glide.with(this)
                .load(imageUrl)
                .into(imagen_car);

        //Configuramos el texto

        name_car.setText(texto);






        //SPINNER MARCAS USADOS
        // Obtén una referencia al Spinner
        spinner = findViewById(R.id.spinner_marca);

        //Define un array de elementos para la lista desplegable
        String[] elementos = {"Marca: ", "Audi", "Bmw", "Chevrolet", "Citroen", "Fiat", "Honda", "Hyundai", "Kia", "Mazda", "Mercedes Benz", "Mini", "Nissan", "Porsche", "Renault", "Subaru", "Suzuki", "Toyota", "Volkswagen", "Kgm", "Mitsubishi", "Changan", "Cupra", "Dfsk", "Ds", "Jac", "Jeep" , "land Rover"};

        //Adaptador para el Spinner
        ArrayAdapter<String> adapter_marca = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos);

        //Diseño que se utilizará cuando la lista aparezca
        adapter_marca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asigna el adaptador al Spinner
        spinner.setAdapter(adapter_marca);

        // Configuracion de un listener para el Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                // Acción a realizar cuando se selecciona un elemento del Spinner
                String elementoSeleccionado = (String) parentView.getItemAtPosition(position);
                Toast.makeText(MainActivityCarros.this, "Seleciono: " + elementoSeleccionado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acción a realizar cuando no se selecciona ningún elemento

            }
        });

        // FIN SPINNER MARCAS USADOS

        // INICIO SPINNER MODELO

        // Obtén una referencia al Spinner
        spinner = findViewById(R.id.spinner_modelo);

        // Define un array de elementos para la lista desplegable
        String[] elementos_modelo = {"Año: ", "2026", "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000","1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960"};

        //Adaptador para el Spinner
        ArrayAdapter<String> adapter_modelo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos_modelo);

        //Diseño que se utilizará cuando la lista aparezca
        adapter_marca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asigna el adaptador al Spinner
        spinner.setAdapter(adapter_modelo);

        // Configuracion de un listener para el Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                // Acción a realizar cuando se selecciona un elemento del Spinner
                String elementoSeleccionado = (String) parentView.getItemAtPosition(position);
                Toast.makeText(MainActivityCarros.this, "Seleciono: " + elementoSeleccionado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acción a realizar cuando no se selecciona ningún elemento

            }
        });

        //FIN SPINNER MODELO


    }
}