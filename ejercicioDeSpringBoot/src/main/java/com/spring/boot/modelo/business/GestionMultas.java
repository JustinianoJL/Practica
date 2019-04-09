package com.spring.boot.modelo.business;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.boot.modelo.DAOs.MultaDAO;
import com.spring.boot.modelo.entities.Multa;


@Service
public class GestionMultas
{
	@Autowired
	private MultaDAO multaDao;
	
	@Transactional
	public void insertar(Multa multa)
	{
		multaDao.intertarMulta(multa);
	}
	public List<Multa> listar()
	{
		return multaDao.listarMultas();
	}
}