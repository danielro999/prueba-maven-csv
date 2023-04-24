package pruebaMaven;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serealizacion.ConfigPuntos;
import serealizacion.ParseoJson;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private ParseoJson parseoJson;
    private ConfigPuntos configPuntos;

    @BeforeEach
    public void init() throws JsonProcessingException {
        parseoJson = new ParseoJson();
        configPuntos = parseoJson.configPuntajesJson("configPuntosTest.json");
    }

    @Test
    void parseoJsonDevolverInt555 ()  {
        assertEquals(555, configPuntos.getPuntosPartido());
    }

    @Test
    void parseoJsonNOdevolverInt84 (){
    Assertions.assertNotEquals(84, configPuntos.getPuntosRonda());
    }


}