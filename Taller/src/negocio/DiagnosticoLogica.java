package negocio;

import java.sql.SQLException;
import java.util.List;

import datos.DiagnosticoData;
import entidades.Diagnostico;

public class DiagnosticoLogica {
	
	private DiagnosticoData dd;
	
	public DiagnosticoLogica() {
		dd = new DiagnosticoData();
	}
	
	public Diagnostico getOne(Diagnostico diagnostico) throws SQLException {
		return dd.getOne(diagnostico);
	}
	
	public List<Diagnostico> getAll() throws SQLException {
		return dd.getAll();
	}
	
	public void actualizarDiagnostico(Diagnostico diagnostico) throws SQLException {
		dd.actualizarDiagnostico(diagnostico);
	}
	
	public void crearDiagnostico(Diagnostico diagnostico) throws SQLException {
		dd.crearDiagnostico(diagnostico);
	}
}
