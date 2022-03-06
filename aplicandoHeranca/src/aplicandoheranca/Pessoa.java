/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicandoheranca;

/**
 *
 * @author MASTER
 */
public class Pessoa {
    private String nome;
    private String cidade;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    public Pessoa(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String gerarRelatorio(){
        String msg = "Nome da pessoa: " + this.getNome() + "\n";
        msg += "Nome da Cidade: " + this.getCidade() + "\n";
        return msg;
    }
    
    
}

class PessoaFisica extends Pessoa{
    private String cpf;
    private String rg;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, String rg, String nome) {
        super(nome);
        this.cpf = cpf;
        this.rg = rg;
    }
    
    public PessoaFisica(String cpf, String rg, String nome, String cidade) {
        super(nome, cidade);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    @Override
    public String gerarRelatorio(){
        String msg = super.gerarRelatorio();
        msg += "Cpf da pessoa: " + this.getCpf() + "\n";
        msg += "Rg da pessoa: " + this.getRg() + "\n";
        return msg;
    }
}

class PessoaJuridica extends Pessoa{
    private String cnpj;
    private String ie;
    
    public PessoaJuridica(){
        
    }

    public PessoaJuridica(String cnpj, String ie, String nome) {
        super(nome);
        this.cnpj = cnpj;
        this.ie = ie;
    }
    
    public PessoaJuridica(String cnpj, String ie, String nome, String cidade) {
        super(nome, cidade);
        this.cnpj = cnpj;
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
    
    @Override
    public String gerarRelatorio(){
        String msg = super.gerarRelatorio();
        msg += "Cnpj da Pessoa: " + this.getCnpj() + "\n";
        msg += "Ie da Pessoa: " + this.getIe() + "\n";
        return msg;
    }
}
