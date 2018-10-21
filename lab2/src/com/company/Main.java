package com.company;
import com.company.pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {

        Battle b = new Battle();

        b.addAlly(new Wigglytuff("Wiggly",1));
        b.addAlly(new Camerupt("Camel",1));
        b.addAlly(new Numel("Num",43));
        b.addFoe(new Guzzlord("Guzzy",1));
        b.addFoe(new Igglybuff("Igly",1));
        b.addFoe(new Jigglypuff("Jiggly",11));

        b.go();
    }
}
