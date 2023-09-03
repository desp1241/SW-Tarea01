package com.example.demo.socket.archivos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private final Integer PORT = 13;
	private final String IP = "localhost";
	
	public Client() {
		
		try {
			Socket clientServer = new Socket(IP, PORT);
			System.out.println("--- 1) Iniciando comunicación ---");
			
			File fileOrigen = new File("D:/Cibertec/Ciclo6/Desarrollo de Servicios Web II/Semana02/cliente/Java-Espinoza.jpg");
			FileInputStream fis = new FileInputStream(fileOrigen);
			DataOutputStream salida = new DataOutputStream(clientServer.getOutputStream());
			
			int byteLedios;
			while( (byteLedios = fis.read()) != -1) {
				salida.write(byteLedios);
			}
			
			System.out.println("--- 2) Finalizando comunicación ---");
			clientServer.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Client();
	}

}
