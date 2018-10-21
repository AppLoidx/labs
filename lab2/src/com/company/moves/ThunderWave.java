package com.company.moves;

import ru.ifmo.se.pokemon.*;

/**
 * Thunder Wave paralyzes the opponent.
 *
 * Type	ELECTRIC
 * Category	Status  Status
 * Power	—
 * Accuracy	90
 * @version 1.0
 */
public class ThunderWave extends StatusMove {
    public ThunderWave(){super(Type.ELECTRIC,0,90);}

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().condition(Status.PARALYZE));
    }
}
