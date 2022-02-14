package io.fergueiredo.projektkoronga;

import java.util.HashSet;
import java.util.Set;

public class RolesDeck {
    private final DeckRaffler raffler;
    private final Set<Role> availableRoles = new HashSet<>(Set.of(Role.values()));

    public RolesDeck() {
        this.raffler = new RandomRaffler();
    }

    public RolesDeck(DeckRaffler raffler) {
        this.raffler = raffler;
    }

    public Set<Role> availableRoles() {
        return availableRoles;
    }

    public Role raffle() {
        final var raffled = raffler.raffle(availableRoles);

        availableRoles.remove(raffled);

        return raffled;
    }
}
