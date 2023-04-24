package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.opencsv.bean.CsvToBeanBuilder;

public class LectorArchivo{
    private final String rutaResultado;
    public List<DatosResultado> listaResultado;  //  lista con los resultados del archivo csv
    private final List <Partido> listaPartidos;
    private static List<Pronostico> pronosticoList;


    public LectorArchivo( String rutaResultado) {
        this.listaPartidos = new ArrayList<>();
        this.listaResultado= new ArrayList<>();
        this.rutaResultado = rutaResultado;
        this.parsearArchivoResultado() ;
    }

    public void parsearArchivoResultado() 
    {
        try {
            // En esta primera línea definimos el archivos que va a ingresar
            this.listaResultado = new CsvToBeanBuilder(new FileReader(this.rutaResultado))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(DatosResultado.class)
                    .build()
                    .parse();
            }
        catch (IOException e) {
            e.printStackTrace();
        }
        }

    public List<Partido> getListaPartidos() {
        return this.listaPartidos;
    }

    public List<Partido> crearListaResultadosPartidos()  {
      //  String regex= "[A-Z][a-z]*";

// agrega a listaPartidos cada partido con los resultados
        for ( DatosResultado resultados : this.listaResultado){
    //            expresionRegular(regex, resultados.getEquipo1Descpcion());
                Equipo equipo1 = new Equipo(resultados.getEquipo1Nombre(), resultados.getEquipo1Descpcion());
                Equipo equipo2 = new Equipo(resultados.getEquipo2Nombre(), resultados.getEquipo1Descpcion());
                Partido partido = new Partido(resultados.getRonda_id(),
                        equipo1,
                        equipo2,
                        resultados.getEquipo1Goles(),
                        resultados.getEquipo2Goles()
                );
        this.listaPartidos.add(partido);
        }
        return listaPartidos;
    }

    private boolean expresionRegular (String regex, String descripcion){
        final Pattern pattern = Pattern.compile(regex);
        boolean resultado = pattern.matcher(descripcion).matches();
        if(resultado){
            System.out.println("Cumple con que Descripcion la primer letra sea mayuscula" + descripcion);
        }
        else {
            System.out.println("NO cumple con que Descripcion la primer letra sea mayuscula"+ descripcion);
        }
        return resultado;
    }


    public static List<Pronostico> crearPronosticosList(List<String[]> listaPronosticosString) {
        //      pronostico = {fase, nro_ronda, nombre, id_Equipo1, resultado, id_Equipo2 }
        pronosticoList = new ArrayList<>();
        for (String[] pronosticoString : listaPronosticosString) {
            String participante = pronosticoString[2];
            Equipo equipo1 = new Equipo(pronosticoString[3]);
            Equipo equipo2 = new Equipo(pronosticoString[5]);

            // System.out.println(equipo1.getNombre()+" "+equipo2.getNombre());
            Pronostico pronostico = new Pronostico(pronosticoString[1], pronosticoString [0],participante, equipo1, pronosticoString[4], equipo2);
            pronosticoList.add(pronostico);
        }
        return pronosticoList;
    }
}
    

