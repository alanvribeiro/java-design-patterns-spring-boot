package me.dio.web.service;

import me.dio.web.model.Cliente;

/**
 * Esta interface é um exemplo do Padrão de Projeto Comportamental <b>Strategy</b>,
 * que define uma estratégia de implementação do domínio {@link me.dio.web.model.Cliente}.
 * Com um contrato bem estabelecido, é possível ter múltiplas implementações
 * desta interface de acordo com a necessidade do negócio.
 *
 * @author alanvribeiro
 */
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
