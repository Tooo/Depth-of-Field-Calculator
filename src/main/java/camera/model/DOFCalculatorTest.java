package camera.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DOFCalculatorTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void hyperFocalDist() {
        double hyperFocal = DOFCalculator.hyperFocalDist(50, 1.8, 0.029);
        hyperFocal = (Math.round(hyperFocal/10));
        assertEquals(47.89,hyperFocal/100);
    }

    @Test
    void nearFocalPoint() {
        double nearFocal = DOFCalculator.nearFocalPoint(47892.72, 1100, 50);
        nearFocal = (Math.round(nearFocal/10));
        assertEquals(1.08, nearFocal/100);
    }

    @Test
    void farFocalPoint() {
        double farFocal = DOFCalculator.farFocalPoint(47892.72, 1100, 50);
        farFocal = (Math.round(farFocal/10));
        assertEquals(1.12, farFocal/100);
    }

    @Test
    void depthOfField() {
        double dOF = DOFCalculator.depthOfField(1.12, 1.08);
        dOF = (Math.round(dOF*100));
        assertEquals(0.04, dOF/100);
    }
}