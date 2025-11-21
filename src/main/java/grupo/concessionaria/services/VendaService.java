package grupo.concessionaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo.concessionaria.entities.Venda;
import grupo.concessionaria.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;

	public List<Venda> procurarTodos() {
		return repository.findAll();
	}

	public Venda procurarPorId(Integer id) {
		return repository.findById(id).get();
	}

	public String adicionarVenda(Venda venda) {
		repository.save(venda);
		return "Véiculo alugado com sucesso";
	}

	public String editarVenda(Integer id, Venda venda) {
		Venda response = repository.findById(id).get();
		response.setId(venda.getId());
		response.setDataVenda(venda.getDataVenda());
		response.setValorFinal(venda.getValorFinal());
		response.setCliente(venda.getCliente());

		repository.save(response);
		return " Venda editado com sucesso!";
	}

	public String excluirVenda(Integer id) {
		Venda response = repository.findById(id).get();
		repository.delete(response);
		return "Venda excluida com sucesso!";
	}

}
