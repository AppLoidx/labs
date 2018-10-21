package com.company;
import com.company.pokemons.*;
import ru.ifmo.se.pokemon.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Guzzlord guzzlord = new Guzzlord("Guzzy",5);
        Numel numel = new Numel("Num",10);
        Igglybuff igglybuff = new Igglybuff("Igly",20);
        Jigglypuff jigglypuff = new Jigglypuff("Jiggly",30);
        Wigglytuff wigglytuff = new Wigglytuff("Wiggly",12);
        Camerupt camerupt = new Camerupt("Camel",18);

        Battle b = new Battle();

        b.addAlly(guzzlord);
        b.addAlly(numel);
        b.addAlly(camerupt);
        b.addFoe(igglybuff);
        b.addFoe(wigglytuff);
        b.addFoe(jigglypuff);

        b.go();
    }
}
