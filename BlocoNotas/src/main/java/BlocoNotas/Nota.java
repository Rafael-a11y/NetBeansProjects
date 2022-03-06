package BlocoNotas;

public class Nota {
    String texto;
    String tipo;
    private int novaNota;
    
    public Nota(){
    }
    
    public Nota(String texto, String tipo) {
        this.texto = texto;
        this.tipo = tipo;
    }
    
    Nota(String novaNota) {
        throw new UnsupportedOperationException("Exibir a Nota:");
    }
    
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
   }
    
   public String getTipo() {
        return tipo;
  }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNovaNota() {
        return novaNota;
    }

    public void setNovaNota(int novaNota) {
        this.novaNota = novaNota;
    }

    
    
}
