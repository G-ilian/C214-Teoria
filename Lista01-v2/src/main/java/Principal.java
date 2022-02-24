import br.inatel.Utils.CsvUtils;
import br.inatel.controller.Filtro;
import br.inatel.model.Distribuidora;
import br.inatel.model.Jogo;
import br.inatel.model.Plataforma;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Path caminho=null;

        try {
            caminho= Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        }catch(URISyntaxException e){
            e.printStackTrace();
        }

        List<Jogo> listaDeJogos= CsvUtils.readGameCsv(caminho);

        //Lendo os jogos lançados para PS4
        List<Jogo> listaDeJogosPs4= Filtro.pesquisarPlataforma(listaDeJogos, Plataforma.PS4);

        System.out.println("Agradecemos imensamente por utilizar nosso sistema");
        System.out.println("Número de jogos de PS4: "+listaDeJogosPs4.size());
        System.out.println("############## - Jogos de PS4 - ################");
        listaDeJogosPs4.forEach(ps4-> System.out.println(ps4.getName()));

        List<Jogo> listaDeJogosActivision=Filtro.pesquisarDistribuidora(listaDeJogos, Distribuidora.Activision);
        System.out.println("Número de jogos da Sony: "+listaDeJogosActivision.size());
        System.out.println("############## - Jogos da Activision - ################");
        listaDeJogosActivision.forEach(i-> System.out.println(i.getName()));

    }
}
