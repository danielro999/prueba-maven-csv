package modelo;

public class Partido {
	private int ronda_id;
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	public Partido (int ronda_id, Equipo equipo1, Equipo equipo2,int golesEquipo1, int golesEquipo2) {
		this.ronda_id = ronda_id;
		this.equipo1 = equipo1;
		this.golesEquipo1 = golesEquipo1;
		this.equipo2 = equipo2;
		this.golesEquipo2 = golesEquipo2;
	}
	
	
	public ResultadoEnum resultadoEquipo1() {
		if (golesEquipo1 > golesEquipo2) {
			return ResultadoEnum.GANADOR;
		}
		if (golesEquipo1 == golesEquipo2) {
			return ResultadoEnum.EMPATE;
		} 
		else {
			return ResultadoEnum.PERDEDOR;
		}
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public int getRonda_id() { return this.ronda_id; }
}
