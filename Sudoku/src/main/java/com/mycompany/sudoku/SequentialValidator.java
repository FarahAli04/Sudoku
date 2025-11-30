package com.mycompany.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SequentialValidator implements Validator{
Board board ;
List<String> errors  = new ArrayList<>();
public SequentialValidator(Board board) {
    this.board = board;
}
@Override 
public boolean isValid(){
RowDuplicateValidator();
ColumnDuplicateValidator();
BoxDuplicateValidator();
return errors.isEmpty();
}

@Override
public List<String> getValidationErrors() {
    return errors;
}

public void RowDuplicateValidator() {
    for (int i = 0; i < 9; i++) {
        int[] row = board.getrow(i);
        DuplicatesFinder finder = new DuplicatesFinder();
        DuplicateResult result = finder.findDuplicates(row);
        if (result.isHasDuplicates()) {
            for (Map.Entry<Integer, List<Integer>> entry : result.getDuplicates().entrySet()) {
             int duplicatevalue = entry.getKey();
             List<Integer> position = entry.getValue();
              errors.add(formatRowError(i, duplicatevalue, position));
            }
        }
}
}
public String formatRowError(int row, int duplicateValue, List<Integer> position) {
   return "ROW " + (row + 1) + ", #" + duplicateValue + ", " + position.toString();
}

public void ColumnDuplicateValidator(){
  for (int i = 0 ;i < 9 ; i++){
   int[] column = board.getcolumn(i);
   DuplicatesFinder finder = new DuplicatesFinder();
   DuplicateResult result = finder.findDuplicates(column);
    if (result.isHasDuplicates()) {
            for (Map.Entry<Integer, List<Integer>> entry : result.getDuplicates().entrySet()) {
             int duplicatevalue = entry.getKey();
             List<Integer> position = entry.getValue();
              errors.add(formatColumnError(i, duplicatevalue, position));
            }
        }
  }    
}

public String formatColumnError(int column, int duplicateValue, List<Integer> position) {
   return "Column " + (column + 1) + ", #" + duplicateValue + ", " + position.toString();
}

public void BoxDuplicateValidator(){
   for (int i = 0 ; i < 9 ; i++){
   int[] box = board.getbox(i);
   DuplicatesFinder finder = new DuplicatesFinder();
   DuplicateResult result = finder.findDuplicates(box);
    if (result.isHasDuplicates()) {
            for (Map.Entry<Integer, List<Integer>> entry : result.getDuplicates().entrySet()) {
             int duplicatevalue = entry.getKey();
             List<Integer> position = entry.getValue();
              errors.add(formatBoxError(i, duplicatevalue, position));
            }
        }
  }      
}

public String formatBoxError(int box, int duplicateValue, List<Integer> position) {
   return "Box " + (box + 1) + ", #" + duplicateValue + ", " + position.toString();
}

}

