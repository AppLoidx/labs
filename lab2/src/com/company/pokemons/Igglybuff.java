package com.company.pokemons;

import com.company.moves.DreamEater;
import com.company.moves.ThunderWave;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Igglybuff extends Pokemon {

    public Igglybuff(String name, int level){
        super(name,level);
        setStats(90,30,15,40,20,15);
        setType(Type.NORMAL,Type.FAIRY);
        setMove(new DreamEater(), new ThunderWave());

    }


}
