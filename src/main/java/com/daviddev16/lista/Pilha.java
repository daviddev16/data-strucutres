package com.daviddev16.lista;


import com.daviddev16.Util;

/* Stack LAST-IN-FIRST-OUT */
@SuppressWarnings("unchecked")
public class Pilha<T> {

    private Object[] arrayElementos;

    private int capacidadeInicial;

    private int indiceTopo;

    public Pilha() { this(8); }

    public Pilha(int capacidadeInicial) {
        this.capacidadeInicial = capacidadeInicial;
        arrayElementos = new Object[this.capacidadeInicial];
    }

    public void empilhar(T elemento) {
        if (indiceTopo >= arrayElementos.length) {
            regularizarArrayInterna(arrayElementos.length >> 1);
        }
        arrayElementos[indiceTopo] = elemento;
        indiceTopo += 1;
    }

    public T desempilhar() {
        indiceTopo -= 1;
        T objetoRemocao = (T) arrayElementos[indiceTopo];
        arrayElementos[indiceTopo] = null;
        return objetoRemocao;
    }

    public T topo() {
        return (T) arrayElementos[indiceTopo];
    }

    public boolean estaCheia() {
        return indiceTopo >= arrayElementos.length;
    }

    public boolean estaVazio() {
        return indiceTopo == 0;
    }

    /**
     * Método utilizado para regularizar o tamanho da array interna
     * tanto para expandir ou remover os elementos nulos dentro da
     * array.
     * */
    protected void regularizarArrayInterna(int valorExpansao) {
        int tamanhoNovoArray = arrayElementos.length + valorExpansao;
        Object[] novoArrayElementos = new Object[tamanhoNovoArray];
        int i = 0, j = 0;
        while (i < arrayElementos.length) {
            Object elementoAtual = arrayElementos[i];
            if (elementoAtual != null) {
                novoArrayElementos[j] = elementoAtual;
                j++;
            }
            i++;
        }
        arrayElementos = novoArrayElementos;
    }

    /**
     * Retorna o conjunto de elementos da array. Esse conjunto
     * exibe os "slots" que foram preenchidos, apenas.
     * */
    public String toPrettyString() {
        return Util.internalToPrettyString(false, arrayElementos);
    }

    /**
     * Retorna o conjunto de elementos da array. Esse conjunto
     * exibe os "slots" vazios que serão usados na próxima inserção
     * da lista.
     * */
    @Override
    public String toString() {
        return Util.internalToPrettyString(true, arrayElementos);
    }

    public int getCapacidadeInicial() {
        return capacidadeInicial;
    }
}
