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
public class Aluno {
    private String nome;
    private Curso curso;
    private Turma turma;
    private List<Disciplina> disciplinasMatriculadas = new ArrayList<>();
    
    public Aluno(String nome, Curso curso, Turma turma, List<Disciplina> disciplinasMatriculadas){
        this.nome = nome;
        this.curso = curso;
        this.turma = turma;
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }
    @Override
    public String toString(){
        return "Aluno{ nome = " + nome + ", curso = " + curso + ", turma = " +
                turma + ", disciplinas matriculadas = " + disciplinasMatriculadas + "}";
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public Turma getTurma() {
        return turma;
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setDisciplinasMatriculadas(List<Disciplina> disciplinasMatriculadas) {
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }
    
}
