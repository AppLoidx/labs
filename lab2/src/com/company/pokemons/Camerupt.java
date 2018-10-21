package com.company.pokemons;

import com.company.moves.FlashCannon;

public class Camerupt extends Numel {
    public Camerupt(String name, int level){
        super(name,level);
        setStats(70,100,70,105,75,40);
        setMove(new FlashCannon());
    }
}
