package com.booking.certificacion.utils;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

public class ManualTest {

    private ManualTest() {
        throw new IllegalStateException("Interaction with the tester");
    }

    public static void validate(String step, String nameScenario) {
        String reason = "";
        String[] options = {"No", "Yes"};
        int selectedNumericOption = JOptionPane.showOptionDialog(new JFrame(),
                "The step \"" + step + "\" was executed correctly?", nameScenario, JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        boolean selectedOption = (selectedNumericOption == 1);
        if (!selectedOption) {
            reason = JOptionPane.showInputDialog("Enter the reason why the test did not run correctly");
        }
        assertTrue(reason, selectedOption);
    }
}
