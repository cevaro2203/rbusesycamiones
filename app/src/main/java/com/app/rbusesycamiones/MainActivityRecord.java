package com.app.rbusesycamiones;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivityRecord extends AppCompatActivity {

    EditText editText_name;
    Button btn_enviar_register;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_record);

        //Inicializar los componentes
        editText_name         = findViewById(R.id.name);


        btn_enviar_register   = findViewById(R.id.btn_enviarRegister);
        btn_enviar_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editText_name.getText().toString().trim();
                Intent intent = new Intent(MainActivityRecord.this, MainActivityLogin.class);
                startActivity(intent);
                Toast.makeText(MainActivityRecord.this, "Estas en Iniciar sesión", Toast.LENGTH_SHORT).show();
            }
        });
/*
        //Para validar el texto cuando pierde el foco.
        inputEmailEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                validateEmail();
            }
        });
        inputPasswordEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                valiatePassword();
            }
        });


        btn_enviar_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarYEnviar();
            }
        });



    }
/*
    private void validateEmail() {
        String email = Objects.requireNonNull(inputEmailEditText.getText()).toString();
        if (email.isEmpty()) {
            inputEmaiLayout.setError("El email es requerido");
        } else {
            inputEmaiLayout.setError(null); //Para eliminar el error si el campo esta vacio
        }
    }tytytyy
    }

    private void validarYEnviar() {
        String email = Objects.requireNonNull(inputEmailEditText.getText()).toString();
        String password = Objects.requireNonNull(inputPasswordEditText.getText()).toString();

        if (email.isEmpty())  {
            inputEmaiLayout.setError("Por favor ingrese su Email");
            return;

        }
        if (password.isEmpty()) {
            inputPasswordLayout.setError("Por favor ingrese su Contraseña");
            return;

        }
        Toast.makeText(MainActivityRecord.this, "Email: " + email + " Password: " + password, Toast.LENGTH_SHORT).show();
    }



    private void limpiarFormulario() {
        editTextName.setText("");
        editTextName.requestFocus();
    }

 */


    }

}