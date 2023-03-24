package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class LectorArchivo{

	String rutaPronostico;
    List<DatosPronostico> lineasArchivo;// lista donde se cargan las lineas del archivo .csv

    public LectorArchivo(String rutaPronostico) {
        this.rutaPronostico = rutaPronostico;
        this.lineasArchivo = new ArrayList<>();
    }

    public void parsearArchivoPronostico() 
    {
        List<DatosPronostico> listaDePronostico = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
            listaDePronostico = new CsvToBeanBuilder(new FileReader(this.rutaPronostico))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(DatosPronostico.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        this.lineasArchivo = listaDePronostico;
    }
    
    
    public Pronostico crearPronostico()
    {	
    	Pronostico pronostico = new Pronostico(); 
        for (DatosPronostico lineaDePronostico : this.lineasArchivo) 
        {

            		
 
		}
        return pronostico;
        
    }   
}
