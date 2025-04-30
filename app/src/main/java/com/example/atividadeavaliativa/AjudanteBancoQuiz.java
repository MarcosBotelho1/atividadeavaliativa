package com.example.atividadeavaliativa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AjudanteBancoQuiz extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "Quiz.db";
    private static final int VERSAO_BANCO = 1;
    private static final String TABELA_PERGUNTAS = "perguntas";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_PERGUNTA = "pergunta";
    private static final String COLUNA_OPCAO1 = "opcao1";
    private static final String COLUNA_OPCAO2 = "opcao2";
    private static final String COLUNA_OPCAO3 = "opcao3";
    private static final String COLUNA_RESPOSTA = "resposta";

    public AjudanteBancoQuiz(Context contexto) {
        super(contexto, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        String CRIAR_TABELA = "CREATE TABLE " + TABELA_PERGUNTAS + "("
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_PERGUNTA + " TEXT,"
                + COLUNA_OPCAO1 + " TEXT,"
                + COLUNA_OPCAO2 + " TEXT,"
                + COLUNA_OPCAO3 + " TEXT,"
                + COLUNA_RESPOSTA + " INTEGER)";
        banco.execSQL(CRIAR_TABELA);
        inserirPerguntasExemplo(banco);
    }

    private void inserirPerguntasExemplo(SQLiteDatabase banco) {

        ContentValues valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual é a capital do Brasil?");
        valores.put(COLUNA_OPCAO1, "Rio de Janeiro");
        valores.put(COLUNA_OPCAO2, "Brasília");
        valores.put(COLUNA_OPCAO3, "São Paulo");
        valores.put(COLUNA_RESPOSTA, 2);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual jogador é conhecido como 'Rei do Futebol'?");
        valores.put(COLUNA_OPCAO1, "Diego Maradona");
        valores.put(COLUNA_OPCAO2, "Pelé");
        valores.put(COLUNA_OPCAO3, "Lionel Messi");
        valores.put(COLUNA_RESPOSTA, 2);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Quantas vezes o Brasil venceu a Copa do Mundo?");
        valores.put(COLUNA_OPCAO1, "4");
        valores.put(COLUNA_OPCAO2, "5");
        valores.put(COLUNA_OPCAO3, "6");
        valores.put(COLUNA_RESPOSTA, 2);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual jogador é conhecido como 'La Pulga'?");
        valores.put(COLUNA_OPCAO1, "Cristiano Ronaldo");
        valores.put(COLUNA_OPCAO2, "Neymar Jr");
        valores.put(COLUNA_OPCAO3, "Lionel Messi");
        valores.put(COLUNA_RESPOSTA, 3);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Em que ano o Brasil sediou a Copa do Mundo pela última vez?");
        valores.put(COLUNA_OPCAO1, "2010");
        valores.put(COLUNA_OPCAO2, "2014");
        valores.put(COLUNA_OPCAO3, "2018");
        valores.put(COLUNA_RESPOSTA, 2);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual destes jogadores nunca ganhou a Bola de Ouro?");
        valores.put(COLUNA_OPCAO1, "Zinedine Zidane");
        valores.put(COLUNA_OPCAO2, "Neymar Jr");
        valores.put(COLUNA_OPCAO3, "Ronaldo Fenômeno");
        valores.put(COLUNA_RESPOSTA, 2);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual clube é o maior vencedor da Liga dos Campeões da UEFA?");
        valores.put(COLUNA_OPCAO1, "Barcelona");
        valores.put(COLUNA_OPCAO2, "Bayern de Munique");
        valores.put(COLUNA_OPCAO3, "Real Madrid");
        valores.put(COLUNA_RESPOSTA, 3);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual jogador brasileiro é o maior artilheiro da Seleção Brasileira?");
        valores.put(COLUNA_OPCAO1, "Pelé");
        valores.put(COLUNA_OPCAO2, "Ronaldo");
        valores.put(COLUNA_OPCAO3, "Neymar");
        valores.put(COLUNA_RESPOSTA, 3);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual foi o placar do 'Maracanazo' em 1950?");
        valores.put(COLUNA_OPCAO1, "Brasil 1 x 2 Uruguai");
        valores.put(COLUNA_OPCAO2, "Brasil 2 x 1 Uruguai");
        valores.put(COLUNA_OPCAO3, "Uruguai 2 x 1 Brasil");
        valores.put(COLUNA_RESPOSTA, 1);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual destes técnicos nunca treinou a Seleção Brasileira?");
        valores.put(COLUNA_OPCAO1, "José Mourinho");
        valores.put(COLUNA_OPCAO2, "Felipão");
        valores.put(COLUNA_OPCAO3, "Tite");
        valores.put(COLUNA_RESPOSTA, 1);
        banco.insert(TABELA_PERGUNTAS, null, valores);

        valores = new ContentValues();
        valores.put(COLUNA_PERGUNTA, "Qual jogador fez o 'Gol de Placa' em 1961?");
        valores.put(COLUNA_OPCAO1, "Garrincha");
        valores.put(COLUNA_OPCAO2, "Pelé");
        valores.put(COLUNA_OPCAO3, "Didí");
        valores.put(COLUNA_RESPOSTA, 2);
        banco.insert(TABELA_PERGUNTAS, null, valores);
    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int versaoAntiga, int versaoNova) {
        banco.execSQL("DROP TABLE IF EXISTS " + TABELA_PERGUNTAS);
        onCreate(banco);
    }

    public List<Pergunta> obterTodasPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();
        SQLiteDatabase banco = this.getReadableDatabase();

        Cursor cursor = banco.rawQuery("SELECT * FROM " + TABELA_PERGUNTAS, null);

        if (cursor.moveToFirst()) {
            do {
                Pergunta pergunta = new Pergunta();
                pergunta.setId(cursor.getInt(0));
                pergunta.setPergunta(cursor.getString(1));
                pergunta.setOpcao1(cursor.getString(2));
                pergunta.setOpcao2(cursor.getString(3));
                pergunta.setOpcao3(cursor.getString(4));
                pergunta.setResposta(cursor.getInt(5));
                perguntas.add(pergunta);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return perguntas;
    }

}
