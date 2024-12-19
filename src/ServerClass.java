import java.io.IOException;
import java.net.*;

public class ServerClass {
    public void receivAndSentMensageServerSide() throws IOException {
        // como estava antes
//        DatagramSocket clientSocket = new DatagramSocket(6624);
//        byte[] reciveBuffer = new byte[1024];
//        while (true){
//        DatagramPacket receivedPacket = new DatagramPacket(reciveBuffer,reciveBuffer.length);
//
//        clientSocket.receive(receivedPacket);
//
        try {
            DatagramSocket serverSocket = new DatagramSocket(6624);
            //nao preciso mas pode ajudar
            System.out.println("server ligado");
            // buffer que vou receber
            byte[] receivedBuffer = new byte[1024];
            // fiz o pacote
            DatagramPacket receivePacket = new DatagramPacket(receivedBuffer, receivedBuffer.length);
            // vou receber o pacote
            serverSocket.receive(receivePacket);
            // converti o pacote recebido em string para poder ler
            String messageReceived = new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println(messageReceived);
            // fechei o pacote
            serverSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }



    }
}