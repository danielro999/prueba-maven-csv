package serealizacion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseoJson {
    public ConfigConexionDB configConexionDBJson(String rutaJson) throws JsonProcessingException {
        String json = null;
        try {
            for (String linea : Files.readAllLines(Paths.get(rutaJson))) {
                json = linea;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper mapper = new ObjectMapper();
        ConfigConexionDB configDBParseada = mapper.readValue(json, ConfigConexionDB.class);

        return configDBParseada;
    }

public ConfigPuntos configPuntajesJson(String rutaJson) throws JsonProcessingException {
    String json = null;
    try {
        for (String linea : Files.readAllLines(Paths.get(rutaJson)))
        {
            json = linea;
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    ObjectMapper mapper = new ObjectMapper();
    ConfigPuntos configDBParseada = mapper.readValue(json, ConfigPuntos.class);
    System.out.println("Puntos por acertar partido = " + configDBParseada.getPuntosPartido());
    System.out.println("Puntos extras por acertar toda la ronda = " + configDBParseada.getPuntosRonda());
    System.out.println("Puntos extras por acertar las todas fases = " + configDBParseada.getPuntosfase()+ "\n");
    return configDBParseada;
    }
}
