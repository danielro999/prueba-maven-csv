package modelo;

public class Pronostico {
	private String equipo1;
	private String gana1;
	private String empate;
	private String gana2;
	private String equipo2;

    public Pronostico(String equipo1, String gana1, String empate, String gana2, String equipo2) {
        this.equipo1 = equipo1;
        this.gana1 = gana1;
        this.empate = empate;
        this.gana1 = gana2;
        this.empate = equipo2;
    }

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getGana1() {
		return gana1;
	}

	public void setGana1(String gana1) {
		this.gana1 = gana1;
	}

	public String getEmpate() {
		return empate;
	}

	public void setEmpate(String empate) {
		this.empate = empate;
	}

	public String getGana2() {
		return gana2;
	}

	public void setGana2(String gana2) {
		this.gana2 = gana2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
    
    
    
}
