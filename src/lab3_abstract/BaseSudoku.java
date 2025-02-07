/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstract;

/**
 *
 * @author Mario
 */
public abstract class BaseSudoku {
    protected int[][] tablerosudoku;
    
    public abstract void GenerarSolucion();
    public abstract int[][] GenerarPuzzle();
    
    public int getValorSolucion(int row, int col){
        return tablerosudoku[row][col];
    }
    
}
