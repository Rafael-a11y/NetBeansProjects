package excecaocustomizada;

import excecaocustomizada.model.Conta;
import excecaocustomizada.model.ContaExcecao;
import excecaocustomizada.model.DepositoException;

public class ExcecaoCustomizada {

    private static void testandoExceptions(Conta conta, Conta conta2){
        
         try{
            conta.sacar(600);
        }
        catch(ContaExcecao e){
            e.printStackTrace();
        }
        try{
            conta2.depositar(400);
        }
        catch(DepositoException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ContaExcecao {
        Conta conta = new Conta("Rafael", "06763614128", "449-90", 500, 1000);
        Conta conta2 = new Conta("Israel", "06763614129", "449-91", 800, 1000);
        testandoExceptions(conta, conta2);
    }
    
}
