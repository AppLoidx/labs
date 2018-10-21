package com.company.moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;


/**
 * Vacuum Wave deals damage and has a priority of +1.
 *
 * Type	FIGHTING
 * Category	Special  Special
 * Power	40
 * Accuracy	100
 * @version 1.0
 */
public class VacuumWave extends SpecialMove {
    public VacuumWave(){
        super(Type.FIGHTING,40,100);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        this.priority++;
    }
}
