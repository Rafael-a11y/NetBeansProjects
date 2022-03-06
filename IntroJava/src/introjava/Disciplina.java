/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introjava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MASTER
 */
public class Disciplina {
    private String nome;
    private List<Aluno>  alunosMatriculados = new ArrayList<Aluno>();

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
    
}
