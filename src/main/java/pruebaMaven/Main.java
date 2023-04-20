package pruebaMaven;
import LogicaCalculoFinal.Calculo;
import conexion.ConsultaSQL;
import modelo.*;

import java.util.List;



public class Main {

	public static void main(String[] args) {

		//parseo del archivo csv
		LectorArchivo lectorArchivos = new LectorArchivo("resultados.csv");
		ConsultaSQL consultaSQL = new ConsultaSQL();
		Calculo calculo = new Calculo();

		List<Partido> partidoList = lectorArchivos.crearListaResultadosPartidos();

		List<String[]> listaPronosticosString = consultaSQL.consulta();

		List<Pronostico> pronosticoList= calculo.crearPronosticosList(listaPronosticosString);

		calculo.puntosPorPartido(pronosticoList, partidoList);

		calculo.puntosTotales("mariana", 2);
		calculo.puntosTotales("pedro", 2);


	}
}


