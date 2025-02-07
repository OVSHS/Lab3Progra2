/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstract;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mario
 */
public class TableroSudoku {
    private JPanel panelTablero;
    private JTextField[][] celdas;
    private sudokuSolucion solucion;
    private int[][] puzzle; 

    public TableroSudoku() {
        solucion = new sudokuSolucion();
        puzzle = solucion.GenerarPuzzle();
    }

    public JPanel createBoardPanel() {
        panelTablero = new JPanel(new GridLayout(9, 9));
        celdas = new JTextField[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                celdas[row][col] = new JTextField();
                celdas[row][col].setHorizontalAlignment(JTextField.CENTER);

                if (puzzle[row][col] != 0) {
                    celdas[row][col].setText(String.valueOf(puzzle[row][col]));
                    celdas[row][col].setEditable(false);
                    celdas[row][col].setBackground(Color.LIGHT_GRAY);
                } else {
                    int r = row, c = col;
                    celdas[row][col].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //falta funcion
                        }
                    });
                }
                panelTablero.add(celdas[row][col]);
            }
        }
        return panelTablero;
    }

}
