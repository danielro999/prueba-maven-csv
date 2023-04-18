package pruebaMaven;
//import modelo.DatosPronostico;
import modelo.DatosResultado;
import modelo.Equipo;
import modelo.LectorArchivo;
import modelo.Partido;
//import modelo.Pronostico;

import java.sql.*;
import java.util.List;

import static conexion.ConectorSQL.*;

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
			sql = "SELECT nombre, id_equipo FROM prode.equipo inner join prode.pronostico";

			//En la variable resultado obtendremos las distintas filas que nos devolvió la base
			ResultSet resultado = consulta.executeQuery(sql);

			// Obtener las distintas filas de la consulta
			while (resultado.next()) {
				// Pbtener el valor de cada columna

				String Nombre = resultado.getString("nombre");
				String Id_Equipo1 = resultado.getString("id_equipo");

				// Mostrar los valores obtenidos

			//	System.out.println("nombre: " + Nombre + " " + Id_Equipo1);

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


