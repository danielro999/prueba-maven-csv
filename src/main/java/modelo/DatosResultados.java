package modelo;

import com.opencsv.bean.CsvBindByPosition;

public class DatosResultados {
	@CsvBindByPosition(position = 0)
    private String equipo1Id;
    @CsvBindByPosition(position = 1)
    private String equipo1Nombre;
    @CsvBindByPosition(position = 2)
    private String equipo1Descpcion;
    @CsvBindByPosition(position = 3)
    private int equipo1Goles;
    @CsvBindByPosition(position = 4)
    private int equipo2Goles;
    @CsvBindByPosition(position = 5)
    private String equipo2Id;
    @CsvBindByPosition(position = 6)
    private String equipo2Nombre;
    @CsvBindByPosition(position = 7)
    private String equipo2Descpcion;
	public String getEquipo1Id() {
		return equipo1Id;
	}
	public void setEquipo1Id(String equipo1Id) {
		this.equipo1Id = equipo1Id;
	}
	public String getEquipo1Nombre() {
		return equipo1Nombre;
	}
	public void setEquipo1Nombre(String equipo1Nombre) {
		this.equipo1Nombre = equipo1Nombre;
	}
	public String getEquipo1Descpcion() {
		return equipo1Descpcion;
	}
	public void setEquipo1Descpcion(String equipo1Descpcion) {
		this.equipo1Descpcion = equipo1Descpcion;
	}
	public int getEquipo1Goles() {
		return equipo1Goles;
	}
	public void setEquipo1Goles(int equipo1Goles) {
		this.equipo1Goles = equipo1Goles;
	}
	public int getEquipo2Goles() {
		return equipo2Goles;
	}
	public void setEquipo2Goles(int equipo2Goles) {
		this.equipo2Goles = equipo2Goles;
	}
	public String getEquipo2Id() {
		return equipo2Id;
	}
	public void setEquipo2Id(String equipo2Id) {
		this.equipo2Id = equipo2Id;
	}
	public String getEquipo2Nombre() {
		return equipo2Nombre;
	}
	public void setEquipo2Nombre(String equipo2Nombre) {
		this.equipo2Nombre = equipo2Nombre;
	}
	public String getEquipo2Descpcion() {
		return equipo2Descpcion;
	}
	public void setEquipo2Descpcion(String equipo2Descpcion) {
		this.equipo2Descpcion = equipo2Descpcion;
	}
    
    
    
}
