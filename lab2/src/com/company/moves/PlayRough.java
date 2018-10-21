package com.company.moves;

import ru.ifmo.se.pokemon.*;

//TODO: Check the Deals damage term
/**
 * Play Rough deals damage and has a 10% chance of lowering the target's Attack by one stage.
 *
 * Type	FAIRY
 * Category	Physical  Physical
 * Power	90
 * Accuracy	90
 * @version 1.0
 */
public class PlayRough extends PhysicalMove {
    public PlayRough(){super(Type.FAIRY,90,90);}

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1){
            p.addEffect(new Effect().stat(Stat.ATTACK, -1));
        }
    }
}
