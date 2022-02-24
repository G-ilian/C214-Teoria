package br.inatel.Utils;

import br.inatel.model.Jogo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<Jogo> readGameCsv(Path csvFilePath){

        List<Jogo> listaDeJogos=new ArrayList<>();

        try{
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<Jogo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Jogo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            listaDeJogos = csvToBean.parse();
        } catch(
                IOException e)

        {
            e.printStackTrace();
        }
        return listaDeJogos;

    }

}
