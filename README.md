# Implementation of PDA with Java Tokeniser and Parser

This repository contains a Java tokeniser and parser which demonstrate the
implementation of formal grammar and a pushdown automaton.

The example grammar has the following production rules:
- $S \to \epsilon$
- $S \to aSb$

The corresponding pushdown automaton as define with the following transitions:
- $\delta (S_{0}, \epsilon, Z) \to S_{3}/Z$
- $\delta (S_{0}, a, Z) \to S_{1}/aZ$
- $\delta (S_{1}, a, a) \to S_{1}/aa$
- $\delta (S_{1}, b, a) \to S_{2}/\epsilon$
- $\delta (S_{2}, b, a) \to S_{2}/\epsilon$
- $\delta (S_{3}, \epsilon, Z) \to S_{3}/\epsilon$

@author: Alvin Tang <dev@alvinylt.net>

@last-updated: 2023-04-29
