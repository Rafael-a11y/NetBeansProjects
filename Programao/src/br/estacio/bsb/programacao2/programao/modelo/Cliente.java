package br.estacio.bsb.programacao2.programao.modelo;


/*
Camada de Modelo (o "M" do MVC)

Nesta camada são definidas e tratadas as regras de negócio e os objetos que 
compõem o sistema.

Neste exemplo, dividimos a camada de modelo em duas:
- entidade: esta classe que define a "cara" do dado que manipulamos;
- DAO: classe para fazer as operações de persistêcia com o banco de dados.

// é a entidade que representa o negócio
*/
public class Cliente {

    private Integer id;
    private String nome;
    private String telefone;

    public Cliente() {
    }

    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getTelefone() {
            return telefone;
    }

    public void setTelefone(String telefone) {
            this.telefone = telefone;
    }

}
