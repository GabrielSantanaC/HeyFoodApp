package com.heyfood.heyfoodapp.proprietario.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.heyfood.heyfoodapp.R;
import com.heyfood.heyfoodapp.infra.Sessao;
import com.heyfood.heyfoodapp.proprietario.dominio.Proprietario;

public class PerfilProprietarioActivity extends AppCompatActivity {

    private TextView nome;
    private TextView email;
    private TextView cpf;
    private TextView nascimento;
    private TextView telefone;
    private TextView cep;
    private TextView rua;
    private TextView numero;
    private TextView bairro;
    private TextView cidade;
    private Proprietario proprietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_proprietario);

        proprietario = Sessao.instance.getProprietario();

        nome = findViewById(R.id.nomeProprietarioId);
        email = findViewById(R.id.emailProprietarioId);
        cpf = findViewById(R.id.cpfProprietarioId);
        nascimento = findViewById(R.id.nascimentoProprietarioId);
        telefone = findViewById(R.id.telefoneProprietarioId);
        cep = findViewById(R.id.cepProprietarioId);
        rua = findViewById(R.id.ruaProprietarioId);
        numero = findViewById(R.id.numeroProprietarioId);
        bairro = findViewById(R.id.bairroProprietarioId);
        cidade = findViewById(R.id.cidadeProprietarioId);

        nome.setText(String.format("Nome: %s",proprietario.getUsuario().getPessoa().getNome()));
        email.setText(String.format("email: %s",proprietario.getUsuario().getLogin()));
        cpf.setText(String.format("CPF: %s",proprietario.getUsuario().getPessoa().getCpf()));
        nascimento.setText(String.format("Dada de nascimento: %s",proprietario.getUsuario().getPessoa().getDataNascimento()));
        telefone.setText(String.format("Telefone: %s",proprietario.getUsuario().getPessoa().getContato().getTelefone()));
        cep.setText(String.format("cep: %s",proprietario.getUsuario().getPessoa().getEndereco().getCep()));
        rua.setText(String.format("rua: %s",proprietario.getUsuario().getPessoa().getEndereco().getRua()));
        numero.setText(String.format("numero: %s",proprietario.getUsuario().getPessoa().getEndereco().getNumero()));
        bairro.setText(String.format("bairro: %s",proprietario.getUsuario().getPessoa().getEndereco().getBairro()));
        cidade.setText(String.format("cidade: %s",proprietario.getUsuario().getPessoa().getEndereco().getCidade()));
    }
}
