package com.example.atividadeavaliativa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class QuizActivity extends AppCompatActivity {
    private TextView textoPergunta;
    private RadioGroup grupoOpcoes;
    private RadioButton opcao1, opcao2, opcao3;
    private Button botaoResponder;
    private int perguntaAtual = 0;
    private int pontuacao = 0;
    private List<Pergunta> perguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textoPergunta = findViewById(R.id.textoPergunta);
        grupoOpcoes = findViewById(R.id.grupoOpcoes);
        opcao1 = findViewById(R.id.opcao1);
        opcao2 = findViewById(R.id.opcao2);
        opcao3 = findViewById(R.id.opcao3);
        botaoResponder = findViewById(R.id.botaoResponder);

        AjudanteBancoQuiz bancoHelper = new AjudanteBancoQuiz(this);
        perguntas = bancoHelper.obterTodasPerguntas();

        mostrarPergunta();

        botaoResponder.setOnClickListener(v -> verificarResposta());
    }

    private void mostrarPergunta() {
        if (perguntaAtual < perguntas.size()) {
            Pergunta pergunta = perguntas.get(perguntaAtual);
            textoPergunta.setText(pergunta.getPergunta());
            opcao1.setText(pergunta.getOpcao1());
            opcao2.setText(pergunta.getOpcao2());
            opcao3.setText(pergunta.getOpcao3());
            grupoOpcoes.clearCheck();
        } else {

            Intent intent = new Intent(QuizActivity.this, ResultadoActivity.class);
            intent.putExtra("pontuacao", pontuacao);
            intent.putExtra("total", perguntas.size());
            startActivity(intent);
            finish();
        }
    }

    private void verificarResposta() {
        int idSelecionado = grupoOpcoes.getCheckedRadioButtonId();

        if (idSelecionado == -1) {
            Toast.makeText(this, "Selecione uma opção!", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioSelecionado = findViewById(idSelecionado);
        int numeroResposta = grupoOpcoes.indexOfChild(radioSelecionado) + 1;

        if (numeroResposta == perguntas.get(perguntaAtual).getResposta()) {
            pontuacao++;
            Toast.makeText(this, "Correto!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Errado! A resposta correta é: " +
                    obterRespostaCorreta(), Toast.LENGTH_LONG).show();
        }

        perguntaAtual++;
        mostrarPergunta();
    }

    private String obterRespostaCorreta() {
        int numeroResposta = perguntas.get(perguntaAtual).getResposta();
        switch (numeroResposta) {
            case 1: return perguntas.get(perguntaAtual).getOpcao1();
            case 2: return perguntas.get(perguntaAtual).getOpcao2();
            case 3: return perguntas.get(perguntaAtual).getOpcao3();
            default: return "";
        }
    }
}