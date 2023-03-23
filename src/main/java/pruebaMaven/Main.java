package pruebaMaven;

import java.util.Iterator;

import modelo.ArchivoPronostico;
import modelo.LectorArchivo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectorArchivo lectorArchivos = new LectorArchivo("pronostico.csv");
		lectorArchivos.parsearArchivo();
		lectorArchivos.listarPronosticos();
	}

}
