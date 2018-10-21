package com.company.moves;

import ru.ifmo.se.pokemon.*;

/**
 * Will-O-Wisp causes the target to become burned, if it hits.
 * Burned Pokémon lose 1⁄8 of their maximum HP each turn and their Attack is decreased by 50%.
 *
 * Type	FIRE
 * Category	Status  Status
 * Power	—
 * Accuracy	85
 * @version 1.0
 */
public class WillOWisp extends StatusMove {
    public WillOWisp(){
        super(Type.FIRE, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (!p.hasType(Type.FIRE)) {
            Effect e = (new Effect()).condition(Status.BURN).turns(-1);
            e.stat(Stat.ATTACK, -2).stat(Stat.HP, (int)p.getStat(Stat.HP) / 8);
            p.setCondition(e);
        }
    }
}
