package com.company.pokemons;

public class Camerupt extends Numel {
    public Camerupt(String name, int level){
        super(name,level);
        setStats(70,100,70,105,75,40);
        setMove(new Flamethrower(), new Rest(), new WillOWisp(), new FlashCannon());
    }

    class FlashCannon extends com.company.moves.FlashCannon{}

}
