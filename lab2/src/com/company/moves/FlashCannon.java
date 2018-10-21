package com.company.moves;

import ru.ifmo.se.pokemon.*;

/**
 * Flash Cannon deals damage and has a 10% chance of lowering the target's Special Defense by one stage.
 *
 * Type	STEEL
 * Category	Special  Special
 * Power	80
 * Accuracy	100
 * @version 1.0
 */
public class FlashCannon extends SpecialMove {
    public FlashCannon(){ super(Type.STEEL,80,100);}

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);

        if (Math.random() < 0.1){
            def.addEffect(new Effect().stat(Stat.SPECIAL_DEFENSE,-1));
        }
    }
}
