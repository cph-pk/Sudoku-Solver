# Sudoku solver in Java

A Sudoku solver made in Java!
Sudoku is a logic game, where you fill in numbers from 1-9 in a 9x9 grid. In Sudoku, each row, column, and 3x3 sub-grid must contain all numbers from 1-9.

This Sudoku solver can also be used to solve 6x6, 12x12 and 16x16 grid by altering the numbers in the api.

## How to use the Sudoku solver

To use the Sudoku solver, you have to decide the grid size, row size and column size:

- `GRID_SIZE`: the size of the grid
- `BOX_ROW_SIZE`: the size of the individual rows
- `BOX_COLUMN_SIZE`: the size of the individual columns

For example if you have a 9x9 grid.<br>
`GRID_SIZE = 9`<br>
`BOX_ROW_SIZE = 3`<br>
`BOX_COLUMN_SIZE = 3`

Or if the grid is 12x12.<br>
`GRID_SIZE = 12`<br>
`BOX_ROW_SIZE = 3`<br>
`BOX_COLUMN_SIZE = 4`

#### How to enter the sudoku you want to solve
Here is an example with a 9x9 grid, where 0 is a blank field.

```java
int[][] board = {
        { 7, 0, 2, 0, 5, 0, 6, 0, 0 },
        { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
        { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
        { 8, 0, 0, 0, 0, 0, 0, 9, 0 },
        { 0, 4, 3, 0, 0, 0, 7, 5, 0 },
        { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
        { 0, 0, 9, 7, 0, 0, 0, 0, 5 },
        { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
        { 0, 0, 7, 0, 4, 0, 2, 0, 3 }
};
```


