package com.Jdtecnology.api_sistema_escolar.theproject.controller; // Ajuste para o pacote correto do seu projeto

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> boasVindas() {
        Map<String, String> response = new HashMap<>();
        response.put("mensagem", "Bem-vindo ao  Sistema Escolar!");
        //response.put("status", "Online");
        //response.put("versao", "1.0.0");
        return response;
    }
}
