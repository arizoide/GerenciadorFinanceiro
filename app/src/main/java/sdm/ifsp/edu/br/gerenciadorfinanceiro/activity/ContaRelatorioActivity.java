package sdm.ifsp.edu.br.gerenciadorfinanceiro.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

import sdm.ifsp.edu.br.gerenciadorfinanceiro.R;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.model.ContaEntity;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.model.TransacaoEntity;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.repository.ContaRepository;
import sdm.ifsp.edu.br.gerenciadorfinanceiro.repository.TransacaoRepository;

public class ContaRelatorioActivity extends Activity {

    private Spinner spinnerContas;
    private Button gerarRelatorioContaButton;

    ContaRepository contaRepository = new ContaRepository(ContaRelatorioActivity.this);
    TransacaoRepository transacaoRepository = new TransacaoRepository(ContaRelatorioActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_relatorio);

        //Busca as contas para colocar no spinner
        spinnerContas = findViewById(R.id.contasSpinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, listaContas()
        );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerContas.setAdapter(dataAdapter);

        //Botao para voltar para a tela inicial da porra toda
        gerarRelatorioContaButton = findViewById(R.id.gerarRelatorioContaButton);

        gerarRelatorioContaButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Gerar relatorio nos logs por enquanto
                        //Realiza o cadastro no 'banco'
                        ContaEntity conta = contaRepository.buscarContaPelaDescricao(spinnerContas.getSelectedItem().toString());

                        gerarRelatorio(conta);

                        Intent i = new Intent(getApplicationContext(), RelatorioContaActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );
    }

    private void gerarRelatorio(ContaEntity conta) {
        List<TransacaoEntity> transacaoEntities = transacaoRepository.buscarPorConta(conta);

        for (TransacaoEntity transaction : transacaoEntities) {
            Log.i("Relatorio: ", transaction.toString());
        }
    }

    private List<String> listaContas() {
        return contaRepository.listarContas();
    }


}
