package com.company.moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

// Check attack mechanic
/**
 * Flamethrower deals damage and has a 10% chance of burning the target.
 *
 * Type	FIRE
 * Category	Special  Special
 * Power	90
 * Accuracy	100
 * @version 1.0
 */
public class Flamethrower extends SpecialMove {
    public Flamethrower(){super(Type.FIRE,90,100);}

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);
        if(Math.random() < 0.1) {
            Effect.burn(def);
        }
    }
}
