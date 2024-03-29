package one.digitalinnovation.padroesspring.service;

import one.digitalinnovation.padroesspring.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepService {
    @GetMapping(value = "{cep}/json")
    Address consultarCep(@PathVariable("cep") String cep);
}
