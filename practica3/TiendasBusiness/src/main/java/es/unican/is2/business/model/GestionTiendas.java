package es.unican.is2.business.model;

import es.unican.is2.common.model.*;


/**
 * Clase para la gestion de tiendas.
 */
public class GestionTiendas implements IGestionEmpleados, IGestionTiendas {
	private IEmpleadosDAO daoEmpleados;
	private ITiendasDAO daoTiendas;
	
	//Creo el constructor.
	public GestionTiendas(ITiendasDAO infoTiendas, IEmpleadosDAO infoEmpleados) {
		this.daoEmpleados = infoEmpleados;
		this.daoTiendas = infoTiendas;		
	}
	
	/**
	 * Añade una nueva tienda
	 * @param t Tienda que se desea anhadir
	 * @return La tienda anhadida
	 * 		   null si no se anhade porque ya existe
	 */
	public Tienda altaTienda(Tienda t) {
		return daoTiendas.creaTienda(t);
	}
	
	/**
	 * Elimina una tienda
	 * @param nombre Nombre de la tienda que se desea eliminar
	 * @return La tienda eliminada
	 * 		   null si no se elimina porque no se encuentra 
	 * @throws OperacionNoValida si la tienda existe 
	 *         pero tiene empleados
	 */
	public Tienda bajaTienda(String nombre) throws OperacionNoValida {
		Tienda tienda = tienda(nombre);
		if (tienda == null) {
			return null;
		}
		if (tienda.getEmpleados().size() != 0) {
			throw new OperacionNoValida(nombre);
		}
		return daoTiendas.eliminaTienda(nombre);
	}
	
	/**
	 * Retorna una tienda dado su nombre
 	 * @param nombre Nombre de la tienda
	 * @return La tienda
	 * 			null si no existe
	 */
	public Tienda tienda(String nombre) {
		Tienda t = daoTiendas.tienda(nombre);
		if ( t == null) {
			return null;
		} 
		return t;
	}

	/**
	 * Añade un nuevo empleado a una tienda
	 * @param e Empleado que se quiere añadir
	 * @param nombre Nombre de la tienda
	 * @return El empleado añadido
	 * 		   null si no se anhade porque no se encuentra la tienda
	 * @throws OperacionNoValida si el empleado ya existe
	 */
	public Empleado altaEmpleado(Empleado e, String nombre) throws OperacionNoValida {
		Empleado empleado = daoEmpleados.empleado(e.getDNI());
		Tienda tienda = daoTiendas.tienda(nombre);
		if (tienda == null) {
			return null;
		}
		if (empleado != null) {
			throw new OperacionNoValida(empleado.getDNI());
		}
		daoEmpleados.creaEmpleado(empleado);
		tienda.getEmpleados().add(empleado);
		return empleado;
		
	}
	
	/**
	 * Elimina un empleado de una tienda 
	 * @param dni DNI del empleado
	 * @param nombre Nombre de la tienda
 	 * @return El empleado eliminado
 	 *         null si el empleado o la tienda no existen
 	 * @throws OperacionNoValida si el empleado no pertenece a la tienda indicada
	 */
	public Empleado bajaEmpleado(String dni, String nombre) throws OperacionNoValida {
		Empleado empleado = daoEmpleados.empleado(dni);
		Tienda tienda = daoTiendas.tienda(nombre);
		if (tienda == null) {
			return null;
		}
		if (empleado == null) {
			return null;
		}
		
		if (tienda.getEmpleados().remove(empleado) != true) {
			throw new OperacionNoValida(empleado.getDNI());
		}
		daoEmpleados.eliminaEmpleado(dni);
		
		return empleado;
		
	}
	/**
	 * Retorna el empleado con el dni indicado
	 * @param dni
	 * @return El empleado con el dni indicado
	 *         null si no existe
	 */
	public Empleado empleado(String dni) {
		Empleado e = daoEmpleados.empleado(dni);
			if ( e == null) {
				return null;
			} 
			return e;
		}
	


}
