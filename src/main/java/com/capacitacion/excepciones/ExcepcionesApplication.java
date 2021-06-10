package com.capacitacion.excepciones;

import com.capacitacion.excepciones.personalizadas.ManejoPersonalizado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.capacitacion.excepciones.procesos.ProcesarDatos;

@SpringBootApplication
public class ExcepcionesApplication {

	static ProcesarDatos procesar = new ProcesarDatos();

	public static void main(String[] args) {
		SpringApplication.run(ExcepcionesApplication.class, args);
		
		caso1();
		caso2();
		caso3();
		caso4();
		caso5();

	}
	
	
	public static void caso1() {

		procesar.division("48", "0");
		procesar.division("15.8", "30");
		
	}
	public static void caso2() {
		String [] arrayPrueba = {"hola", "que mas", "bien"};

		procesar.arreglo(arrayPrueba);
	}
	
	public static void caso3() {

		System.out.println(procesar.fecha("2000/12/13"));

	}

	public static void caso4() {
		try {
			procesar.leerArchivo("src/main/resources/data.txt");
		} catch (ManejoPersonalizado manejoPersonalizado) {
			manejoPersonalizado.printStackTrace();
		}

	}
	
	public static void caso5() {
		try {
			procesar.leerYEscribirArchivo();
		} catch (ManejoPersonalizado manejoPersonalizado) {
			manejoPersonalizado.printStackTrace();
		}

	}
	

}
