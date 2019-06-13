package com.devswpro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Borrar {

	public static void main(String[] args) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File("D:\\ws_spring_19\\ClienteNotificacionGenericaMDB\\prueba.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
