package hortifrutcombd.modelo;

/*@author MASTER*/
public class Fruta {
    private Integer id = 0;
    private String descricao;
	private int quantidade;
	public Fruta(){}
        public Fruta(String nome, int quantidade){
            this.descricao = nome;
            this.quantidade = quantidade;
        }
        public Fruta(int id){
            this.id = id;
        }
        public Fruta(int id, String nome){
            this.id = id;
            this.descricao = nome;
        }
        public Fruta(int id, String nome, int quantidade){
            this.id = id;
            this.descricao = nome;
            this.quantidade = quantidade;
        }
         public int getId(){
            return this.id;
        }
	public String getDescricao() {
		return descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
        public void setId(int id){
            this.id = id;
        }
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

    @Override
    public String toString() {
        return "Fruta{" + "id = " + id + ", nome = " + descricao + ", quantidade = " + quantidade + '}';
    }
}
