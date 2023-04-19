package pruebaMaven;
import conexion.ConsultaSQL;
import modelo.*;

import javax.swing.*;
import java.util.List;



public class Main {

	public static void main(String[] args) {

		//parseo del archivo csv
		LectorArchivo lectorArchivos = new LectorArchivo("resultados.csv");

		// lista con los partidos(de resultados.csv paserado)
		List<Partido> listaResulPartidos = lectorArchivos.crearListaResultadosPartidos();

		ConsultaSQL consultaSQL = new ConsultaSQL();

		//System.out.println(resultados.get(0).getEquipo2().getNombre());

		List<String[]> listaPronosticos = consultaSQL.consulta();


		for (String[] pronostico : listaPronosticos) {
			//pronostico = {fase, nro_ronda, nombre, id_Equipo1, resultado, id_Equipo2 }
// System.out.println(pronostico[4]);

			Participante participante = new Participante(pronostico[2]);

			Equipo equipo1 = null;
			Equipo equipo2 = null;

			for (Partido partido : listaResulPartidos) {
				if (partido.getEquipo1().getNombre().equals(pronostico[3]) && partido.getEquipo2().getNombre().equals(pronostico[5])) {
					equipo1 = partido.getEquipo1();
					//System.out.println("equipo1 "+equipo1.getNombre());

					equipo2 = partido.getEquipo2();
				//	System.out.println("equipo2 "+equipo2.getNombre());

				}
			}
			//System.out.println(listaResulPartidos.size());
			Pronostico pronosticoParticipante = new Pronostico(pronostico[1], participante, equipo1, pronostico[4], equipo2);


//			System.out.println(pronosticoParticipante.getParticipante().getNombre()+" "+ " " + pronosticoParticipante.getResultado());
			for (Partido partido : listaResulPartidos) {
				String partidoEq1 =partido.getEquipo1().getNombre();
				String partidoEq2 =partido.getEquipo2().getNombre();
				String partidoPronosticoEq1 = pronosticoParticipante.getEquipo1().getNombre();
				String partidoPronosticoEq2 = pronosticoParticipante.getEquipo2().getNombre();
				String partici = pronosticoParticipante.getParticipante().getNombre();
				if (partidoEq1.equals(partidoPronosticoEq1) && partidoEq2.equals(partidoPronosticoEq2))
				{
					pronosticoParticipante.setPartido(partido);

					System.out.println("Pronostico " + partici +" => " + partidoEq1 + " equipo1 " + pronosticoParticipante.getResultado()+ " vs " + partidoPronosticoEq2);
					System.out.println( "resultado real => " + partido.resultadoEquipo1());
					System.out.println("puntos => " + pronosticoParticipante.puntos()+ "\n");
				}
			}
		}
	}
}


