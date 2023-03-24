package modelo;

public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	public ResultadoEnum resultado(Equipo equipo) {
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

}
