package com.company;
import com.company.pokemons.*;
import ru.ifmo.se.pokemon.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Battle b = new Battle();

        b.addAlly(new Guzzlord("Guzzy",1));
        b.addAlly(new Numel("Num",43));
        b.addAlly(new Camerupt("Camel",1));
        b.addFoe(new Igglybuff("Igly",1));
        b.addFoe(new Jigglypuff("Jiggly",11));
        b.addFoe(new Wigglytuff("Wiggly",1));
        b.go();

    }
}
