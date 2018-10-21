package com.company.pokemons;

import com.company.moves.DisarmingVoice;

public class Jigglypuff extends Igglybuff {
    public Jigglypuff(String name, int level) {
        super(name, level);
        setStats(115,45,20,45,25,20);
        setMove(new DisarmingVoice());
    }
}
