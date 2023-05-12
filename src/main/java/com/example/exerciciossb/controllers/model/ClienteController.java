package com.example.exerciciossb.controllers.model;

import com.example.exerciciossb.controllers.model.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

@GetMapping(path = "/qualquer")
    public Cliente obterCliente (){
        return new Cliente(28, "Pedro", "123.456.789-10");

    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "joao", "787.897.462-00");
    }
    @GetMapping
    public Cliente obterClientePorId2 (@RequestParam(name = "id", defaultValue = "1") int id){
        return new Cliente(id, "Matheus", "111.444.777-78");
    }
}
