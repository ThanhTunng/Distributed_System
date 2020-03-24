package com.hust.soict.VuThanhTung.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.hust.soict.VuThanhTung.helper.*;
import java.util.Arrays;

public class Server {
	public static void main(String[] args) {
		System.out.println("The sorter Server is running!");
		int clientNumber = 0;
		try (ServerSocket listener = new ServerSocket(9898)){
			while(true) {
				new Sorter(listener.accept(), clientNumber++).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static class Sorter extends Thread{
		private Socket socket;
		private int clientNumber;
		
		public Sorter(Socket socket,int clientNumber) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
			this.clientNumber = clientNumber;
			System.out.println("New client #"+ clientNumber+ " connected at "+socket);
		}
	
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
				
				//Send a welcome message to client
				out.println("Hello, you are client #"+ clientNumber);
				
				//Get messages from the client,line by line; each line has several numbers separated by a space character
				while(true) {
					String input = in.readLine();
					if(input == null || input.isEmpty())
						break;
					//Put it in a string array
					String nums[] = input.split(" ");
					
					//Convert this string array to int array
					int intArr[] = new int[nums.length];
					int i = 0;
					for(String textValue: nums) {
						intArr[i] = Integer.parseInt(textValue);
						i++;
					}
					
					//Sort the numbers in this int array
					new ShellSort().sort(intArr);
					
					//Convert the int array to string
					String strArr[] = Arrays.stream(intArr)
											.mapToObj(String::valueOf)
											.toArray(String[]::new);
					
					//Send the result to client
					out.println(Arrays.deepToString(strArr));	
				}
				
			}catch (IOException e) {
				// TODO: handle exception
				System.out.println("Error handling client #" + clientNumber);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO: handle exception
					System.out.println("Connection with client #" + clientNumber +"closed");
				}
			}
		}
		
		
	}
}
