package io.fergueiredo.projektkoronga;

import java.util.Collection;
import java.util.Random;

public class RandomRaffler implements DeckRaffler {
    @Override
    public <T> T raffle(Collection<T> collection) {
        final var random = new Random();
        final int index = random.nextInt(collection.size());

        return collection.stream().toList().get(index);
    }
}
