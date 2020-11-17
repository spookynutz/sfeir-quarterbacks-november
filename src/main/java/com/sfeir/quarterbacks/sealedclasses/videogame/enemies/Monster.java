package com.sfeir.quarterbacks.sealedclasses.videogame.enemies;

import com.sfeir.quarterbacks.sealedclasses.videogame.NonPlayableCharacter;

public sealed class Monster extends NonPlayableCharacter permits Goblin, Orc, Troll {

}
