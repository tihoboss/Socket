package com.tiler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 80;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // wait for connection
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    System.out.printf("Connected\n");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    String clientMess = in.readLine();
                    System.out.println(clientMess);
                    out.println("1. Hello! Unfortunately, coffee is not included in our digital menu.(((");
                    String clientMess2 = in.readLine();
                    System.out.println(clientMess2);
                    out.println("2. No, but we can offer you hot Fresh Bar!");
                    String clientMess3 = in.readLine();
                    System.out.println(clientMess3);
                    out.println("3. Okey))");
                }
            }
        }
    }
}
