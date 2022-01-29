package com.elvissilva.defaultprojectspring.service;

import com.elvissilva.defaultprojectspring.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br")
public interface IViaCepService {
    @GetMapping("/{cep}/json/")
    Address consultCep(@PathVariable("cep") String cep);
}
