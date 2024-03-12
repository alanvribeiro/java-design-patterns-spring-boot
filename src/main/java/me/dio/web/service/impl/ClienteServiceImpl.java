package me.dio.web.service.impl;

import me.dio.web.model.Cliente;
import me.dio.web.model.Endereco;
import me.dio.web.repository.ClienteRepository;
import me.dio.web.repository.EnderecoRepository;
import me.dio.web.service.ClienteService;
import me.dio.web.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Esta classe é a implementação do Padrão de Projeto Comportamental
 * <b>Strategy</b> {@link ClienteService} e possui também exemplos da
 * aplicação do Padrão de Projeto Criacional <b>Singleton</b>, onde usamos
 * a anotação {@link Autowired} para injetar uma instancia única de uma
 * classe que precisa ser utilizada no contexto do {@link Service}.
 *
 * @author alanvribeiro
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComEndereco(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComEndereco(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComEndereco(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não encontre, chama a API ViaCEP para consultar endereço
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}
