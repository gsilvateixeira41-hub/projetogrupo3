package grupo.concessionaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grupo.concessionaria.entities.Venda;
import grupo.concessionaria.services.VendaService;

@RequestMapping(value = "/Venda")
@RestController

public class VendaController {
	@Autowired
	private VendaService service;

	@GetMapping
	public List<Venda> procurarTodos() {
		return service.procurarTodos();
	}

	@GetMapping(value = "/{id}")
	public Venda procurarPortodos(@PathVariable Integer id) {
		return service.procurarPorId(id);
	}

	@PostMapping
	public String adicionarVenda(@RequestBody Venda venda) {
		String response = service.adicionarVenda(venda);
		return response;
	}

	@PutMapping(value = "/{id}")
	public String editarrVenda(@PathVariable Integer id, @RequestBody Venda venda) {
		String response = service.editarVenda(id, venda);
		return response;
	}

	@DeleteMapping("/{id}")
	public void excluirVenda(@PathVariable Integer id) {
		service.excluirVenda(id);

	}

}
