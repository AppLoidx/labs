package com.company.moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;


/**
 * Disarming Voice deals damage and ignores changes to the Accuracy and Evasion stats.
 *
 * Type	FAIRY
 * Category	Special  Special
 * Power	40
 * Accuracy	∞
 */
public class DisarmingVoice extends SpecialMove {
    public DisarmingVoice(){super(Type.FAIRY,40,100);}

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true;
    }
}
