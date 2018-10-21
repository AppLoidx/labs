package com.company.moves;

import ru.ifmo.se.pokemon.*;

/**
 * User sleeps for 2 turns, but user is fully healed.
 *
 * Type	PSYCHIC
 * Category	Status  Status
 * Power	—
 * Accuracy	—
 * @version 1.0
 */
public class Rest extends StatusMove {
    public Rest(){
        super(Type.PSYCHIC,0,0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);
        Effect e = new Effect();
        p.addEffect(e.condition(Status.SLEEP).turns(2));

        // TODO: Test this HP RESTORE code line
        p.addEffect(new Effect().stat(Stat.HP,(int)(p.getHP() - p.getStat(Stat.HP))));
    }
}
