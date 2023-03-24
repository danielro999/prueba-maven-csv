package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class LectorArchivo{

	private String rutaPronostico;
	private String rutaResultado;
	public List<DatosResultado> listaResultado;
    public List<DatosPronostico> listaPronostico;// lista donde se cargan las lineas del archivo .csv
 
    public LectorArchivo(String rutaPronostico, String rutaResultado) {
        this.rutaPronostico = rutaPronostico;
        this.rutaResultado = rutaResultado;
        this.parsearArchivoPronostico();
        this.parsearArchivoResultado() ;
    }
    
    public void parsearArchivoPronostico() 
    {
    	this.listaPronostico = new ArrayList<>();	
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	this.listaPronostico = new CsvToBeanBuilder(new FileReader(this.rutaPronostico))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(DatosPronostico.class)
                    .build()
                    .parse();
            }
        catch (IOException e) 
        	{
        	e.printStackTrace();
        	}
        }
    
    public void parsearArchivoResultado() 
    {
    	this.listaResultado= new ArrayList<>();
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
        catch (IOException e) 
        	{
        	e.printStackTrace();
        	}
        }
}
    

