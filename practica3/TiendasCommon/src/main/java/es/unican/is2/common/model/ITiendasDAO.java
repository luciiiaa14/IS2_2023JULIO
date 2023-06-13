

import java.util.List;

/**
 * Interfaz DAO para tiendas
 */
public interface ITiendasDAO  {
	
	/** 
	 * Persite una nueva tienda
	 * @param t Tienda a anhadir
	 * @return La tienda una vez anhadida
	 *         null si no se puede anhadir porque ya existe
	 */
	public Tienda creaTienda(Tienda t);
	
	/**
	 * Retorna una tienda
	 * @param nombre Nombre de la tienda
	 * @return La tienda buscada
	 * 		   null si no se encuentra
	 */
	public Tienda tienda(String nombre);
	
	/**
	 * Actualiza el estado de la tienda que se pasa
	 * como parametro
	 * @param nuevo Nuevo estado de la tienda
	 * @return Tienda actualizada
	 *         null si no existe
	 */
	public Tienda actualizaTienda(Tienda nuevo);
	
	/**
	 * Elimina una tienda
	 * @param nombre Nombre de la tienda
	 * @return Tienda eliminada
	 *         null si no se encuentra la tienda
	 */
	public Tienda eliminaTienda(String nombre);
	
	/**
	 * Retorna la lista completa de tiendas
	 * @return Lista de tiendas
	 *         Lista vacia si no hay ninguna
	 */
	public List<Tienda> tiendas();
	
}
