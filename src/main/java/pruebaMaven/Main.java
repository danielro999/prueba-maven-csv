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
//		instancia parseo archivos json configuracion
		ParseoJson parseoJson = new ParseoJson();
//		configuracion puntos
		ConfigPuntos configPuntos = parseoJson.configPuntajesJson("configPuntos.json");
//		configuracion base de datos
		ConfigConexionDB configConexionDB = parseoJson.configConexionDBJson("configConexionDBJson.json");

		//parseo del archivo csv
		LectorArchivo lectorArchivos = new LectorArchivo("resultados.csv");

		ConsultaSQL consultaSQL = new ConsultaSQL();

		Calculo calculo = new Calculo();

		List<Partido> partidoList = lectorArchivos.crearListaResultadosPartidos();

		List<String[]> listaPronosticosString = consultaSQL.consulta(configConexionDB);

		List<Pronostico> pronosticoList= LectorArchivo.crearPronosticosList(listaPronosticosString);

		List<Participante> participanteList = calculo.instancidorParticipantes(listaPronosticosString, configPuntos);

		calculo.puntosPorPartido(pronosticoList, partidoList);

		calculo.agregarPronosticosParticipante(participanteList,pronosticoList);

		calculo.puntosFinalParticipantes(participanteList);


	}
}





