package com.spring.boot.modelo.DAOs;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.spring.boot.modelo.entities.Multa;

@Repository
public class MultaJPADAO implements MultaDAO
{
	
	@PersistenceContext
	private EntityManager manager;

	public void intertarMulta(Multa multa)
	{
		manager.persist(multa);
	}

	public void modificarMulta(Multa multa)
	{
		manager.merge(multa);
	}

	public void borrarMulta(Multa multa)
	{
		Multa multaABorrar = buscarMulta(multa.getId());
		manager.remove(multaABorrar);
	}

	public Multa buscarMulta(int id)
	{
		return manager.find(Multa.class,id);
	}

	public List<Multa> listarMultas()
	{
		String query = "select p from Pelicula p";
		return manager.createQuery(query).getResultList();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}