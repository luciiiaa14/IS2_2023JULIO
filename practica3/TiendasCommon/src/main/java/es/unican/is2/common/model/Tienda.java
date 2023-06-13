package es.unican.is2.common.model;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase que representa una tienda con un conjunto de empleados
 */
@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Tienda")

@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Tienda implements Serializable {

	@XmlElement(name="empleado")
	private List<Empleado> empleados = new LinkedList<Empleado>();
	
	private String direccion;
	private String nombre;
	
	/**
	 * Constructor sin parámetros. 
	 * IMPTE: No borrar aunque se defina otro
	 */
	public Tienda() {}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Retorna la lista de Empleadoes actuales de la tienda
	 * @return La lista de empleados
	 */
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	
	/**
	 * Retorna el gasto mensual de la tienda en 
	 * pagar sueldos de sus empleados.
	 * @return Total mensual sueldos 
	 */
	public double gastoMensualSueldos() {
			double sueldosMensuales = 0.0;
			for (int i = 0; i < empleados.size(); i++) {
				sueldosMensuales += empleados.get(i).sueldo();
			}
		return sueldosMensuales;
	}
}
