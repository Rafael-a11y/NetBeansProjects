/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MASTER
 */
public class Agente extends Pessoa{
    
    private List<Cidadao> cidadaos = Arrays.asList(new Cidadao(Cidadao.Pergunta.SIM_POSITIVO, Cidadao.Sexo.MASCULINO, Cidadao.RA.BRASILIA, "Rafael", 76.05f, 21, 1.70f, "20/06/19"),
            new Cidadao(Cidadao.Pergunta.SIM_NEGATIVO, Cidadao.Sexo.FEMININO, Cidadao.RA.MATO_GROSSO, "Tirza", 80.05f, 26, 1.60f, "10/12/19"),
            new Cidadao(Cidadao.Pergunta.NAO, Cidadao.Sexo.MASCULINO, Cidadao.RA.MINAS_GERAIS, "Israel", 73.05f, 21, 1.75f, "20/06/19"),
            new Cidadao(Cidadao.Pergunta.SIM_POSITIVO, Cidadao.Sexo.FEMININO, Cidadao.RA.PORTO_SEGURO, "Larissa", 50.05f, 24, 1.65f, "20/06/19"),
            new Cidadao(Cidadao.Pergunta.NAO, Cidadao.Sexo.MASCULINO, Cidadao.RA.BRASILIA, "Bruno", 85.05f, 236, 1.70f, "06/04/19"),
            new Cidadao(Cidadao.Pergunta.SIM_NEGATIVO, Cidadao.Sexo.FEMININO, Cidadao.RA.MATO_GROSSO, "Zaira", 60.05f, 40, 1.60f, "20/06/19"),
            new Cidadao(Cidadao.Pergunta.SIM_NEGATIVO, Cidadao.Sexo.MASCULINO, Cidadao.RA.MINAS_GERAIS, "Thiago", 80.05f, 24, 1.75f, "20/06/19"));
    private List<Cidadao> formulario = new ArrayList<>();
    
    public void cadastrarCidadao(Cidadao cidadao){
        this.formulario.addAll(cidadaos);
    }
    public void exibirRelatorio(){
       JOptionPane.showMessageDialog(null, "Quantidade de cidadaos que tomaramk segundaa dose " + qtdeCidadaosQueTomaramSegundaDose());
       JOptionPane.showMessageDialog(null, "Quantidade de pessoas do sexo feminino que deram positivo antes da segunda dose " + qtdeFemininoEPositivoAntesSegundaDose());
       JOptionPane.showMessageDialog(null, "Média da idade dos cidadaos " + MediaIdadeCidadaos());
    }
    public long qtdeCidadaosQueTomaramSegundaDose(){
        long qtde = cidadaos.stream().count();
        return qtde;
    }
    
    public long qtdeFemininoEPositivoAntesSegundaDose(){
        return cidadaos.stream().filter(c -> c.getSexo() == Cidadao.Sexo.FEMININO && c.getPergunta() == Cidadao.Pergunta.SIM_POSITIVO).count();
    }
    
    public int MediaIdadeCidadaos(){
        int qtd = cidadaos.size();
        int count = 0;
        for(Cidadao cidadao : cidadaos){
            count += cidadao.getIdade();
        }
        return count / qtd;
    }
    
    public Long RAComMaiorQuantidadeDeCovid(){
        long qtdCasosBrasilia = cidadaos.stream().filter(e -> e.getRa() == Cidadao.RA.BRASILIA && e.getPergunta() == Cidadao.Pergunta.SIM_POSITIVO ).count();
        long qtdCasosMatoGrosso = cidadaos.stream().filter(e -> e.getRa() == Cidadao.RA.MATO_GROSSO && e.getPergunta() == Cidadao.Pergunta.SIM_POSITIVO ).count();
        long qtdMinasGerais = cidadaos.stream().filter(e -> e.getRa() == Cidadao.RA.MINAS_GERAIS && e.getPergunta() == Cidadao.Pergunta.SIM_POSITIVO ).count();
        long qtdCasosPortoSeguro = cidadaos.stream().filter(e -> e.getRa() == Cidadao.RA.PORTO_SEGURO && e.getPergunta() == Cidadao.Pergunta.SIM_POSITIVO ).count();
        List<Long> numeros = Arrays.asList(qtdCasosBrasilia, qtdCasosMatoGrosso, qtdMinasGerais, qtdCasosPortoSeguro);
        Long maior = 0L;
        for(Long n : numeros){
            if(maior > n) maior+= n;
        }
        return maior;
    }
}
