package servidorsocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(59841);
		System.out.println("A porta 59841 foi aberta");
		System.out.println("Esperando clientes na porta 59841...");
		
		// estabelecer a conexão --> ip:porta
		Socket socket = serverSocket.accept();
		System.out.println("Cliente " + 
				socket.getInetAddress().getHostAddress() + 
				" conectado");
		
		// receber o nome -> fluxo de recebimento de dados
		ObjectInputStream recebimento = new ObjectInputStream(socket.getInputStream());
		Carro carrinho = (Carro) recebimento.readObject();
                System.out.println(carrinho);
		

		System.out.println("Fechando conexão e porta");
		// fechar a conexão
		recebimento.close();
		socket.close();
		serverSocket.close();
	}
    
}
