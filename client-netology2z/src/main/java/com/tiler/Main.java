package com.tiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 80;

        try(Socket clientSocket = new Socket(host,port);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
            out.println("Harlly");
            String resp = in.readLine();
            System.out.println(resp);
            out.println("1. Hey server! Do you have coffee?:)))");
            String Mess1 = in.readLine();
            System.out.println(Mess1);
            out.println("2. It’s a pity, but maybe you have some tea?");
            String Mess2 = in.readLine();
            System.out.println(Mess2);
            out.println("3. Great, then I'll have a Fresh Bar, please!");
            String Mess3 = in.readLine();
            System.out.println(Mess3);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}