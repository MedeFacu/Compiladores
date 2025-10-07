package sintactico;

import java.util.List;

import modelos.Token;

public class Parser {
    private List<Token> tokens;
    private int index = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token actual() {
        return index < tokens.size() ? tokens.get(index) : new Token("EOF", "", -1, -1);
    }

    private void match(String esperado) {
        Token tok = actual();
        if (tok.getLexema().equals(esperado)) {
            index++;
        } else {
            error("se esperaba '" + esperado + "'", tok);
        }
    }

    private void matchGrupo(String esperadoGrupo) {
        Token tok = actual();
        if (tok.getGrupo().equalsIgnoreCase(esperadoGrupo)) {
            index++;
        } else {
            error("se esperaba un token del grupo '" + esperadoGrupo + "'", tok);
        }
    }

    private void error(String mensaje, Token encontrado) {
        throw new RuntimeException("Error de sintaxis en linea " + encontrado.getLinea() +
            ", columna " + encontrado.getColumna() + ": " + mensaje +
            ", se encontro '" + encontrado.getLexema() + "'");
    }

    // --- Punto de entrada ---
    public void analizar() {
        programa();
        if (index < tokens.size()) {
            error("fin del archivo", actual());
        }
    }

    // --- Gramática ---
    private void programa() {
        funciones();
    }

    private void funciones() {
        while (actual().getLexema().equals("def")) {
            funcion();
        }
    }

    private void funcion() {
        match("def");
        matchGrupo("id");   // nombre de la función
        match("(");
        match(")");
        match(":");
        bloque();
    }

    private void bloque() {
        declaraciones();
        sentencias();
    }

    private void declaraciones() {
        while (actual().getGrupo().equalsIgnoreCase("id")) {
            declaracion();
        }
    }

    private void declaracion() {
        matchGrupo("id");
        match("=");
        expresion();
        match(";");
    }

    private void sentencias() {
        while (actual().getLexema().equals("print") || actual().getLexema().equals("call")) {
            sentencia();
        }
    }

    private void sentencia() {
        if (actual().getLexema().equals("print")) {
            match("print");
            match("(");
            expresion();
            match(")");
            match(";");
        } else if (actual().getLexema().equals("call")) {
            match("call");
            matchGrupo("id");
            match("(");
            match(")");
            match(";");
        } else {
            error("se esperaba 'print' o 'call'", actual());
        }
    }

    private void expresion() {
        termino();
        while (actual().getLexema().equals("+") || actual().getLexema().equals("-")) {
            match(actual().getLexema());
            termino();
        }
    }

    private void termino() {
        factor();
        while (actual().getLexema().equals("*") || actual().getLexema().equals("/")) {
            match(actual().getLexema());
            factor();
        }
    }

    private void factor() {
        Token t = actual();
        if (t.getGrupo().equalsIgnoreCase("id")) {
            matchGrupo("id");
        } else if (t.getGrupo().equalsIgnoreCase("num")) {
            matchGrupo("num");
        } else if (t.getLexema().equals("(")) {
            match("(");
            expresion();
            match(")");
        } else {
            error("se esperaba id, num o '('", t);
        }
    }
}
