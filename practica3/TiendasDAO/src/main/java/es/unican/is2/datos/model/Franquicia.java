package es.unican.is2.datos.model;




import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import es.unican.is2.common.model.*;



/**
 * Clase de utilidad para implementar el almacenamiento en fichero
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "franquicia")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Franquicia  {
	
	// Path absoluto al fichero de almacenamiento (reemplazar si cambia)
	public static String DATA_FILE = "C:\\Users\\lucia\\OneDrive\\Escritorio\\IS2_2023JULIO\\ISS2_2023JULIO\\practica3\\franquicia.xml";

	@XmlElement(required = true, name="tienda")
	private List<Tienda> tiendas;

	
	public List<Tienda> getTiendas() {
		if (tiendas == null) {
			tiendas = new ArrayList<Tienda>();
		}
		return tiendas;
	}
	
	public void setTiendas( List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	
	/**
	 * Lee los datos del fichero y los almacena 
	 * en una instancia de la clase 
	 * @return Instancia de Franquicia con datos
	 */
	public static Franquicia creaFranquicia() {
		JAXBContext jaxbctx;
		try {
			jaxbctx = JAXBContext.newInstance(Franquicia.class);
			// Procesamos el documento (Unmarshall)
			javax.xml.bind.Unmarshaller unmarshaller = jaxbctx
					.createUnmarshaller();
			return (Franquicia) unmarshaller.unmarshal(new File(DATA_FILE));

		} catch (JAXBException j) {
			System.out.println("Error del JAXB");
			System.out.println(j);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	/**
	 * Vuelca los datos de la instancia que se pasa como par·metro
	 * al fichero de almacenamiento
	 * @return Instancia de Ayuntamiento con datos
	 */
	public static void flush(Franquicia franquicia) throws IOException {
		try {
			JAXBContext jaxbctx = JAXBContext.newInstance(Franquicia.class);
			// Volcar la ifnoramci√õn a un fichero
			Marshaller marshaller = jaxbctx.createMarshaller();
			marshaller.marshal(franquicia, new File(DATA_FILE));
		} catch (JAXBException e) {
			throw new IOException("No se puede volcar la informacion al fichero");
		}
		
	}

	

	
	
}
