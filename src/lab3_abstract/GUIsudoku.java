/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_abstract;
import javax.swing.JFrame;

/**
 *
 * @author 50494
 */
public class GUIsudoku  extends JFrame{
     private TableroSudoku tablero;

    public GUIsudoku() {
        setTitle("Sudoku");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

     
        tablero = new TableroSudoku();
        add(tablero.createBoardPanel());
    }
}
