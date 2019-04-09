package com.spring.boot.modelo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")
public class Multa
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "matricula")
	private String matricula;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "cantidad")
	private Integer cantidad;
	
	public Multa()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Multa(String matricula, String categoria, Integer cantidad)
	{
		super();
		this.matricula = matricula;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getMatricula()
	{
		return matricula;
	}

	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	public String getCategoria()
	{
		return categoria;
	}

	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}

	public Integer getCantidad()
	{
		return cantidad;
	}

	public void setCantidad(Integer cantidad)
	{
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Multa [id=" + id + ", matricula=" + matricula + ", categoria=" + categoria + ", cantidad=" + cantidad
				+ "]";
	}
}