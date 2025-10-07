package com.mycompany.lexico;

import com.formdev.flatlaf.FlatIntelliJLaf;
import vistas.LexicalTable;
import javax.swing.UIManager;

public class Lexico {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
        }

        java.awt.EventQueue.invokeLater(() -> {
            new vistas.LexicalTable().setVisible(true);
        });
    }
}
