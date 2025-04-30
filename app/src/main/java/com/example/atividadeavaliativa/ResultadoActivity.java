package com.example.atividadeavaliativa;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView textoResultado = findViewById(R.id.textoResultado);
        TextView textoPontuacao = findViewById(R.id.textoPontuacao);
        Button botaoVoltar = findViewById(R.id.botaoVoltar);

        int pontuacao = getIntent().getIntExtra("pontuacao", 0);
        int total = getIntent().getIntExtra("total", 0);

        textoPontuacao.setText("Pontuação: " + pontuacao + "/" + total);

        String mensagem;
        if (pontuacao == total) {
            mensagem = "Parabéns! Você acertou tudo!";
        } else if (pontuacao > total/2) {
            mensagem = "Bom trabalho! Você foi bem!";
        } else {
            mensagem = "Tente novamente! Você pode melhorar!";
        }
        textoResultado.setText(mensagem);

        botaoVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ResultadoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}