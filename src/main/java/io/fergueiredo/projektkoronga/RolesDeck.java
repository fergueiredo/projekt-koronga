package io.fergueiredo.projektkoronga;

import java.util.Set;

public class RolesDeck {
    public Set<Role> availableRoles() {
        return Set.of(Role.PHYSICIAN);
    }
}
