

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


/**
 * Clase que implementa la capa DAO de acceso a Empleados. Utiliza
 * almacenamiento en fichero binario de objetos Java.
 */
public class EmpleadosDAO implements IEmpleadosDAO {

	private Franquicia franquicia;

	public EmpleadosDAO() {
		franquicia = Franquicia.creaFranquicia();
	}

	public Empleado creaEmpleado(Empleado e) {
		franquicia = Franquicia.creaFranquicia();
		// En base al almacenamiento elegido este método
		// no es necesario (en una DAO con BBDD sí sería
		// necesario implementarlo)
		return e;
	}

	public Empleado eliminaEmpleado(String dni) {
		franquicia = Franquicia.creaFranquicia();
		for (Tienda t : franquicia.getTiendas()) {
			for (Empleado e : t.getEmpleados()) {
				if(e.getDNI().equals(dni)) {
					t.getEmpleados().remove(e);
					try {
						Franquicia.flush(franquicia);
					} catch (IOException e1) {
						return null;
					}
					return e;
				}
			}
		}
		return null;					
	}

	public Empleado actualizaEmpleado(Empleado nuevo) {
		franquicia = Franquicia.creaFranquicia();
		for (Tienda t:franquicia.getTiendas()) {
			for (Empleado e:t.getEmpleados()) {
				if (e.getDNI().equals(nuevo.getDNI())) {
					t.getEmpleados().remove(e);
					t.getEmpleados().add(nuevo);
					try {
						Franquicia.flush(franquicia);
					} catch (IOException e1) {
						return null;
					}
					return e;
				}
			}
			
		}
		return null;
	}

	public Empleado empleado(String dni) {
		franquicia = Franquicia.creaFranquicia();
		for (Tienda t : franquicia.getTiendas()) {
			for (Empleado e:t.getEmpleados()) {
				if (e.getDNI().equals(dni))
					return e;
			}
		}
		return null;
	}

	public List<Empleado> empleados() {
		franquicia = Franquicia.creaFranquicia();
		List<Empleado> empleados = new LinkedList<Empleado>();
		for (Tienda t : franquicia.getTiendas()) {
			empleados.addAll(t.getEmpleados());
		}
		return empleados;
	}

}
