/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicandosobrescrita.classes;

/**
 *
 * @author MASTER
 */
public class Empregado {
    protected float salario;

    public Empregado() {
    }
    
    public Empregado(float salario) {
        this.salario = salario;
    }
    

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    public float receber(){
        this.salario = 1000f;
        return salario;
    }
}
class Chefe extends Empregado{

    public Chefe() {
    }
    
    
    @Override 
    public float receber(){
        this.salario = 10000f;
        return salario;
    }
}
class PorComissao extends Empregado{
    private float comissao;
    private float totalDeVendas;
  
    public void validarComissao(){
        if(this.comissao >= 1) comissao = (float) Math.random();
    }

    public PorComissao(float comissao, float totalVendas) {
        this.comissao = comissao;
        this.totalDeVendas = totalVendas;
        this.salario = super.getSalario();
        validarComissao();
    }
    
    @Override
    public float receber(){
        return salario += (comissao * totalDeVendas);
    }

    public float getComissao() {
        return comissao;
    }

    public float getTotalDeVendas() {
        return totalDeVendas;
    }   
}

class PorItem extends Empregado{
    private float valorPorProducao;
    private int countProducao;

    public PorItem(float valorPorProducao, int countProducao) {
        this.valorPorProducao = valorPorProducao;
        this.countProducao = countProducao;
    }
    
    @Override
    public float receber(){
        return salario = valorPorProducao * countProducao;
    }

    public float getValorPorProducao() {
        return valorPorProducao;
    }

    public int getCountProducao() {
        return countProducao;
    }
}
class PorHora extends Empregado{
    private float valorPorHora;
    private int countHorasTrabalhadas;

    public PorHora(float valorPorHora, int countHorasTrabalhadas) {
        this.valorPorHora = valorPorHora;
        this.countHorasTrabalhadas = countHorasTrabalhadas;
    }
    @Override
    public float receber(){
        return salario = valorPorHora * countHorasTrabalhadas;
    }

    public float getValorPorHora() {
        return valorPorHora;
    }

    public int getCountHorasTrabalhadas() {
        return countHorasTrabalhadas;
    }
}
