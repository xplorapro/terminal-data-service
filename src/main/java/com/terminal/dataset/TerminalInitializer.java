package com.terminal.dataset;

import org.springframework.boot.CommandLineRunner;
import java.text.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TerminalInitializer implements CommandLineRunner {

    public static Date date = null;
    public static DateFormat dateFormat = null;
	private final TerminalService terminalService;

    public TerminalInitializer(TerminalService terminalService) {
        this.terminalService = terminalService;
    	dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	date = new Date();
    }

    @Override
    public void run(String... args) throws Exception {

        List<Terminal> initialTerminals = List.of(
                new Terminal(
                        "LAS", 3, 567890L, 21.45,
                        new Terminal.Stats(18.75, 4.2, 82.5, dateFormat.format(date), true),
                        List.of("B1", "B2", "B3")
                ),
                new Terminal(
                        "MCO", 1, 456789L, 18.23,
                        new Terminal.Stats(22.1, 4.1, 85.3, dateFormat.format(date), true),
                        List.of("A1", "A2", "A3")
                ),
                new Terminal(
                        "ORD", 2, 678901L, 15.67,
                        new Terminal.Stats(19.5, 4.3, 80.8, dateFormat.format(date), true),
                        List.of("C1", "C2", "C3")
                ),
                new Terminal(
                        "DFW", 4, 345678L, 25.12,
                        new Terminal.Stats(17.8, 4.0, 78.9, dateFormat.format(date), true),
                        List.of("D1", "D2", "D3")
                ),
                new Terminal(
                        "ATL", 5, 789012L, 20.34,
                        new Terminal.Stats(20.25, 4.4, 83.6, dateFormat.format(date), true),
                        List.of("E1", "E2", "E3")
                ),
                new Terminal(
                        "DEN", 1, 456789L, 12.87,
                        new Terminal.Stats(18.9, 4.2, 81.5, dateFormat.format(date), true),
                        List.of("F1", "F2", "F3")
                ),
                new Terminal(
                        "SLT", 2, 567890L, 16.54,
                        new Terminal.Stats(21.35, 4.1, 84.2, dateFormat.format(date), true),
                        List.of("G1", "G2", "G3")
                ),
                new Terminal(
                        "CLT", 3, 345678L, 22.1,
                        new Terminal.Stats(17.65, 4.0, 79.8, dateFormat.format(date), true),
                        List.of("H1", "H2", "H3")
                ),
                new Terminal(
                        "LAS", 1, 456789L, 28.35,
                        new Terminal.Stats(19.2, 4.3, 82.1, dateFormat.format(date), true),
                        List.of("I1", "I2", "I3")
                ),
                new Terminal(
                        "MIA", 2, 678901L, 26.78,
                        new Terminal.Stats(20.5, 4.2, 83.4, dateFormat.format(date), true),
                        List.of("J1", "J2", "J3")
                ),
                new Terminal(
                        "PHX", 3, 345678L, 24.56,
                        new Terminal.Stats(18.1, 4.1, 80.5, dateFormat.format(date), true),
                        List.of("K1", "K2", "K3")
                ),
                new Terminal(
                        "SEA", 1, 456789L, 14.32,
                        new Terminal.Stats(21.75, 4.4, 85.0, dateFormat.format(date), true),
                        List.of("L1", "L2", "L3")
                ),
                new Terminal(
                        "IAH", 2, 567890L, 23.89,
                        new Terminal.Stats(19.45, 4.3, 82.8, dateFormat.format(date), true),
                        List.of("M1", "M2", "M3")
                ),
                new Terminal(
                        "MSP", 3, 345678L, 10.56,
                        new Terminal.Stats(18.6, 4.2, 81.2, dateFormat.format(date), true),
                        List.of("N1", "N2", "N3")
                ),
                new Terminal(
                        "KCI", 3, 345678L, 10.56,
                        new Terminal.Stats(18.6, 4.2, 81.2, dateFormat.format(date), true),
                        List.of("N1", "N2", "N3")
                )
        );

        initialTerminals.forEach(terminalService::addTerminal);
    }
}