/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lexico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jesus
 */
public class ReadSourceCode {
    public String ReadCode(String path) throws Exception {
        File file = new File(path);
        try {
            StringBuilder builder = new StringBuilder();
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String linea;
            while((linea = br.readLine()) != null) {
                builder.append(linea).append(" \n");
            }
            return  builder.toString().substring(0, builder.toString().length()-1);
        } catch (IOException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public String[] SplitCode(String code) {
        return code.split(" ");
    }
}
