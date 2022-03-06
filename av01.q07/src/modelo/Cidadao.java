/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MASTER
 */
public class Cidadao extends Pessoa{
    
    protected enum Sexo {MASCULINO, FEMININO}
    protected enum RA {BRASILIA, MINAS_GERAIS, PORTO_SEGURO, MATO_GROSSO }
    protected enum Pergunta {SIM_POSITIVO, SIM_NEGATIVO, NAO}
    protected Pergunta pergunta;
    protected Sexo sexo;
    protected RA ra;
    
    protected String nome;
    protected float peso;
    protected int idade;
    protected float altura;
    protected String dataVacinacao;
    
    public Cidadao(){
        
    }

    public Cidadao(Pergunta pergunta, Sexo sexo, RA ra, String nome, float peso, int idade, float altura, String dataVacinacao) {
        this.pergunta = pergunta;
        this.sexo = sexo;
        this.ra = ra;
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
        this.dataVacinacao = dataVacinacao;
    }
    
    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public RA getRa() {
        return ra;
    }

    public void setRa(RA ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(String dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    @Override
    public String toString() {
        return "Pessoa|" + "pergunta=" + pergunta + ", sexo=" + sexo + ", ra=" + ra + ", nome=" + nome + ", peso=" + peso + ", idade=" + idade + ", altura=" + altura + ", dataVacinacao=" + dataVacinacao + '|' + "\n";
    }
    
}
