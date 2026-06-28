package test;

import model.SystemeNavigation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SystemeNavigationTest {
    @Test
    void testStatutInitialEstOK() {
        SystemeNavigation sys = new SystemeNavigation("ILS");
        assertEquals("OK", sys.getStatut());
    }

    @Test
    void testIntegriteSystemeOK() {
        SystemeNavigation sys = new SystemeNavigation("VOR");
        assertTrue(sys.verifierIntegrite());
    }

    @Test
    void testIntegriteSystemeEnPanne() {
        SystemeNavigation sys = new SystemeNavigation("ATC-01");
        sys.setStatut("PANNE");
        assertFalse(sys.verifierIntegrite());
    }

    @Test
    void testStatutInvalideLanceException() {
        SystemeNavigation sys = new SystemeNavigation("RADAR");
        assertThrows(IllegalArgumentException.class, () -> {
            sys.setStatut("INCONNU");
        });
    }
}