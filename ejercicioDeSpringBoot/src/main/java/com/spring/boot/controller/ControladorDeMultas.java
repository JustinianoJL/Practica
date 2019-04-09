package com.spring.boot.controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.modelo.entities.Multa;
import com.spring.boot.modelo.entities.MultaRepository;

@RestController
public class ControladorDeMultas
{
private final MultaRepository repository;
	
	public ControladorDeMultas(MultaRepository repository)
	{
		this.repository = repository;
	}
	
	@GetMapping("/multas")
	public List<Multa> multas()
	{
		return repository.findAll();
	}
	
	@GetMapping("/multas/{id}")
	public Multa multas(@PathVariable Integer id)
	{
		return repository.findById(id)
				.orElse(null);
	}
	
	@PostMapping("/multas")
	public Multa nuevaMulta(@RequestBody Multa multa)
	{
		return repository.save(multa);
	}
	
	@DeleteMapping("/multas/{id}")
	public void borrarMulta(@PathVariable Integer id)
	{
		repository.deleteById(id);
	}
	
	@PutMapping("/multas/{id}")
	public Multa actualizarMulta(@RequestBody Multa multa,@PathVariable Integer id)
	{
		return repository.findById(id)
			.map(m -> {
					m.setMatricula(multa.getMatricula());
					m.setCategoria(multa.getCategoria());
					m.setCantidad(multa.getCantidad());
					return repository.save(m);
				})
			.orElseGet(()->{
				multa.setId(id);
				return repository.save(multa);
			});
	}
}
