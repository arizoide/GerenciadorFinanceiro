package sdm.ifsp.edu.br.gerenciadorfinanceiro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import sdm.ifsp.edu.br.gerenciadorfinanceiro.R;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.model.ContaEntity;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.repository.ContaRepository;

public class OperacoesActivity extends Activity {

    private Spinner spinnerContas;

    private Button somarButton;
    private Button subtrairButton;

    private EditText valor;

    ContaRepository contaRepository = new ContaRepository(OperacoesActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacoes);

        //Busca as contas para colocar no spinner
        spinnerContas = findViewById(R.id.contasSpinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, listaContas()
        );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerContas.setAdapter(dataAdapter);

        somarButton = findViewById(R.id.somarButton);

        somarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contaRepository = new ContaRepository(OperacoesActivity.this);
                        valor = findViewById(R.id.valorOperacaoEditText);

                        //Realiza o cadastro no 'banco'
                        ContaEntity conta = contaRepository.buscarContaPelaDescricao(spinnerContas.getSelectedItem().toString());

                        conta.setSaldo(conta.getSaldo() + Long.parseLong(String.valueOf(valor.getText())));

                        contaRepository.salvar(conta, true);

                        //Abre novamente a pagina inicial
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );

        subtrairButton = findViewById(R.id.subtrairButton);

        subtrairButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contaRepository = new ContaRepository(OperacoesActivity.this);
                        valor = findViewById(R.id.valorOperacaoEditText);

                        //Realiza o cadastro no 'banco'
                        ContaEntity conta = contaRepository.buscarContaPelaDescricao(spinnerContas.getSelectedItem().toString());

                        conta.setSaldo(conta.getSaldo() - Long.parseLong(String.valueOf(valor.getText())));

                        contaRepository.salvar(conta, true);

                        //Abre novamente a pagina inicial
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );

    }

    private List<String> listaContas() {
        return contaRepository.listarContas();
    }

}
