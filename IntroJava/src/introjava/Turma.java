/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introjava;
/**
 *
 * @author MASTER
 */
// class Sala{
//    int numero;
//    Sala(int numero){ this.numero = numero;}
//    int getNumero(){return numero;}
//    }
public class Turma {
    private final String Nome;
    private final Disciplina disciplina;
   

    public Turma(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.Nome = this.disciplina.getNome();
//        this.Sala = sala;
    }

    public String getNome() {
        return Nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
