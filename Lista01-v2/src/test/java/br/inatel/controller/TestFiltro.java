package br.inatel.controller;

import br.inatel.Utils.CsvUtils;
import br.inatel.model.Jogo;
import br.inatel.model.Plataforma;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestFiltro {

    private static List<Jogo> listaDeJogos;

    @BeforeClass
    public static void InitClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        listaDeJogos = CsvUtils.readGameCsv(caminho);
    }

    @Test
    public void testGamesPS4(){
        List<Jogo> ps4=Filtro.pesquisarPlataforma(listaDeJogos, Plataforma.PS4);
        Assert.assertEquals(10,ps4.size());
    }
}
