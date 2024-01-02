package org.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;

    private String name;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;

        try{
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    public void listenForMessage(){
        Thread thread = new Thread(() -> {
            while(socket.isConnected()){
                try{String message;
                    message = bufferedReader.readLine();
                    System.out.println(message);
                }
                catch(IOException e){
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        });
        thread.start();
    }

    public void sendMessage(){
        try {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String message = scanner.nextLine();
                bufferedWriter.write(name + ": " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }






}
