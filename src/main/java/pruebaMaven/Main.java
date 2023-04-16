package pruebaMaven;
import modelo.DatosPronostico;
import modelo.DatosResultado;
import modelo.Equipo;
import modelo.LectorArchivo;
import modelo.Partido;
import modelo.Pronostico;

import java.sql.*;

import static coneccion.ConectorSQL.*;

public class Main {

	public static void main(String[] args) {
	
		LectorArchivo lectorArchivos = new LectorArchivo("pronostico.csv","resultados.csv");
//toma los dos archivos csv y los parcea a colecciones del tipo datosPronostico (listaPronostico) y datosResultados(listaResultado)
		DatosResultado argentinaArabia = lectorArchivos.listaResultado.get(0);
//obtengo de la coleccion listaResultado el primer elemento que contiene los resultados del primer partido
		DatosResultado mexicoPolinia = lectorArchivos.listaResultado.get(1);

		DatosResultado argentinaMexico = lectorArchivos.listaResultado.get(2);
		DatosResultado ArabiaPolonia = lectorArchivos.listaResultado.get(3);

//resultados del segundo partido
//		DatosPronostico pronosArgArab = lectorArchivos.listaPronostico.get(0);
////obtengo de la coleccion lista pronostico el primer elemento que contiene los pronosticos del primer partido
//		DatosPronostico pronosMexPol = lectorArchivos.listaPronostico.get(1);
////pronosticos del segundo partido
		
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
		
//		Pronostico pronostico1 = new Pronostico(partido1, equipo1, pronosArgArab);
//		Pronostico pronostico2 = new Pronostico(partido2, equipo3, pronosMexPol);

		System.out.println(argentinaMexico.getRonda_id());
//


		Connection conexion = null;
		Statement consulta = null;

		try {

			// Abrir la conexión
			System.out.println("conectando a la base de datos...");

			conexion = DriverManager.getConnection(DB_URL, USER, PASS);

			// Ejecutar una consulta
			System.out.println("Creating statement...");
			consulta = conexion.createStatement();
			String sql;
			sql = "SELECT nombre FROM prode.equipo";

			//En la variable resultado obtendremos las distintas filas que nos devolvió la base
			ResultSet resultado = consulta.executeQuery(sql);

			// Obtener las distintas filas de la consulta
			while (resultado.next()) {
				// Pbtener el valor de cada columna

				String Nombre = resultado.getString("nombre");


				// Mostrar los valores obtenidos

				System.out.println("nombre: " + Nombre);

			}
			// Esto se utiliza par cerrar la conexión con la base de datos
			resultado.close();
			consulta.close();
			conexion.close();
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
			se.printStackTrace();
		} finally {
			// Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
			try {
				if (consulta != null)
					consulta.close();
			} catch (SQLException se2) {

			}
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Fin de la ejecucción");
	}
}


