package es.unican.is2.business.model;


/**
 * Clase para la gestion de tiendas.
 */
public class GestionTiendas {
	private IEmpleadosDAO daoEmpleados;
	private ITiendasDAO daoTiendas;
	
	/**
	 * Añade una nueva tienda
	 * @param t Tienda que se desea anhadir
	 * @return La tienda anhadida
	 * 		   null si no se anhade porque ya existe
	 */
	public Tienda altaTienda(Tienda t);
	
	/**
	 * Elimina una tienda
	 * @param nombre Nombre de la tienda que se desea eliminar
	 * @return La tienda eliminada
	 * 		   null si no se elimina porque no se encuentra 
	 * @throws OperacionNoValida si la tienda existe 
	 *         pero tiene empleados
	 */
	public Tienda bajaTienda(String nombre) throws OperacionNoValida;
	
	/**
	 * Retorna una tienda dado su nombre
 	 * @param nombre Nombre de la tienda
	 * @return La tienda
	 * 			null si no existe
	 */
	public Tienda tienda(String nombre);


}
