package com.company.moves;

import ru.ifmo.se.pokemon.*;

/**
 * Calm Mind raises the user's Special Attack and Special Defense by one stage each.
 * Stats can be raised to a maximum of +6 stages each.
 *
 * Type	PSYCHIC
 * Category	Status  Status
 * Power	—
 * Accuracy	—
 * @version 1.0
 */
public class CalmMind extends StatusMove {
    public CalmMind(){
        super(Type.PSYCHIC,0,0);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        p.addEffect(new Effect().stat(Stat.SPECIAL_ATTACK,1));
        p.addEffect(new Effect().stat(Stat.SPECIAL_DEFENSE,1));
    }

}
