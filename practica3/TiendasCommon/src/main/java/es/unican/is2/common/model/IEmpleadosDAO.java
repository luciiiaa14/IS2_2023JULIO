

import java.util.List;

/**
 * Interfaz DAO para Empleados
 */
public interface IEmpleadosDAO  {
	
	/** 
	 * Persite un nuevo empleado
	 * @param v Empleado a anhadir
	 * @return El empleado una vez anhadido
	 *         null si no se añade el empleado (ya existe)
	 */
	public Empleado creaEmpleado(Empleado e);
	
	/**
	 * Elimina el empleado cuya matricula se pasa
	 * como parametro
	 * @param dni DNI del empleado
	 * @return El empleado eliminado
	 *         null si no se encuentra el empleado
	 */
	public Empleado eliminaEmpleado(String dni);
	
	/**
	 * Actualiza el estado del empleado que se pasa
	 * como parametro
	 * @param nuevo Nuevo estado del empleado
	 * @return Empleado actualizado
	 *         null si no existe
	 */
	public Empleado actualizaEmpleado(Empleado nuevo);
	
	/**
	 * Retorna el empleado cuya matricula se pasa 
	 * como parametro
	 * @param dni DNI del empleado
	 * @return empleado
	 * 		   null si no se encuentra
	 */
	public Empleado empleado(String dni);
	
	/**
	 * Retorna la lista completa de empleados
	 * @return La lista de empleados
	 *         Lista vacia si no hay ninguno
	 */
	public List<Empleado> empleados();
}
