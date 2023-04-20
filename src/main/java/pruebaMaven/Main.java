package pruebaMaven;
import LogicaCalculoFinal.Calculo;
import com.fasterxml.jackson.core.JsonProcessingException;
import conexion.ConsultaSQL;
import modelo.*;
import serealizacion.ConfigConexionDB;
import serealizacion.ConfigPuntos;
import serealizacion.ParseoJson;

import java.util.List;


public class Main {

	public static void main(String[] args) throws JsonProcessingException {

		//parseo del archivo csv
		LectorArchivo lectorArchivos = new LectorArchivo("resultados.csv");

		ConsultaSQL consultaSQL = new ConsultaSQL();

		Calculo calculo = new Calculo();

		List<Partido> partidoList = lectorArchivos.crearListaResultadosPartidos();

		List<String[]> listaPronosticosString = consultaSQL.consulta();

		List<Pronostico> pronosticoList= LectorArchivo.crearPronosticosList(listaPronosticosString);
//
//		List<Participante> participanteList = calculo.instancidorParticipantes(listaPronosticosString);
//
//		calculo.puntosPorPartido(pronosticoList, partidoList);
//
//		calculo.agregarPuntosParticipante(participanteList,pronosticoList);
//
//		calculo.puntosFinalParticipantes(participanteList);
//
		String jsonString = "{\n" +
				"    \"puntosPartido\": 1,\n" +
				"    \"puntosRonda\" : 1,\n" +
				"    \"puntosfase\" : 1\n" +
				"}";
		ParseoJson parseoJson = new ParseoJson();
		ConfigPuntos configPuntos = parseoJson.crearConfigDBJson(jsonString);



	}
}


