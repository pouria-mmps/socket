package ir.javacup;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("localhost", 8080)) {
            DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.next();
                dout.writeUTF(message);
                System.out.println("Sending meesage : " + message);
                dout.flush();
            }
        }
    }
}
