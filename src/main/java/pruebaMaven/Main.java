package pruebaMaven;
import modelo.Equipo;
import modelo.LectorArchivo;
import modelo.Partido;
import modelo.Pronostico;

public class Main {

	public static void main(String[] args) {
	
		LectorArchivo lectorArchivos = new LectorArchivo("pronostico.csv","resultados.csv");
		
		Equipo equipo1 = new Equipo(
				lectorArchivos.listaResultado.get(0).getEquipo1Nombre(),
				lectorArchivos.listaResultado.get(0).getEquipo1Descpcion()
				);
		
		Equipo equipo2 = new Equipo(
				lectorArchivos.listaResultado.get(0).getEquipo2Nombre(),
				lectorArchivos.listaResultado.get(0).getEquipo2Descpcion()
				);
		
		Equipo equipo3 = new Equipo(
				lectorArchivos.listaResultado.get(1).getEquipo1Nombre(),
				lectorArchivos.listaResultado.get(1).getEquipo1Descpcion()
				);
		Equipo equipo4 = new Equipo(
				lectorArchivos.listaResultado.get(1).getEquipo2Nombre(),
				lectorArchivos.listaResultado.get(1).getEquipo2Descpcion()
				);
		
		Partido partido1 = new Partido(
				equipo1,
				equipo2,
				lectorArchivos.listaResultado.get(0).getEquipo1Goles(),
				lectorArchivos.listaResultado.get(0).getEquipo2Goles()
				);
		
		Partido partido2 = new Partido(
				equipo3,
				equipo4,
				lectorArchivos.listaResultado.get(1).getEquipo1Goles(),
				lectorArchivos.listaResultado.get(1).getEquipo2Goles()
				);
		
		Pronostico pronostico1 = new Pronostico(partido1, equipo1, lectorArchivos.listaPronostico.get(0));
		Pronostico pronostico2 = new Pronostico(partido2, equipo3, lectorArchivos.listaPronostico.get(1));

		
		System.out.println("pronostico argentina - arabia = " + pronostico1.puntos());
		System.out.println("pronostico mexico - polonia = " + pronostico2.puntos());
		System.out.println( lectorArchivos.listaPronostico.get(0).getGana1());
		System.out.println(pronostico1.getResultado());
		System.out.println(pronostico2.getResultado());
	}

}
