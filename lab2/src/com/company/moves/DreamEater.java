package com.company.moves;

import ru.ifmo.se.pokemon.*;

/**
 * Dream Eater deals damage only on sleeping foes and the user will recover 50% of the HP drained.
 *
 * Type	PSYCHIC
 * Category	Special  Special
 * Power	100
 * Accuracy	100
 * @version 1.0
 */
public class DreamEater extends StatusMove {
    private final double BASE_POWER;
    public DreamEater(){
        super(Type.PSYCHIC, 100, 100);
        BASE_POWER = 100;
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (p.getCondition() == Status.SLEEP){
            this.power = 0;
        }
        else{
            this.power = BASE_POWER;
        }
    }

    //TODO: set max HP
    @Override
    protected void applySelfEffects(Pokemon p) {
        int heal;
        if (p.getHP()/2 > p.getStat(Stat.HP)){
            heal = (int) (p.getStat(Stat.HP) - p.getHP());
        }else {heal = (int) p.getHP()/2;}
        Effect healEffect = new Effect().stat(Stat.HP,-heal);
        p.addEffect(healEffect);
    }
}