package edu.upc.dsa.kebabsimulator_android;

import static edu.upc.dsa.kebabsimulator_android.models.API.apiService;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import edu.upc.dsa.kebabsimulator_android.models.FormData;
import edu.upc.dsa.kebabsimulator_android.models.FormResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;

import java.text.Normalizer;

public class FormActivity extends AppCompatActivity {

    private EditText etNombre, etEmail, etMensaje;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNombre = findViewById(R.id.et_nombre);
        etEmail = findViewById(R.id.et_email);
        etMensaje = findViewById(R.id.et_mensaje);
        btnEnviar = findViewById(R.id.btn_enviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String email = etEmail.getText().toString();
                String mensaje = etMensaje.getText().toString();

                if (nombre.isEmpty() || email.isEmpty() || mensaje.isEmpty()) {
                    Toast.makeText(FormActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    FormData formData = new FormData(nombre, email, mensaje);
                    Call<FormResponse> call = apiService.submitForm(formData);

                    call.enqueue(new Callback<FormResponse>() {
                        @Override
                        public void onResponse(Call<FormResponse> call, Response<FormResponse> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(FormActivity.this, "Información enviada", Toast.LENGTH_SHORT).show();
                                etNombre.setText("");
                                etEmail.setText("");
                                etMensaje.setText("");
                                FormResponse formResponse = response.body();
                            } else {
                                Toast.makeText(FormActivity.this, "Error al enviar la información", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<FormResponse> call, Throwable t) {
                            Toast.makeText(FormActivity.this, "Fallo en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.e("MAIN", "Fallo en la conexión: " + t.getMessage());

                        }
                    });
                }
            }
        });
    }
}