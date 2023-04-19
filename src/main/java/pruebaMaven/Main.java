package pruebaMaven;
import conexion.ConsultaSQL;
import modelo.DatosResultado;
import modelo.Equipo;
import modelo.LectorArchivo;
import modelo.Partido;

import javax.swing.*;
import java.util.List;



public class Main {

	public static void main(String[] args) {

		LectorArchivo lectorArchivos = new LectorArchivo("resultados.csv");		//LectorArchivo lectorArchivos = new LectorArchivo("pronostico.csv","resultados.csv");
		//toma los dos archivos csv y los parcea a colecciones del tipo datosPronostico (listaPronostico) y datosResultados(listaResultado)

		DatosResultado argentinaArabia = lectorArchivos.listaResultado.get(0);
		//obtengo de la coleccion listaResultado el primer elemento que contiene los resultados del primer partido

		DatosResultado mexicoPolinia = lectorArchivos.listaResultado.get(1);

		DatosResultado argentinaMexico = lectorArchivos.listaResultado.get(2);
		DatosResultado ArabiaPolonia = lectorArchivos.listaResultado.get(3);
		//System.out.println(argentinaMexico.getRonda_id());

		List<Partido>  resultados = lectorArchivos.crearListaResultadosPartidos();
		ConsultaSQL consultaSQL = new ConsultaSQL();
		consultaSQL.consulta();
	}
}


