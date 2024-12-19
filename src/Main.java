import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerClass serverClass = new ServerClass();
        serverClass.receivAndSentMensageServerSide();
    }
}