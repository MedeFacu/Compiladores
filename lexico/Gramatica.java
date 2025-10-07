/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexico;

import java.util.ArrayList;
import java.util.List;
import modelos.ModeloGramatica;

/**
 *
 * @author Michelle
 */
public class Gramatica {
    public Gramatica() {
        gramatica = new ArrayList<>();
        initGramatica();
    }

    private List<ModeloGramatica> gramatica;

    public void initGramatica() {
       gramatica.add(new ModeloGramatica(List.of("int", "bool", "void", "if", "else", "while", "for", "return", "break", "continue", "true", "false"), "Palabra reservada"));
       gramatica.add(new ModeloGramatica(List.of("[", "]", "(", ")", "{", "}", ","), "Simbolo"));
       gramatica.add(new ModeloGramatica(List.of(";"), "Delimitador"));
       gramatica.add(new ModeloGramatica(List.of("+", "-", "*", "/", "%", "==", "!=", "<", ">", "<=", ">=", "&&", "||", "!"), "Operador"));
       gramatica.add(new ModeloGramatica(List.of("="), "Asignacion"));

    }
    
    public List<ModeloGramatica> GetGramatica() {
        return gramatica;
    }
}


