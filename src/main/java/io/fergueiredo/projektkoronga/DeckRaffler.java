package io.fergueiredo.projektkoronga;

import java.util.Collection;

public interface DeckRaffler {
    <T> T raffle(Collection<T> collection);
}
