package sdm.ifsp.edu.br.gerenciadorfinanceiro.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sdm.ifsp.edu.br.gerenciadorfinanceiro.R;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.model.ContaEntity;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.repository.CadastrarRepository;

public class CadastrarActivity extends AppCompatActivity {

    private Button cadastrarButton;

    private EditText descricao;
    private EditText saldo;

    private CadastrarRepository cadastrarRepository = new CadastrarRepository();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        cadastrarButton = findViewById(R.id.cadastrarButton);

        cadastrarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        descricao = findViewById(R.id.descricaoEditText);
                        saldo = findViewById(R.id.saldoEditText);

                        //Realiza o cadastro no 'banco'
                        ContaEntity conta = new ContaEntity(String.valueOf(descricao.getText()), Long.parseLong(String.valueOf(saldo.getText())));

                        cadastrarRepository.salvar(conta);

                        //Abre novamente a pagina inicial
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );
    }
}
