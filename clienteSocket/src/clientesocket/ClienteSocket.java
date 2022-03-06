package clientesocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class ClienteSocket {

    public static void main(String[] args) throws UnknownHostException, IOException{
        
        // estabelecer a conexão --> ip:porta
		Socket socket = new Socket("127.0.0.1", 59841);
		// enviar o nome -> fluxo de envio de dados
		DataOutputStream envio = new DataOutputStream(socket.getOutputStream());
		envio.writeUTF("Lucas");
		// receber a resposta -> fluxo de recebimento de dados
		DataInputStream recebimento = new DataInputStream(socket.getInputStream());
		String mensagem = recebimento.readUTF();

		System.out.println("Recebi: " + mensagem);
		// fechar a conexão
		recebimento.close();
		envio.close();
		socket.close();
    }
    
}
