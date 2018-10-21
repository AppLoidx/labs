package com.company.pokemons;
import com.company.moves.*;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Guzzlord extends Pokemon {

    public Guzzlord(String name, int level){
        super(name,level);
        setStats(223,101,53,97,53,43);
        setType(Type.DARK, Type.DRAGON);
        setMove(new Rest(), new VacuumWave(), new CalmMind(), new AerialAce());
    }

}
