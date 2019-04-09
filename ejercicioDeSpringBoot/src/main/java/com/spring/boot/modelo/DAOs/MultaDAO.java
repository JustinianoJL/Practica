package com.spring.boot.modelo.DAOs;

import java.util.List;

import com.spring.boot.modelo.entities.Multa;

public interface MultaDAO
{
	void intertarMulta(Multa multa);
	void modificarMulta(Multa multa);
	void borrarMulta(Multa multa);
	Multa buscarMulta(int id);
	List<Multa> listarMultas();
}