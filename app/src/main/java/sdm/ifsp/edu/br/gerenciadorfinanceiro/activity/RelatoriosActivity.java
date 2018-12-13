package sdm.ifsp.edu.br.gerenciadorfinanceiro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import sdm.ifsp.edu.br.gerenciadorfinanceiro.R;

public class RelatoriosActivity extends Activity {

    private Button contaRelatorioButton;
    private Button tipoTransacaoRelatorioButton;
    private Button naturezaRelatorioButton;
    private Button voltarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorios);

        contaRelatorioButton = findViewById(R.id.contaRelatorioButton);

        contaRelatorioButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Por hora lista com logs o relatorio



                    }
                }
        );

        tipoTransacaoRelatorioButton = findViewById(R.id.tipoTransacaoRelatorioButton);

        tipoTransacaoRelatorioButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), OperacoesActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );

        naturezaRelatorioButton = findViewById(R.id.naturezaRelatorioButton);

        naturezaRelatorioButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), RelatoriosActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );


        //Botao para voltar para a tela inicial da porra toda
        voltarButton = findViewById(R.id.voltarButton);

        voltarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );
    }

}
