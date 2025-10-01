/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexico;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import modelos.ModeloGramatica;
import modelos.PatternRecord;
import modelos.Token;
import regex.RegexPattern;

/**
 *
 * @author jesus
 */
public class TokenGenerator {

    public static List<Token> getTokens(String texto) {
        List<Token> tokens = new ArrayList<>();
        RegexPattern regex = new RegexPattern();
        List<PatternRecord> patrones = regex.getPatterns();
        Gramatica g = new Gramatica();

        String[] lineas = texto.split("\\n");

        for (int i = 0; i < lineas.length; i++) {
            String lineaTexto = lineas[i].trim();
            if (lineaTexto.isEmpty()) continue;

            String[] palabras = lineaTexto.split("\\s+");

            int columnaActual = 1;
            for (String palabra : palabras) {
                boolean encontrado = false;

                for (ModeloGramatica regla : g.GetGramatica()) {
                    if (regla.getValores().contains(palabra)) {
                        tokens.add(new Token(regla.getGrupo(), palabra, i + 1, columnaActual));
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    for (PatternRecord patron : patrones) {
                        if (Pattern.matches(patron.getRegex(), palabra)) {
                            tokens.add(new Token(patron.getTipo(), palabra, i + 1, columnaActual));
                            encontrado = true;
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    tokens.add(new Token("lexema no permitido", palabra, i + 1, columnaActual));
                }

                columnaActual += palabra.length() + 1;
            }
        }
        return tokens;
    }
}
