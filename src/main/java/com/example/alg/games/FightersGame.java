package com.example.alg.games;

/**
 * Create a function that returns the name of the winner in a fight between two fighters.

 Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.

 Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.

 Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.

 ##Example:

 declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew") => "Lew"

 // Python
 declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"

 Lew attacks Harry; Harry now has 3 health.
 Harry attacks Lew; Lew now has 6 health.
 Lew attacks Harry; Harry now has 1 health.
 Harry attacks Lew; Lew now has 2 health.
 Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.
 */
public class FightersGame {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        if(fighter1.health<=0){
            return fighter2.name;
        }

        if(fighter2.health<=0){
            return fighter1.name;
        }

        Fighter f1 = firstAttacker==fighter1.name? fighter1 : fighter2;
        Fighter f2 = firstAttacker==fighter1.name? fighter2 : fighter1;

        while (true){
            f2.health-=f1.damagePerAttack;
            if(f2.health<=0){
                return f1.name;
            }

            f1.health-=f2.damagePerAttack;
            if(f1.health<=0){
                return f2.name;
            }
        }

    }
}
