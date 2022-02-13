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
}
