package com.capacitacion.excepciones.procesos;

import com.capacitacion.excepciones.personalizadas.ManejoPersonalizado;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProcesarDatos {
	
	public int division(String numero1,String numero2) {
		int resultado = 0;
		try {
			resultado=Integer.valueOf(numero1)/Integer.valueOf(numero2);

		} catch (ArithmeticException e) {
			System.out.println("Mensaje: "+e.getMessage()+ "\n Trace:" + e.getStackTrace()+ "\n Causa: " +e.getCause());
		} catch (NumberFormatException r) {
			System.out.println("Mensaje: "+r.getMessage()+ "\n Trace:" + r.getStackTrace()+ "\n Causa: " +r.getCause());
		}


		return resultado;
		
	}
	
	
	public void arreglo(String[] lista) {

		try {

			for(int i=0;i<=5;i++) {
				System.out.println(lista[i]);
			}

		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println(("Mensaje: "+e.getMessage()+ "\n Trace:" + e.getStackTrace()+ "\n Causa: " +e.getCause()));
		}

	}
	
	public String fecha(String input) {
		String error= "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date   date  = format.parse (input );
			date.toString();
		} catch (ParseException e) {
			 error= ("Mensaje: "+e.getMessage()+ "\n Trace:" + e.getStackTrace()+ "\n Causa: " +e.getCause());
		}

		return error;
	}

	public void leerArchivo(String ruta) throws ManejoPersonalizado{

		try{
			Scanner data = new Scanner(new File(ruta));
		}catch (FileNotFoundException e){
			throw new ManejoPersonalizado(e.getMessage(), e.getCause());
		}

	}

	public void leerYEscribirArchivo()throws ManejoPersonalizado{
		Scanner dataLectura = null;
		FileWriter archivoEscritura = null;
		PrintWriter pw = null;

		try {
			dataLectura = new Scanner(new File("src/main/java/com/capacitacion/excepciones/datos/data.txt"));
			archivoEscritura = new FileWriter("src/main/java/com/capacitacion/excepciones/datos/data2.txt");
			pw = new PrintWriter(archivoEscritura);

			while (dataLectura.hasNextLine()) {
				String[] estData = dataLectura.nextLine().split(";");
				pw.println(estData[0]+";"+estData[2]);
			}
		} catch (FileNotFoundException e) {
			throw new ManejoPersonalizado(e.getMessage(), e.getCause());
		} catch (ArrayIndexOutOfBoundsException a){
			a.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dataLectura.close();
		try {
			archivoEscritura.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}
	

}
