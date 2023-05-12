package com.example.exerciciossb.controllers.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank //diferente de vazio
    private String nome;

    @Min(0)//preço deve ser no minimo 0 evitando valores negativos
    private double preco;
@Min(0)
@Max(1)
    private double desconto;




    public Produto(String nome ,double preco, double desconto) {
        this.preco = preco;
        this.desconto = desconto;
        this.nome = nome;
    }

    public Produto() {

    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


