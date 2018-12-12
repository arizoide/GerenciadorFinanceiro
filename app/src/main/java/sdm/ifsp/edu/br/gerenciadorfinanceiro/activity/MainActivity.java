package sdm.ifsp.edu.br.gerenciadorfinanceiro.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sdm.ifsp.edu.br.gerenciadorfinanceiro.R;

public class MainActivity extends AppCompatActivity {

    private Button cadastrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrarButton = findViewById(R.id.cadastrarNovaContaButton);

        cadastrarButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), CadastrarActivity.class);
                        startActivityForResult(i, 1);
                    }
                }
        );
    }
}
