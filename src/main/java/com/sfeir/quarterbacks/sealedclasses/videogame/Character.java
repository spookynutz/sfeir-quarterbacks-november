package com.sfeir.quarterbacks.sealedclasses.videogame;

public sealed abstract class Character permits PlayableCharacter, NonPlayableCharacter {
}
