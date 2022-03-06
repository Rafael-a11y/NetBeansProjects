package exercícosaula05.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*@author MASTER*/
public class ExercícosAula05 {
    public static void main(String[] args) {
        int multiplo3 = 0;
        int it = 0;
        for(int i = 0; i < 303; i++){
            multiplo3++;
            if(multiplo3 % 3 == 0) {
                System.out.println("número " + it++ + "  " + multiplo3);
            }
            
        }
        System.out.println("------------------------------------------------------");
        int[] array = {12,11,10,9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("------------------------------------------------------");
        List<Double> notas = Arrays.asList(10.0, 7.7, 4.5, 5.6, 9.0, 3.2, 1.5, 8.9, 10.0, 10.0);
        //mapToDouble transforma todos os elementos em double, o que gera uma DoubleStream, uma stream de tipos
        //primitivos, a interface DoubleStreaam tem o método average que retorna um OptionalDouble que posui o valor
        //da média artimética
        System.out.println("Média total dos alunos: " + notas.stream().mapToDouble(Double :: doubleValue).average().getAsDouble());
        List<String> nomes = new ArrayList<>();
        nomes.add("Rafael");
        nomes.add("Israel");
        nomes.add("Tirza");
        nomes.forEach(System.out::println);
        System.out.println("Depois de remover");
        String nome;
        nome = nomes.remove(1);
        nomes.forEach(System.out::println);
    }
    
}
