package br.inatel.utils;

import br.inatel.Utils.CsvUtils;
import br.inatel.model.Jogo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class testCsvUtils {
    private static List<Jogo> gameList;


    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        gameList = CsvUtils.readGameCsv(caminho);
    }

    @Test
    public void testNumberOfLines(){
        int numLines = gameList.size();
        Assert.assertEquals(100,numLines);
    }
}