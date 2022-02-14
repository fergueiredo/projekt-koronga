package io.fergueiredo.projektkoronga;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

    @Test
    void givenNewRolesDeck_whenGettingAvailableRoles_thenOperationExpertShouldExists() {
        RolesDeck rolesDeck = new RolesDeck();

        Set<Role> roles = rolesDeck.availableRoles();

        assertThat(roles).contains(Role.OPERATION_EXPERT);
    }

    @Test
    void givenNewRolesDeck_whenGettingAvailableRoles_thenScienceCommunicatorShouldExists() {
        RolesDeck rolesDeck = new RolesDeck();

        Set<Role> roles = rolesDeck.availableRoles();

        assertThat(roles).contains(Role.SCIENCE_COMMUNICATOR);
    }

    @Test
    void givenNewRolesDeck_whenGettingAvailableRoles_thenLogisticExpertShouldExists() {
        RolesDeck rolesDeck = new RolesDeck();

        Set<Role> roles = rolesDeck.availableRoles();

        assertThat(roles).contains(Role.LOGISTIC_EXPERT);
    }

    @Test
    void givenNewRolesDeck_whenGettingAvailableRoles_thenScientistShouldExists() {
        RolesDeck rolesDeck = new RolesDeck();

        Set<Role> roles = rolesDeck.availableRoles();

        assertThat(roles).contains(Role.SCIENTIST);
    }

    @Test
    void givenNewRolesDeck_whenGettingAvailableRoles_thenContingencyPlannerShouldExists() {
        RolesDeck rolesDeck = new RolesDeck();

        Set<Role> roles = rolesDeck.availableRoles();

        assertThat(roles).contains(Role.CONTINGENCY_PLANNER);
    }

    @Test
    void givenNewRolesDeck_whenRafflingRole_thenPhysicianIsRaffled() {
        RolesDeck rolesDeck = new RolesDeck(new MyRaffler<>(Role.PHYSICIAN));

        Role role = rolesDeck.raffle();

        assertThat(role).isEqualTo(Role.PHYSICIAN);
    }

    @Test
    void givenNewRolesDeck_whenRafflingRole_thenQuarantineExpertIsRaffled() {
        RolesDeck rolesDeck = new RolesDeck(new MyRaffler<>(Role.QUARANTINE_EXPERT));

        Role role = rolesDeck.raffle();

        assertThat(role).isEqualTo(Role.QUARANTINE_EXPERT);
    }

    @Test
    void givenAlreadyRaffledPhysician_whenGettingAvailableRoles_thenPhysicianShouldNotExists() {
        RolesDeck rolesDeck = new RolesDeck(new MyRaffler<>(Role.PHYSICIAN));

        Role raffledPhysician = rolesDeck.raffle();

        assertThat(raffledPhysician).isEqualTo(Role.PHYSICIAN);

        assertThat(rolesDeck.availableRoles()).doesNotContain(Role.PHYSICIAN);
    }

    @Test
    void givenRaffledRoleFromRandomRaffler_whenGettingAvailableRoles_then6AvailableRolesLeftAndRaffledNotPresent() {
        RolesDeck rolesDeck = new RolesDeck();

        Role raffled = rolesDeck.raffle();

        assertThat(rolesDeck.availableRoles())
            .hasSize(6)
            .doesNotContain(raffled);
    }

    @Test
    void givenAlreadyRaffledPhysician_whenRafflingPhysicianAgain_thenIllegalStateExceptionShouldBeThrown() {
        RolesDeck rolesDeck = new RolesDeck(new MyRaffler<>(Role.PHYSICIAN));

        Role raffled = rolesDeck.raffle();
        assertThat(raffled).isEqualTo(Role.PHYSICIAN);

        var e = assertThrows(IllegalStateException.class, () -> rolesDeck.raffle());

        assertThat(e.getMessage()).isEqualTo("Desired item was not found.");
    }

    record MyRaffler<T>(T desired) implements DeckRaffler {

        @Override
        public <T> T raffle(Collection<T> collection) {
            return collection.stream().filter(item -> item.equals(desired)).findFirst().orElseThrow(() -> new IllegalStateException("Desired item was not found."));
        }
    }
}
