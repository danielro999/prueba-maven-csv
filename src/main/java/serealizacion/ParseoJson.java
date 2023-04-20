package serealizacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseoJson {
public ConfigPuntos crearConfigDBJson (String json) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    ConfigPuntos configDBParseada = mapper.readValue(json, ConfigPuntos.class);
    System.out.println("Puntos por acertar partido = " + configDBParseada.getPuntosPartido());
    System.out.println("Puntos extras por acertar toda la ronda = " + configDBParseada.getPuntosRonda());
    System.out.println("Puntos extras por acertar las todas fases = " + configDBParseada.getPuntosfase());

    return configDBParseada;
}
}
