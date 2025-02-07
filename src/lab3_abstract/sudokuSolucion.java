/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstract;

import java.util.Random;

/**
 *
 * @author chung
 */
public class sudokuSolucion extends BaseSudoku{
     public sudokuSolucion() {
        tablerosudoku = new int[9][9];
        GenerarSolucion();
    }

    @Override
    public void GenerarSolucion() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tablerosudoku[i][j] = (i * 3 + i / 3 + j) % 9 + 1;
            }
        }
    }
    @Override
    public int[][] GenerarPuzzle() {
        int[][] puzzle = new int[9][9];
        Random rand = new Random();

        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (rand.nextInt(3) == 0) {
                    puzzle[i][j] =  tablerosudoku[i][j];
                } else {
                    puzzle[i][j] = 0;
                }
            }
        }
        return puzzle;
    }
}
