/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.List;

/**
 *
 * @author Michelle

 */
public class ModeloGramatica {
    private List<String> valores;
    private String Grupo;

    public ModeloGramatica(List<String> valores, String Grupo) {
        this.valores = valores;
        this.Grupo = Grupo;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }
}

