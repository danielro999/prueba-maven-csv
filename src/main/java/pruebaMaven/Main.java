package pruebaMaven;
import LogicaCalculoFinal.Calculo;
import conexion.ConsultaSQL;
import modelo.*;

import java.util.List;
import java.util.Set;


public class Main {

	public static void main(String[] args) {

		//parseo del archivo csv
		LectorArchivo lectorArchivos = new LectorArchivo("resultados.csv");
		ConsultaSQL consultaSQL = new ConsultaSQL();
		Calculo calculo = new Calculo();

		List<Partido> partidoList = lectorArchivos.crearListaResultadosPartidos();

		List<String[]> listaPronosticosString = consultaSQL.consulta();

		List<Pronostico> pronosticoList= LectorArchivo.crearPronosticosList(listaPronosticosString);

		List<Participante> participanteList = calculo.instancidorParticipante(listaPronosticosString);

		calculo.puntosPorPartido(pronosticoList, partidoList);

		calculo.agregarPuntosParticipante(participanteList,pronosticoList);

		calculo.puntosFinalParticipantes(participanteList);





	}
}


