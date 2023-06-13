

/**
 * Clase principal que construye la aplicación de tres capas y lanza su ejecución
 */
public class Runner {

	public static void main(String[] args) {
		// Componentes capa DAO
		TiendasDAO tiendasDAO = new TiendasDAO();
		EmpleadosDAO vehiculosDAO = new EmpleadosDAO();
		
		// Componentes capa negocio
		GestionTiendas negocio = new GestionTiendas(tiendasDAO, vehiculosDAO);
		
		// Componentes casa presentacion
		VistaGerente vista = new VistaGerente(negocio, negocio);
		
		// Lanza ejecución
		vista.setVisible(true);
	}

}
