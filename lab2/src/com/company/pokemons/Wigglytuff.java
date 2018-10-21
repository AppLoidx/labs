package com.company.pokemons;

import com.company.moves.PlayRough;

public class Wigglytuff extends Jigglypuff {
    public Wigglytuff(String name, int level) {
        super(name, level);
        setStats(140,70,45,85,50,45);
        setMove(new PlayRough());
    }
}
