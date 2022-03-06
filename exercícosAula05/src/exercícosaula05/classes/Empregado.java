
package exercícosaula05.classes;

/*@author MASTER*/
public class Empregado {
    
    private int matricula;
    private String nome;

    public Empregado(String nome) {
        this.matricula = (int) (Math.random() * 100);
        this.nome = nome;
    }

    public Empregado() {
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Empregado{ " + "matricula = " + matricula + ", nome = " + nome + '}';
    }
    
    
    
    
    
}
