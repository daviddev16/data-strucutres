package com.daviddev16.lista;

import com.daviddev16.Util;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class ListaLinear<T> {

    private Object[] arrayElementos;
    private final int capacidadeInicial;
    private int contadorTamanho = 0;

    public ListaLinear() {
        this(16);
    }

    /**
     * ListaLinear é uma estrutura de dados que armazena os dados sequenciamente,
     * independentemente da ordem dos elementos, a lista linear possui um acesso
     * aleatório.
     * */
    public ListaLinear(int capacidadeInicial) {
        this.capacidadeInicial = capacidadeInicial;
        arrayElementos = new Object[this.capacidadeInicial];
    }

    /**
     * Obtem o valor do elemento do indice solicitado.
     * */
    @SuppressWarnings("unchecked")
    public T obter(int indice) {
        if (indice < 0 || indice > contadorTamanho) {
            return null;
        }
        return (T) arrayElementos[indice];
    }

    /**
     * Insere um novo elemento na lista.
     * */
    public void adicionar(T elemento) {
        if (elemento == null) {
            throw new NullPointerException("O elemento passado é nulo.");
        }
        if (contadorTamanho == arrayElementos.length) {
            regularizarArrayInterna(arrayElementos.length >> 1);
        }
        arrayElementos[contadorTamanho] = elemento;
        contadorTamanho++;
    }

    /**
     * Remove o objeto passado em elemento, caso exista na lista.
     *
     * @return false Caso não encontre o elemento na lista e true
     * se a remoção obteve sucesso.
     * */
    public boolean removerPorObjeto(T elemento) {
        if (elemento == null) {
            throw new NullPointerException("O elemento passado é nulo.");
        }
        for (int i = 0; i < arrayElementos.length; i++) {
            if (Objects.equals(elemento, arrayElementos[i])) {
                return removerPorIndice(i);
            }
        }
        return false;
    }

    /**
     * Remove o elemento do indice passado da lista.
     *
     * @return false Caso indice for menor que zero ou maior que
     * {@link ListaLinear#tamanho()} e true caso tenha sucesso
     * na remoção do elemento.
     * */
    public boolean removerPorIndice(int indice) {
        if (indice < 0 || indice >= contadorTamanho) {
            return false;
        }
        arrayElementos[indice] = null;
        regularizarArrayInterna(0);
        contadorTamanho--;
        return true;
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
            Object elemento = arrayElementos[i];
            if (elemento != null) {
                novoArrayElementos[j] = elemento;
                j++;
            }
            i++;
        }
        arrayElementos = novoArrayElementos;
    }

    /**
     * Verifica se contem o objeto passado em "elemento" dentro
     * da lista linear.
    * */
    public boolean contemObjeto(T elemento) {
        for (int i = 0; i < arrayElementos.length; i++) {
            if (Objects.equals(elemento, arrayElementos[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Limpa as informações da lista
     * */
    public void limpar() {
        contadorTamanho = 0;
        Arrays.fill(arrayElementos, null);
        arrayElementos = new Object[this.capacidadeInicial];
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

    /**
     * Tamanho da array interna. Onde {@code capacidade() - tamanho()}
     * representa a capacidade de armazenar dados sem precisar
     * expandir a array interna.
     * */
    public int capacidade() {
        return arrayElementos.length;
    }

    /**
     * Quantidade real variável de objetos na lista.
     * */
    public int tamanho() {
        return contadorTamanho;
    }

    /**
     * Capacidade inicial do tamanho da array interna, passada
     * no construtor de {@code ListaLinear}.
     * */
    public int getCapacidadeInicial() {
        return capacidadeInicial;
    }
}
