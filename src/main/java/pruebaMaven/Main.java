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
//toma los dos archivos csv y los parcea a colecciones del tipo datosPronostico (listaPronostico) y datosResultados(listaResultado)
		DatosResultado argentinaArabia = lectorArchivos.listaResultado.get(0);
//obtengo de la coleccion listaResultado el primer elemento que contiene los resultados del primer partido
		DatosResultado mexicoPolinia = lectorArchivos.listaResultado.get(1);
//resultados del segundo partido
		DatosPronostico pronosArgArab = lectorArchivos.listaPronostico.get(0);
//obtengo de la coleccion lista pronostico el primer elemento que contiene los pronosticos del primer partido
		DatosPronostico pronosMexPol = lectorArchivos.listaPronostico.get(1);
//pronosticos del segundo partido
		
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

		
		System.out.println("puntos por pronostico argentina - arabia = " + pronostico1.puntos());
		System.out.println("puntos por pronostico mexico - polonia = " + pronostico2.puntos());
	
		System.out.println(pronostico1.getResultado());
		System.out.println(pronostico2.getResultado());
	}

}
