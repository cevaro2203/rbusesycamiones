package com.app.rbusesycamiones;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.app.rbusesycamiones.databinding.ActivityMainBinding;
//import com.app.rbusesycamiones.databinding.ActivityMainRecordBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ViewPager2 viewPager;
    Spinner spinner;
    BannerAdapter bannerAdapter;
    private static final long DELAY_MS = 2000; // Tiempo del banner
    private static final long PERIOD_MS = 2000; //Tiempo del banner
    Button button;


    //PARA LA CONECION
    private static final String BASE_URL = "localhost:8080/client";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Inicializar Firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        * */

        
        
        //Conexion a Firebase



        com.app.rbusesycamiones.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //onclick Listener boton Record
        button = findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityRecord.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Estas en Registrarse", Toast.LENGTH_SHORT).show();
            }
        });
        //Enviar a pantalla Audi







        //FIN onclick Listener boton Record

        //SPINNER USADOS
        // Obtén una referencia al Spinner
        spinner = findViewById(R.id.spinner_usados);

        // Define un array de elementos para la lista desplegable
        String[] elementos_usados = {"Escoja el tipo de vehículo", "Automoviles Camperos y Suv", "Carga", "Motos", "Otros"};

        //Adaptador para el Spinner
        ArrayAdapter<String> adapter_usados = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos_usados);

        //Diseño que se utilizará cuando la lista aparezca
        adapter_usados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asigna el adaptador al Spinner
        spinner.setAdapter(adapter_usados);

        // Configuracion de un listener para el Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                // Acción a realizar cuando se selecciona un elemento del Spinner
                String elementoSeleccionado = (String) parentView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Seleciono: " + elementoSeleccionado, Toast.LENGTH_SHORT).show();

                // Dirigir a diferentes actividades según la opción seleccionada
                switch (elementoSeleccionado) {
                    case "Automoviles Camperos y Suv":
                        // Dirigir a la actividad CarrosFragment
                        Intent intent = new Intent(getApplicationContext(), MainActivityCarros.class);
                        startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acción a realizar cuando no se selecciona ningún elemento

            }
        });
        //fin spinner usados


        // BANNER

        viewPager = findViewById(R.id.viewPager);

        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://www.busesycamioneschevrolet.com.co/wp-content/uploads/2023/07/banner-contacto_1920x472-px_Desk_V2-1.png");
        imageUrls.add("https://www.busesycamioneschevrolet.com.co/wp-content/uploads/2022/05/camion-nqr-portada-blog.jpg");
        imageUrls.add("https://www.busesycamioneschevrolet.com.co/wp-content/uploads/2022/05/blog-1.jpg");
        imageUrls.add("https://www.busesycamioneschevrolet.com.co/wp-content/uploads/2022/05/imagen-2.jpg");
        imageUrls.add("https://www.busesycamioneschevrolet.com.co/wp-content/uploads/2023/07/banner-contacto_450x720-px@2x-min_mobile_V2-1.png");
        imageUrls.add("https://www.busesycamioneschevrolet.com.co/wp-content/uploads/2022/05/blog-1.jpg");
        imageUrls.add("https://www.busesycamioneschevrolet.com.co/wp-content/uploads/2024/02/FOTOS-DESTACADA_2.jpg");
        imageUrls.add("https://images2.nogueirense.com.br/wp-content/uploads/2018/06/lista-digital-1527884507-600x302.png");

        bannerAdapter = new BannerAdapter(this, imageUrls);
        viewPager.setAdapter(bannerAdapter);

        // Auto scroll banner
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable update = () -> {
            if (viewPager.getCurrentItem() == imageUrls.size() - 1) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);

        //FIN BANNER
/*
        //CONEXION CON EL BACKEND

        // Configuración de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear instancia de la interfaz MyBackendService
        backendService = retrofit.create(BackendService.class);

        // Realizar la solicitud HTTP
        Call<MainActivityRecord> call = backendService.getDatosDelBackend();
        call.enqueue(new Callback<MainActivityRecord>() {
            @Override
            public void onResponse(Call<MainActivityRecord> call, Response<MainActivityRecord> response) {
                // Manejar la respuesta del servidor aquí
            }

            @Override
            public void onFailure(Call<MainActivityRecord> call, Throwable t) {
                // Manejar errores de conexión aquí
            }
        });
        //Fin conoxion Backend

 */
        /*
        //Conexion con PostgrSQL

        Connection conn = null;
        try {
            // Registra el controlador JDBC
            Class.forName("org.postgresql.Driver");

            // Abre una conexión
            String url = "jdbc:postgresql://localhost:5432/rbusesycamiones";
            String usuario = "rosendo";
            String contraseña = "rosendo";
            conn = DriverManager.getConnection(url, usuario, contraseña);

            // Realiza consultas a la base de datos utilizando sentencias SQL
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
*/



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}