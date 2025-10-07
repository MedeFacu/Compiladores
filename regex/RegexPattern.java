/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regex;

import java.util.List;
import modelos.PatternRecord;

/**
 *
 * @author fernando 
 */
public class RegexPattern {
    List<PatternRecord> patrones;

    public RegexPattern() {
        patrones = List.of(
                new PatternRecord("Numero", "^\\d+(\\.\\d+)?$"),
                new PatternRecord("Id", "^[a-zA-Z_][a-zA-Z0-9_]*$")
        );
    }

    public List<PatternRecord> getPatterns() {
        return patrones;
    }
}
