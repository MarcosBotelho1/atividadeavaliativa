package com.example.atividadeavaliativa;

public class Pergunta {
    private int id;
    private String pergunta;
    private String opcao1;
    private String opcao2;
    private String opcao3;
    private int resposta;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPergunta() { return pergunta; }
    public void setPergunta(String pergunta) { this.pergunta = pergunta; }
    public String getOpcao1() { return opcao1; }
    public void setOpcao1(String opcao1) { this.opcao1 = opcao1; }
    public String getOpcao2() { return opcao2; }
    public void setOpcao2(String opcao2) { this.opcao2 = opcao2; }
    public String getOpcao3() { return opcao3; }
    public void setOpcao3(String opcao3) { this.opcao3 = opcao3; }
    public int getResposta() { return resposta; }
    public void setResposta(int resposta) { this.resposta = resposta; }
}
