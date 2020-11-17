package com.sfeir.quarterbacks.records;

public sealed interface Viennoiserie permits Croissant, Chocolatine, ChaussonAuPomme {
}

record ChaussonAuPomme() implements Viennoiserie {}
