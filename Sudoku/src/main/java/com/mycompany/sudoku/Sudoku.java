/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sudoku;

/**
 *
 * @author Farah
 */
public class Sudoku {

    public static void main(String[] args) {
      try {
            // Change this path to your test CSV
            String filePath = "E:\\java\\Sudoku\\src\\main\\java\\com\\mycompany\\sudoku\\Invalid.csv";  

            Board board = new Board(filePath);

            // Use your SequentialValidator (mode 0)
            Validator validator = new SequentialValidator(board);

            boolean valid = validator.isValid();

            if (valid) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
                System.out.println("----------------------------------");

                for (String error : validator.getValidationErrors()) {
                    System.out.println(error);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
