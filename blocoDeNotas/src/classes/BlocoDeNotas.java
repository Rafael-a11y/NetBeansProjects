
package classes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BlocoDeNotas {
    private static List<Nota> bloco = new LinkedList<>();
    private static int contador = 0;
    public static List<Nota> getBloco(){
        return bloco;
    }
    public static int getContador(){
        return BlocoDeNotas.contador = contador + 1;
    }
    
}
