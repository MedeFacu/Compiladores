/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author jesus
 */
public class Token {
    private String Grupo;
    private String Lexema;
    private int linea;
    private int columna;

    public Token(String Grupo, String Lexema, int linea, int columna) {
        this.Grupo = Grupo;
        this.Lexema = Lexema;
        this.linea = linea;
        this.columna = columna;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String lexema) {
        Lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTokenName() {
        return Grupo;
    }

    @Override
    public String toString() {
        return "Token{" +
                "Grupo='" + Grupo + '\'' +
                ", Lexema='" + Lexema + '\'' +
                ", linea=" + linea +
                ", columna=" + columna +
                '}';
    }
}
