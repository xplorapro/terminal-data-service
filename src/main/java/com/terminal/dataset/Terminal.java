package com.terminal.dataset;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {
    private String airport;
    private Integer terminalNumber;
    private Long passengerCount;
    private Double temperature;
    private Stats stats;
    private List<String> gates;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Stats {
        private Double avgWaitTime;
        private Double satisfaction;
        private Double occupancyRate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private String lastChecked;
        private Boolean isOpen;
    }
}