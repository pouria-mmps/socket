package ir.javacup;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String next;
            do {
                next = dis.readUTF();
                System.out.println("receive message: " + next);
            } while (!next.equals("finish"));
        }
    }
}
