import java.io.IOException;
import java.net.*;

public class ServerClass {
    public void receivAndSentMensageServerSide() throws IOException {
        try {
            //abri um socket
            DatagramSocket serverSocket = new DatagramSocket(9987);

            System.out.println("server ligado");
            // buffer que vou receber
            byte[] receivedBuffer = new byte[1024];
            // fiz o pacote
            DatagramPacket receivePacket = new DatagramPacket(receivedBuffer, receivedBuffer.length);
            // vou receber o pacote

            while (true) {
                serverSocket.receive(receivePacket);
                // converti o pacote recebido em string para poder ler
                String messageReceived = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(messageReceived);
                break;
            }
            //agora vou mandar uma resposta para o cliente
            String sendSessage = "Mensagem recebida, tenha um otimo dia";
            //converti de string para bytes
            byte[] sendbuffer = sendSessage.getBytes();
            //consegui as informações de quem me mandou mensagem
            InetAddress clientAddress = receivePacket.getAddress();
            int getPort = receivePacket.getPort();
            //fiz o pacote
            DatagramPacket sendPacket = new DatagramPacket(
                    sendbuffer,
                    sendbuffer.length,
                    clientAddress,getPort);
            //vou enviar e receber o pacote
            serverSocket.send(sendPacket);
            serverSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}