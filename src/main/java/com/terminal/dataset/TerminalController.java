package com.terminal.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terminals")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @GetMapping
    public ResponseEntity<List<Terminal>> getAllTerminals() {
        return ResponseEntity.ok(terminalService.getAllTerminals());
    }

    @GetMapping("/{airport}/{terminalNumber}")
    public ResponseEntity<Terminal> getTerminal(
            @PathVariable String airport,
            @PathVariable Integer terminalNumber
    ) {
        Terminal terminal = terminalService.getTerminalByAirportAndNumber(airport, terminalNumber);
        if (terminal != null) {
            return ResponseEntity.ok(terminal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Terminal> addTerminal(@RequestBody Terminal terminal) {
        Terminal createdTerminal = terminalService.addTerminal(terminal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTerminal);
    }

    @PutMapping("/{airport}/{terminalNumber}")
    public ResponseEntity<Terminal> updateTerminal(
            @PathVariable String airport,
            @PathVariable Integer terminalNumber,
            @RequestBody Terminal terminal
    ) {
        Terminal updatedTerminal = terminalService.updateTerminal(airport, terminalNumber, terminal);
        if (updatedTerminal != null) {
            return ResponseEntity.ok(updatedTerminal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PatchMapping("/{airport}/{terminalNumber}")
    public ResponseEntity<Terminal> patchTerminal(
            @PathVariable String airport,
            @PathVariable Integer terminalNumber,
            @RequestBody Terminal terminal
    ) {
        Terminal existingTerminal = terminalService.getTerminalByAirportAndNumber(airport, terminalNumber);
        if (existingTerminal != null) {
            if (terminal.getPassengerCount() != null) {
                existingTerminal.setPassengerCount(terminal.getPassengerCount());
            }
            if (terminal.getTemperature() != null) {
                existingTerminal.setTemperature(terminal.getTemperature());
            }
            if (terminal.getStats() != null) {
                existingTerminal.setStats(terminal.getStats());
            }
            if (terminal.getGates() != null) { 
                existingTerminal.setGates(terminal.getGates()); // Update the gates list
            }
            return ResponseEntity.ok(existingTerminal); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{airport}/{terminalNumber}")
    public ResponseEntity<Void> deleteTerminal(
            @PathVariable String airport,
            @PathVariable Integer terminalNumber
    ) {
        terminalService.deleteTerminal(airport, terminalNumber);
        return ResponseEntity.noContent().build();
    }
}