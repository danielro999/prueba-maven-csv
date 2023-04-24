package conexion;
import serealizacion.ConfigConexionDB;
import serealizacion.ParseoJson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static conexion.ConectorSQL.*;

public class ConsultaSQL {
    private List<String[]> listaPronostico;

    public List<String[]> consulta (ConfigConexionDB configConexionDB){
        Connection conexion = null;
        Statement consulta = null;
        this.listaPronostico = new ArrayList<>();
        try {

            // Abrir la conexión
            System.out.println("conectando a la base de datos...");

            conexion = DriverManager.getConnection(configConexionDB.getDB_URL(), configConexionDB.getUSER(), configConexionDB.getPASS());

            // Ejecutar una consulta
            System.out.println("Creating statement...");
            consulta = conexion.createStatement();
            String sql;
            sql = "SELECT (SELECT ronda.nombre_fase FROM ronda WHERE pronostico.nro_ronda = ronda.nro_ronda) AS fase," +
                    "pronostico.nro_ronda, participante.nombre, equipo.nombre AS nombreEq1, pronostico.resultado, " +
                    "(SELECT equipo.nombre FROM equipo WHERE pronostico.id_equipo2 = equipo.id_equipo) AS nombreEq2 " +
                    "FROM participante inner join equipo inner JOIN pronostico " +
                    "ON participante.id_participante = pronostico.id_participante AND equipo.id_equipo = pronostico.id_equipo1";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet pronosticoPartido = consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta
            while (pronosticoPartido.next()) {
                // obtener el valor de cada columna
                String fase = pronosticoPartido.getString("fase");
                String nro_ronda = pronosticoPartido.getString("nro_ronda");
                String nombre = pronosticoPartido.getString("participante.nombre");
                String id_Equipo1 = pronosticoPartido.getString("nombreEq1");
                String resultado = pronosticoPartido.getString("resultado");
                String id_Equipo2 = pronosticoPartido.getString("nombreEq2");

                // Mostrar los valores obtenidos

               //System.out.println("pronostico de " + nombre + " " + fase + " " + id_Equipo1 + " " + resultado + " vs " + id_Equipo2);


                String[] pronostico = {fase, nro_ronda, nombre, id_Equipo1, resultado, id_Equipo2 };
                listaPronostico.add(pronostico);
            }
            // Esto se utiliza par cerrar la conexión con la base de datos
            pronosticoPartido.close();
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
        System.out.println("Fin de la ejecucción" + "\n");
        return listaPronostico;
    }


}


