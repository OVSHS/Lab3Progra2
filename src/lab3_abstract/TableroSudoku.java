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
                             CheckRespuesta(r, c);
                        }
                    });
                }
                panelTablero.add(celdas[row][col]);
            }
        }
        return panelTablero;
    }
    
    private void CheckRespuesta(int row, int col) {
        try {
            int valor = Integer.parseInt(celdas[row][col].getText());
            if (valor < 1 || valor > 9) {
                throw new NumberFormatException();
            }

         
            if (MovimientoValido(row, col, valor)) {
                celdas[row][col].setBackground(Color.GREEN);
                puzzle[row][col] = valor;

              
                if (checkGane()) {
                    int resp = JOptionPane.showConfirmDialog(
                            null,
                            "Felicidades has ganado, Deseas volver a jugar?",
                            "Sudoku",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (resp == JOptionPane.YES_OPTION) {
                        ResetearJuego();
                    } else {
                        System.exit(0); 
                    }
                }
            } else {
                celdas[row][col].setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "Su movimiento es invalido, intente denuevo.");
                celdas[row][col].setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero valido (1-9).");
            celdas[row][col].setText("");
        }
    }

    
    private boolean MovimientoValido(int row, int col, int value) {
       
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == value) {
                return false;
            }
        }
      
        for (int i = 0; i < 9; i++) {
            if (puzzle[i][col] == value) {
                return false;
            }
        }
       
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (puzzle[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

  
    private boolean checkGane() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (puzzle[row][col] != solucion.getValorSolucion(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    
    private void ResetearJuego() {
      
        puzzle = solucion.GenerarPuzzle();

      
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                celdas[row][col].setText("");
                celdas[row][col].setEditable(true);

                if (puzzle[row][col] != 0) {
                    celdas[row][col].setText(String.valueOf(puzzle[row][col]));
                    celdas[row][col].setEditable(false);
                    celdas[row][col].setBackground(new Color(250, 112, 209));
                } else {
                    celdas[row][col].setBackground(Color.WHITE);
                }
            }
        }
    }
}

