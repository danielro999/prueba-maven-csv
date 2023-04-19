package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class LectorArchivo{
    private final String rutaResultado;
    public List<DatosResultado> listaResultado;  //  lista con los resultados del archivo csv
    private final List <Partido> listaPartidos;


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
// agrega a listaPartidos cada partido con los resultados
        for ( DatosResultado resultados : this.listaResultado){
                Equipo equipo2 = new Equipo(resultados.getEquipo2Nombre(), resultados.getEquipo1Descpcion());
                Equipo equipo1 = new Equipo(resultados.getEquipo1Nombre(), resultados.getEquipo1Descpcion());
                Partido partido = new Partido(
                        resultados.getRonda_id(),
                        equipo1,
                        equipo2,
                        resultados.getEquipo1Goles(),
                        resultados.getEquipo2Goles()
                );
        this.listaPartidos.add(partido);
        }
       // for (Partido partido : listaPartidos) {System.out.println(partido.getEquipo1().getNombre() + partido.resultadoEquipo1());}

        return listaPartidos;
    }
}
    

