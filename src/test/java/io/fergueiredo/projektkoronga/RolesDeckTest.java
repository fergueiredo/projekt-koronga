package io.fergueiredo.projektkoronga;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RolesDeckTest {
    @Test
    void givenNewRolesDeck_whenGettingAvailableRoles_thenPhysicianShouldExists() {
        RolesDeck rolesDeck = new RolesDeck();

        Set<Role> roles = rolesDeck.availableRoles();

        assertThat(roles).contains(Role.PHYSICIAN);
    }

    @Test
    void givenNewRolesDeck_whenGettingAvailableRoles_thenQuarantineExpertShouldExists() {
        RolesDeck rolesDeck = new RolesDeck();

        Set<Role> roles = rolesDeck.availableRoles();

        assertThat(roles).contains(Role.QUARANTINE_EXPERT);
    }
}
