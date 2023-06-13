package es.unican.is2.datos.model;



import java.io.IOException;
import java.util.List;
import es.unican.is2.common.model.*;
/**
 * Clase que implementa la capa DAO de acceso a Tiendas.
 * Utiliza almacenamiento en fichero binario de objetos Java.
 */
public class TiendasDAO implements ITiendasDAO {
	
	private Franquicia franquicia;
	
	public TiendasDAO() {
		franquicia = Franquicia.creaFranquicia();
	}

	public Tienda creaTienda(Tienda t) {
		franquicia = Franquicia.creaFranquicia();
		if (tienda(t.getNombre())!= null)
			return null;
		franquicia.getTiendas().add(t);
		try {
			Franquicia.flush(franquicia);
		} catch (IOException e) {
			return null;
		}
		return t;
	}

	public Tienda tienda(String nombre) {
		franquicia = Franquicia.creaFranquicia();
		for (Tienda t: franquicia.getTiendas()) {
			if (t.getNombre().equals(nombre)) {
				return t;
			}
		}
		return null;
	}

	public Tienda actualizaTienda(Tienda nuevo) {
		franquicia = Franquicia.creaFranquicia();
		if (!franquicia.getTiendas().remove(nuevo))
		return null;
		franquicia.getTiendas().add(nuevo);
		try {
				Franquicia.flush(franquicia);
			} catch (IOException e) {
				return null;
			}		
			return nuevo;
		
	}

	public Tienda eliminaTienda(String nombre) {
		franquicia = Franquicia.creaFranquicia();
		Tienda t = tienda(nombre);
		if (t!=null) {
			franquicia.getTiendas().remove(t);
			try {
				Franquicia.flush(franquicia);
			} catch (IOException e) {
				return null;
			}	
			return t;
		}
		return null;
	}

	public List<Tienda> tiendas() {
		franquicia = Franquicia.creaFranquicia();
		return franquicia.getTiendas();
	}


}
