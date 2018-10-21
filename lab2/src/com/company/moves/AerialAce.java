package com.company.moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

/**
 * Aerial Ace deals damage and ignores changes to the Accuracy and Evasion stats.
 *
 * Type	FLYING
 * Category	Physical  Physical
 * Power	60
 * Accuracy	∞
 * @version 1.0
 */
public class AerialAce extends PhysicalMove {
    public AerialAce(){super(Type.FLYING,60,100);}

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        return false;
    }

}
