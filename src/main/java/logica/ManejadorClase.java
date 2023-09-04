package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorClase{
    private static ManejadorClase instancia = null;
	private List<Clase> clase = new ArrayList<>();
	private ManejadorClase(){}
	
	public static ManejadorClase getInstancia() {
		if (instancia == null)
			instancia = new ManejadorClase();
		return instancia;
	}
	
	public Clase buscarClase(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Clase aretornar = em.find(Clase.class, nombre);
		return aretornar;
	}
	
	public void addClase(Clase clas) {
		Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        em.getTransaction().begin();

        em.persist(clas);
        
        em.getTransaction().commit();
	}
	
	public ArrayList<String> obtenerClase(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select c from Clase c");
		List<Clase> listC = (List<Clase>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Clase i: listC) {
			aRetornar.add(i.getNombre());
		}
		return aRetornar;
	}
	
}
	

	