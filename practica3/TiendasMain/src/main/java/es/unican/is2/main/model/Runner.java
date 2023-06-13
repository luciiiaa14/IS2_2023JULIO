package es.unican.is2.main.model;

import es.unican.is2.business.model.*;
import es.unican.is2.common.model.*;
import es.unican.is2.datos.model.*;
import es.unican.is2.gui.model.*;

/**
 * Clase principal que construye la aplicación de tres capas y lanza su ejecución
 */
public class Runner {

	public static void main(String[] args) {
		// Componentes capa DAO
		ITiendasDAO tiendasDAO = new TiendasDAO();
		IEmpleadosDAO empleadosDAO = new EmpleadosDAO();
		
		// Componentes capa negocio
		GestionTiendas negocio = new GestionTiendas(tiendasDAO, empleadosDAO);
		
		// Componentes casa presentacion
		VistaGerente vista = new VistaGerente(negocio, negocio);
		
		// Lanza ejecución
		vista.setVisible(true);
	}

}
