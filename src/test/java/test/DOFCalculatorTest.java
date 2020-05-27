package test;

import camera.model.DOFCalculator;
import camera.model.Lens;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DOFCalculatorTest {
    // Circle of Confusion
    private static final double COC = 0.029;

    // List of lens
    public Lens canonLen = new Lens("Canon", 1.8, 50);
    public Lens tamronLen = new Lens("Tamron", 2.8, 90);
    public Lens sigmaLen = new Lens("Sigma", 2.8, 200);

    @Test
    void hyperFocalDist() {
        double hyperFocal1 = DOFCalculator.hyperFocalDist(canonLen, 1.8, COC);
        double hyperFocal2 = DOFCalculator.hyperFocalDist(tamronLen, 2.8, COC);
        double hyperFocal3 = DOFCalculator.hyperFocalDist(sigmaLen, 11, COC);
        assertEquals(47.89,hyperFocal1/1000, 0.005);
        assertEquals(99.75, hyperFocal2/1000, 0.005);
        assertEquals(125.39, hyperFocal3/1000, 0.005);
    }

    @Test
    void nearFocalPoint() {
        double nearFocal1 = DOFCalculator.nearFocalPoint(canonLen, 1100, 1.8, COC);
        double nearFocal2 = DOFCalculator.nearFocalPoint(tamronLen, 2000, 2.8, COC);
        double nearFocal3 = DOFCalculator.nearFocalPoint(sigmaLen,15000, 11, COC);
        assertEquals(1.08, nearFocal1/1000, 0.005);
        assertEquals(1.96, nearFocal2/1000, 0.005);
        assertEquals(13.42, nearFocal3/1000, 0.005);
    }

    @Test
    void farFocalPoint() {
        double farFocal1 = DOFCalculator.farFocalPoint(canonLen, 1100, 1.8, COC);
        double farFocal2 = DOFCalculator.farFocalPoint(tamronLen, 2000, 2.8, COC);
        double farFocal3 = DOFCalculator.farFocalPoint(sigmaLen,15000, 11, COC);
        assertEquals(1.12, farFocal1/1000, 0.005);
        assertEquals(2.04, farFocal2/1000, 0.005);
        assertEquals(17.01, farFocal3/1000, 0.005);
    }

    @Test
    void depthOfField() {
        double depth1 = DOFCalculator.depthOfField(canonLen, 1100, 1.8, COC);
        double depth2 = DOFCalculator.depthOfField(tamronLen, 2000, 2.8, COC);
        double depth3 = DOFCalculator.depthOfField(sigmaLen,15000, 11, COC);
        assertEquals(0.05, depth1/1000, 0.005);
        assertEquals(0.08, depth2/1000, 0.005);
        assertEquals(3.59, depth3/1000, 0.005);
    }
}