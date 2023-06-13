package es.unican.is2.common.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Empleado de la tienda, con sus datos personales 
 * y datos de ventas y comisiones
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Empleado")

@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Empleado {
	
	private String nombre;
	@XmlElement(name="dni")
	private String DNI;
	private Categoria categoria;

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate fechaContrato;
	
	private boolean baja = false;
	
	@XmlTransient
	private final double REDUCCION_BAJA = 0.25;
	private final double SALARIO_BASE_DEPENDIENTE = 1000;
	private final double SALARIO_BASE_ENCARGADO = 1200;
	
	/**
	 * Constructor sin parámetros. 
	 * IMPTE: No borrar aunque se defina otro
	 */
	public Empleado() {
		
	}

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * Retorna el dni del vendedor
	 * @return id
	 */
	public String getDNI() {
		return DNI;
	}
	
	/**
	 * Retorna la categoria del empleado
	 */
	public Categoria getCategoria () {
		return categoria;
	}
	
	/**
	 * Retorna la fecha de contrato
	 */
	public LocalDate getFechaContrato() {
		return fechaContrato;
	}
	
	/**
	 * Retorna si el empleado está de baja
	 */
	public boolean isBaja() {
		return baja;
	}
	
	/** 
	 * Dar de baja al empleado
	 */
	public void darDeBaja() {
		this.baja=true;
	}
	
	/**
	 * Dar de alta al empleado
	 */
	public void darDeAlta() {
		this.baja=false;
	}
	
	/**
	 * Retorna el sueldo bruto del empleado
	 */
	public double sueldo() {
		double sueldo = 0.0;
		LocalDate mayorCinco = LocalDate.now().minusYears(5);
		LocalDate mayorDiez = LocalDate.now().minusYears(10);
		LocalDate mayorQuince = LocalDate.now().minusYears(15);
		
		
		switch (getCategoria()) {
			case DEPENDIENTE:
				sueldo = SALARIO_BASE_DEPENDIENTE;
				if (isBaja()) {
					sueldo -= sueldo * REDUCCION_BAJA; 
				}
			break;
			case ENCARGADO: 
				sueldo = SALARIO_BASE_ENCARGADO;
				if (isBaja()) {
					sueldo -= sueldo * REDUCCION_BAJA; 
				}
				if (getFechaContrato().isAfter(mayorCinco) && getFechaContrato().isBefore(mayorDiez)) {
					sueldo += 50;
				} else if (getFechaContrato().isAfter(mayorDiez) && getFechaContrato().isBefore(mayorQuince)) {
					sueldo += 100;
				} else if(getFechaContrato().isAfter(mayorQuince)) {
					sueldo += 150;
				}
				break;
		}
			
		return sueldo;
	}
	
}
