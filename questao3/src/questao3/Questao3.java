
package questao3;

//@author Rafael Souto da Silva

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Questao3 {

   
    public static void main(String[] args) {
        
        List<String> nomes = new ArrayList<>();
        nomes.add("Rafael");
        nomes.add("Zaira");
        nomes.add("Petra");
        nomes.add("Boanerges");
        System.out.println(nomes);
        Collections.sort(nomes);
        System.out.println(nomes);
        Collections.reverse(nomes);
        System.out.println(nomes);
        Collections.reverseOrder((new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {return o1.compareTo(o2)
                    ;}}),nomes);
        System.out.println(nomes);
    }
    private static boolean criaArquivoLog1(String nomeArquivo) throws IOException{
        File file = new File(nomeArquivo);
        return file.createNewFile();
    }
    
    private static boolean criaArquivoLog2(String nomeArquivo) {
        File file = new File(nomeArquivo);
        try {
            return file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
