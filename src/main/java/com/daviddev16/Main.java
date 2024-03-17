package com.daviddev16;

import com.daviddev16.lista.Pilha;

import java.util.Random;

public class Main {

    static Random random = new Random();
    static String[] nomes = {"David", "Renan", "Guilherme", "Duarte", "Lisboa", "Maria", "Victor", "Matheus", "Carol"};

    static String nomeAleatorio() {
        return nomes[random.nextInt(nomes.length)];
    }

    public static void main(String[] args) {

        Pilha<String> pilha = new Pilha<>(10);

        pilha.empilhar("a");

        for (int i = 0; i < 10; i++) {
            //pilha.empilhar(nomeAleatorio());
        }

        System.out.println(pilha.estaCheia());
        System.out.println(pilha.estaVazio());
    }

}
