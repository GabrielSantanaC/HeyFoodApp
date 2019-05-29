package com.heyfood.heyfoodapp.infra.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.heyfood.heyfoodapp.R;
import com.heyfood.heyfoodapp.cliente.dominio.Cliente;
import com.heyfood.heyfoodapp.infra.Sessao;
import com.heyfood.heyfoodapp.usuario.dominio.Usuario;
import com.heyfood.heyfoodapp.usuario.negocio.UsuarioServices;

public class MainActivity extends AppCompatActivity {
    private final UsuarioServices services = new UsuarioServices(this);

    TextView nome;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliente = Sessao.instance.getCliente();

        nome = findViewById(R.id.textBoasVIndasId);
        nome.setText(String.format("Bem vindo, %s!", cliente.getUsuario().getPessoa().getNome()));
    }


}
