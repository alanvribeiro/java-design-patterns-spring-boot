package me.dio.web.service;

import me.dio.web.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Client HTTP criado com <b>OpenFeign</b> para o consumir a API <b>ViaCEP</b>.
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author alanvribeiro
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}
