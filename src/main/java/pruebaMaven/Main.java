package pruebaMaven;
import modelo.LectorArchivo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectorArchivo lectorArchivos = new LectorArchivo("pronostico.csv");
		lectorArchivos.parsearArchivoPronostico();
		lectorArchivos.crearPronostico();
	}

}
