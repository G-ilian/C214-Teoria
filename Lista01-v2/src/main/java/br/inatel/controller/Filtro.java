package br.inatel.controller;


import br.inatel.model.Distribuidora;
import br.inatel.model.Jogo;
import br.inatel.model.Plataforma;

import java.util.ArrayList;
import java.util.List;

/*
Esta classe objetiva:
1. Filtrar no CSV plataformas.
2. Filtrar no CSV distribuídoras.
 */
public class Filtro {
    public static List<Jogo> pesquisarPlataforma(List<Jogo> jogos, Plataforma p){
        List<Jogo> plataformas=new ArrayList<>();

        jogos.stream().filter((jogo ->jogo.getPlatform().equals(p.name()))).forEach(jogo->plataformas.add(jogo));

        return plataformas;
    }

    public static List<Jogo> pesquisarDistribuidora(List<Jogo> jogos, Distribuidora d){
        List<Jogo> distribuidoras=new ArrayList<>();

        jogos.stream().filter((jogo ->jogo.getPublisher().replaceAll("\\s+","").equals(d.name()))).forEach(jogo->distribuidoras.add(jogo));

        return distribuidoras;
    }
}
