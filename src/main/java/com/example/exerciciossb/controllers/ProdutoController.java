package com.example.exerciciossb.controllers;

import com.example.exerciciossb.controllers.model.entities.Produto;
import com.example.exerciciossb.controllers.model.entities.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
    public @ResponseBody Produto salvarProduto(@Valid Produto produto) {

        produtoRepository.save(produto);

        return produto;

    }

    @GetMapping
    public Iterable<Produto> obterProdutos (){
       return produtoRepository.findAll();//consulta todos registros enviados ao banco de dados pelo postman
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome (@PathVariable String parteNome ){
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
    public Iterable<Produto> obterProdutosPorPagina (@PathVariable int numeroPagina, @PathVariable int qtdePagina){
        if(qtdePagina >= 5) qtdePagina =5;
        Pageable page = PageRequest.of(numeroPagina,qtdePagina);
        return produtoRepository.findAll(page);
    }


@GetMapping(path = "/{id}")
    public Optional <Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }
//@PutMapping
//    public Produto alterarProduto (@Valid Produto produto){
//        produtoRepository.save(produto);
//        return produto;
//
//    }

@DeleteMapping(path = "/{id}")
    public void excluirProduto (@PathVariable int id){
        produtoRepository.deleteById(id);


    }





}
