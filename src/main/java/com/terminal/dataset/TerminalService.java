package com.terminal.dataset;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TerminalService {

    private static List<Terminal> terminals = new ArrayList<>();
    static TerminalInitializer terminalInitializer=new TerminalInitializer(null);
    
    static {
        terminals.add(new Terminal(
                "SFO", 2, 847592L, -2.75,
                new Terminal.Stats(23.45, 4.8, 78.5, TerminalInitializer.dateFormat.format(TerminalInitializer.date), true),
                List.of("A1", "A2", "A3")
        ));

        terminals.add(new Terminal(
                "LAX", 3, 567890L, 21.45,
                new Terminal.Stats(18.75, 4.2, 82.5, TerminalInitializer.dateFormat.format(TerminalInitializer.date), true),
                List.of("B1", "B2", "B3")
        ));
    }

    public List<Terminal> getAllTerminals() {
        return terminals;
    }

    public Terminal getTerminalByAirportAndNumber(String airport, Integer terminalNumber) {
        return terminals.stream()
                .filter(t -> t.getAirport().equals(airport) && t.getTerminalNumber().equals(terminalNumber))
                .findFirst()
                .orElse(null);
    }

    public Terminal addTerminal(Terminal terminal) {
        terminals.add(terminal);
        return terminal;
    }

    public Terminal updateTerminal(String airport, Integer terminalNumber, Terminal terminal) {
        Terminal existingTerminal = getTerminalByAirportAndNumber(airport, terminalNumber);
        if (existingTerminal != null) {
            existingTerminal.setPassengerCount(terminal.getPassengerCount());
            existingTerminal.setTemperature(terminal.getTemperature());
            existingTerminal.setStats(terminal.getStats());
            existingTerminal.setGates(terminal.getGates());
        }
        return existingTerminal;
    }

    public void deleteTerminal(String airport, Integer terminalNumber) {
        terminals.removeIf(t -> t.getAirport().equals(airport) && t.getTerminalNumber().equals(terminalNumber));
    }
}