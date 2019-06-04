package com.heyfood.heyfoodapp.proprietario.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.heyfood.heyfoodapp.R;
import com.heyfood.heyfoodapp.util.MaskEditUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastrarProprietarioActivity extends AppCompatActivity {
    private EditText nome;
    private EditText login;
    private EditText senha;
    private EditText dataNascimento;
    private EditText cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_proprietario);

        nome = findViewById(R.id.textNomeId);
        login = findViewById(R.id.campoLoginId);
        senha = findViewById(R.id.campoSenhaId);
        dataNascimento = findViewById(R.id.campoDataId);
        cpf = findViewById(R.id.campoCpfId);

        dataNascimento.addTextChangedListener(MaskEditUtil.mask(dataNascimento, MaskEditUtil.FORMAT_DATE));
        cpf.addTextChangedListener(MaskEditUtil.mask(cpf, MaskEditUtil.FORMAT_CPF));
    }
    private boolean validarCpf(){
        if (this.cpf.getText().toString().length()<14){
            return false;
        }
        String campoCpf = this.cpf.getText().toString().replace(".", "");
        campoCpf = campoCpf.replace("-","");
        //int cpf = Integer.parseInt(campoCpf);
        int soma = 0;
        for (int i=10, j=0 ; i>1 ; i--, j++){
            soma += Integer.parseInt(campoCpf.substring(j, j+1)) * i;
        }
        if((soma*10)%11 == 10){
            soma = 0;
        }
        if (!((soma*10)%11 == Integer.parseInt(campoCpf.substring(9,10)))){
            return false;
        }
        soma = 0;
        for (int i=11, j=0 ; i>1 ; i--, j++) {
            soma += Integer.parseInt(campoCpf.substring(j, j + 1)) * i;
        }
        if((soma*10)%11 == 10) {
            soma = 0;
        }
        if (!((soma*10)%11 == Integer.parseInt(campoCpf.substring(10)))){
            return false;
        }
        return true;

    }

    private boolean validarEmail() {
        String email = login.getText().toString();
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    private boolean validarData() {
        String data = dataNascimento.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        try {
            Date date = format.parse(data);
            return true;
        } catch (ParseException e) {
            return false;

        }
    }
    private boolean validarCampos(){
        return
                nome.getText().toString().length() != 0 &&
                        login.getText().toString().length() != 0 &&
                        senha.getText().toString().length() != 0 &&
                        dataNascimento.getText().toString().length() != 0 &&
                        cpf.getText().toString().length() !=0;

    }

    public void cadastrar(View view) {
        if (!validarCampos()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
            return;
        }
        if (!validarEmail()) {
            Toast.makeText(this, "Email inválido.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!validarData()) {
            Toast.makeText(this, "Data inválida.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!validarCpf()) {
            Toast.makeText(this, "CPF inválido.", Toast.LENGTH_LONG).show();
            return;
        }
    }
}