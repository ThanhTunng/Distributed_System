package com.hust.soict.VuThanhTung.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		try {
			Socket socket = new Socket("127.0.0.1", 9898);
			// Create 2 instances of two classes for sending and receiving data
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			// Init an instance of Scanner class
			System.out.println(in.readLine());
			Scanner scanner = new Scanner(System.in);
			
			// Get number from user and send to server, until user types empty
			String input;
			while(( input = stdIn.readLine()) == null) {
				out.println(input);
				//read a line from bufferedReader connected to socket
				System.out.println("echo: "+ in.readLine());
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
