package com.daviddev16.lista;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaLinearTest {

    @Test
    @DisplayName("Sem crescimento (Capacidade = Tamanho)")
    void validacaoInicialTamanhoListaLinear() {

        ListaLinear<String> listaLinear = new ListaLinear<String>(4);

        listaLinear.adicionar("David");
        listaLinear.adicionar("Guilherme");
        listaLinear.adicionar("Victor");
        listaLinear.adicionar("Matheus");

        assertEquals(listaLinear.tamanho(), listaLinear.capacidade());
    }

    @Test
    @DisplayName("Crescimento do Array (Capacidade <> Tamanho)")
    void validacaoInicialCrescimentoListaLinear() {

        ListaLinear<String> listaLinear = new ListaLinear<String>(4);

        listaLinear.adicionar("David");
        listaLinear.adicionar("Guilherme");
        listaLinear.adicionar("Victor");
        listaLinear.adicionar("Matheus");
        listaLinear.adicionar("Herique");
        listaLinear.adicionar("Raquel");
        listaLinear.adicionar("Pedro");

        assertNotEquals(listaLinear.tamanho(), listaLinear.capacidade());
    }

    @Test
    @DisplayName("Remoção de elementos")
    void validacaoRemocaoElementoDaListaLinear() {

        ListaLinear<String> listaLinear = new ListaLinear<String>(4);

        listaLinear.adicionar("David");
        listaLinear.adicionar("Guilherme");
        listaLinear.adicionar("Victor");
        listaLinear.adicionar("Matheus");
        listaLinear.adicionar("Herique");
        listaLinear.adicionar("Raquel");
        listaLinear.adicionar("Pedro");

        assertEquals(7, listaLinear.tamanho());

        assertTrue(listaLinear.removerPorObjeto("Victor"));
        assertTrue(listaLinear.removerPorIndice(0));

        assertEquals(5, listaLinear.tamanho());

        assertFalse(listaLinear.contemObjeto("David"));
        assertFalse(listaLinear.contemObjeto("Victor"));
    }

    @Test
    @DisplayName("Remover todos os elementos")
    void validacaoLimparTodaListaLinear() {

        ListaLinear<String> listaLinear = new ListaLinear<String>(4);

        listaLinear.adicionar("David");
        listaLinear.adicionar("Guilherme");
        listaLinear.adicionar("Victor");
        listaLinear.adicionar("Matheus");
        listaLinear.adicionar("Herique");
        listaLinear.adicionar("Raquel");
        listaLinear.adicionar("Pedro");

        assertEquals(7, listaLinear.tamanho());

        listaLinear.limpar();

        assertEquals(0, listaLinear.tamanho());
        assertFalse(listaLinear.contemObjeto("Victor"));
        assertNotEquals(listaLinear.tamanho(), listaLinear.capacidade());
    }

    @Test
    @DisplayName("Validar recuperação de valores")
    void validacaoRecuperacaoDeDadosListaLinear() {

        ListaLinear<String> listaLinear = new ListaLinear<String>(4);

        listaLinear.adicionar("David");
        listaLinear.adicionar("Guilherme");
        listaLinear.adicionar("Victor");
        listaLinear.adicionar("Matheus");
        listaLinear.removerPorIndice(3);
        listaLinear.adicionar("Henrique");
        listaLinear.adicionar("Raquel");
        listaLinear.adicionar("Pedro");
        listaLinear.removerPorIndice(5);

        assertEquals("Guilherme", listaLinear.obter(1));
        assertEquals("Henrique", listaLinear.obter(3));
        assertNull(listaLinear.obter(6));
    }

}