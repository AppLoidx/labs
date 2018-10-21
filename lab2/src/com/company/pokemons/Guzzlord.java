package com.company.pokemons;


import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Guzzlord extends Pokemon {

    public Guzzlord(String name, int level){
        super(name,level);
        setStats(223,101,53,97,53,43);
        setType(Type.DARK, Type.DRAGON);
        setMove(new Rest(), new VacuumWave(), new CalmMind(), new AerialAce());
    }

    // MOVES

    class Rest extends com.company.moves.Rest {}
    class VacuumWave extends com.company.moves.VacuumWave {}
    class CalmMind extends com.company.moves.CalmMind {}
    class AerialAce extends com.company.moves.AerialAce {}

}
