package com.spring.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.model.Cliente;
import com.spring.boot.model.ClienteRepository;

@RestController
public class ClientesControlador {

	private final ClienteRepository repository;

	public ClientesControlador(ClienteRepository repository) {
		this.repository = repository;
	}
	
	//obtener totdos los clientes
	@GetMapping("/clientes")
	public List<Cliente> clientes(){
		return repository.findAll();
	}
	
	//buscar cliente por matricula
	@GetMapping("/clientes/{id}")
	public Cliente cliente(@PathVariable Integer id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	//guarda un cliente
	@PostMapping("/clientes")
	public Cliente nuevoCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	//elimina un cliente
	@DeleteMapping("/clientes/{matricula}")
	public void borrarCliente(@PathVariable Integer matricula) {
		repository.deleteById(matricula);
	}
	
	//actualiza un cliente si no existe lo crea
	@PutMapping("/clientes/{matricula}")
	public Cliente actualizarCliente(@RequestBody Cliente cliente,@PathVariable Integer matricula) {
		return repository.findById(matricula)
			.map(c -> {
					c.setNombre(cliente.getNombre());
					c.setApellidos(cliente.getApellidos());
					c.setDireccion(cliente.getDireccion());
					return repository.save(c);
				})
			.orElseGet(()->{
				cliente.setMatricula(matricula);
				return repository.save(cliente);
			});
			
	}
	
	
}
