package com.sfeir.quarterbacks.patternmatching;

import com.sfeir.quarterbacks.sealedclasses.videogame.Mage;
import com.sfeir.quarterbacks.sealedclasses.videogame.PlayableCharacter;
import com.sfeir.quarterbacks.sealedclasses.videogame.Thief;
import com.sfeir.quarterbacks.sealedclasses.videogame.Warrior;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternMatchingInstanceOfTest {

    @Test
    void should_be_a_warrior_the_way_we_used_to_do_it(){
        assertThat(determinePlayerRole(new Warrior())).isEqualTo("I am a Warrior !");
    }

    @Test
    void should_be_a_mage_the_way_we_used_to_do_it(){
        assertThat(determinePlayerRole(new Mage())).isEqualTo("I am a Mage !");
    }

    @Test
    void should_be_a_thief_the_way_we_used_to_do_it(){
        assertThat(determinePlayerRole(new Thief())).isEqualTo("I am a Thief !");
    }

    private String determinePlayerRole(Object object) {
        if (object instanceof Warrior) {
            Warrior warrior = (Warrior) object;
            return warrior.whatsMyRole();
        } else if (object instanceof Mage){
            Mage mage = (Mage) object;
            return mage.whatsMyRole();
        } else if (object instanceof Thief) {
            Thief thief = (Thief) object;
            return thief.whatsMyRole();
        } else {
            return "This is not a player role";
        }
    }

    @Test
    void should_be_a_warrior_with_less_boilerplate(){
        assertThat(determinePlayerRoleWithLessBoilerplate(new Warrior())).isEqualTo("I am a Warrior !");
    }
    @Test
    void should_be_a_mage_with_less_boilerplate(){
        assertThat(determinePlayerRoleWithLessBoilerplate(new Mage())).isEqualTo("I am a Mage !");
    }

    @Test
    void should_be_a_thief_with_less_boilerplate(){
        assertThat(determinePlayerRoleWithLessBoilerplate(new Thief())).isEqualTo("I am a Thief !");
    }

    private String determinePlayerRoleWithLessBoilerplate(Object player) {
        if (player instanceof Warrior) {
            // return player.whatsMyRole();
            return ((Warrior) player).whatsMyRole();
        } else if (player instanceof Mage) {
            // return player.whatsMyRole();
            return ((Mage) player).whatsMyRole();
        } else if (player instanceof Thief) {
            // return player.whatsMyRole();
            return ((Thief) player).whatsMyRole();
        } else {
            return "This is not a player role";
        }
    }

    public void drawWeapon(PlayableCharacter playableCharacter) {
        if (playableCharacter instanceof Warrior) {
            ((Warrior) playableCharacter).sword();
        } else if (playableCharacter instanceof Mage) {
            ((Mage) playableCharacter).staff();
        } else if (playableCharacter instanceof Thief) {
            ((Thief) playableCharacter).dagger();
        } else {
            System.out.println("This is not a playable character");
        }

//      if (playableCharacter instanceof Warrior) {
//          playableCharacter.sword();
//      } else if (playableCharacter instanceof Mage) {
//          playableCharacter.staff();
//      } else if (playableCharacter instanceof Thief) {
//          playableCharacter.dagger();
//      }

//      switch (playableCharacter) {
//          case Warrior w -> w.sword();
//          case Mage m -> m.staff();
//          case Thief t -> t.dagger();
//      }
    }
}
