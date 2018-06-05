package com.chila.mascotas.pojo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chila.mascotas.EnviarMail;
import com.chila.mascotas.R;


public class Contacto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        TextView contNombre = findViewById(R.id.contacto_nombre);
        TextView contMail = findViewById(R.id.contacto_mail);
        TextView contMensaje = findViewById(R.id.contacto_mensaje);
        Button contBoton = findViewById(R.id.contacto_boton);



        contBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();

            }
        });


    }

    private void sendEmail() {




        //Getting content for email
        String email = "chila_granate@hotmail.com";
        String subject = "Mail contacto";
        String message = "Mensaje";

        //Creating SendMail object
        EnviarMail sm = new EnviarMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();

    }
}
