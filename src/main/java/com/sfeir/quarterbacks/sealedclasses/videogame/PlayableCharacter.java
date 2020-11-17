package com.sfeir.quarterbacks.sealedclasses.videogame;

public sealed abstract class PlayableCharacter extends Character permits Warrior, Mage, Thief {

    public abstract String whatsMyRole();
}
