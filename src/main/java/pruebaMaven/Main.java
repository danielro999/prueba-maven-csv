package pruebaMaven;
import modelo.DatosPronostico;
import modelo.DatosResultado;
import modelo.Equipo;
import modelo.LectorArchivo;
import modelo.Partido;
import modelo.Pronostico;

public class Main {

	public static void main(String[] args) {
	
		LectorArchivo lectorArchivos = new LectorArchivo("pronostico.csv","resultados.csv");
		DatosResultado argentinaArabia = lectorArchivos.listaResultado.get(0);
		DatosResultado mexicoPolinia = lectorArchivos.listaResultado.get(1);
		DatosPronostico pronosArgArab = lectorArchivos.listaPronostico.get(0);
		DatosPronostico pronosMexPol = lectorArchivos.listaPronostico.get(1);
		
		Equipo equipo1 = new Equipo(
				argentinaArabia.getEquipo1Nombre(),
				argentinaArabia.getEquipo1Descpcion()
				);
		
		Equipo equipo2 = new Equipo(
				argentinaArabia.getEquipo2Nombre(),
				argentinaArabia.getEquipo2Descpcion()
				);
		
		Equipo equipo3 = new Equipo(
				mexicoPolinia.getEquipo1Nombre(),
				mexicoPolinia.getEquipo1Descpcion()
				);
		Equipo equipo4 = new Equipo(
				mexicoPolinia.getEquipo2Nombre(),
				mexicoPolinia.getEquipo2Descpcion()
				);
		
		Partido partido1 = new Partido(
				equipo1,
				equipo2,
				argentinaArabia.getEquipo1Goles(),
				argentinaArabia.getEquipo2Goles()
				);
		
		Partido partido2 = new Partido(
				equipo3,
				equipo4,
				mexicoPolinia.getEquipo1Goles(),
				mexicoPolinia.getEquipo2Goles()
				);
		
		Pronostico pronostico1 = new Pronostico(partido1, equipo1, pronosArgArab);
		Pronostico pronostico2 = new Pronostico(partido2, equipo3, pronosMexPol);

		
		System.out.println("pronostico argentina - arabia = " + pronostico1.puntos());
		System.out.println("pronostico mexico - polonia = " + pronostico2.puntos());
		System.out.println( lectorArchivos.listaPronostico.get(0).getGana1());
		System.out.println(pronostico1.getResultado());
		System.out.println(pronostico2.getResultado());
	}

}
