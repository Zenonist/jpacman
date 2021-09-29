package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;
    private BasicSquare[][] grid;
    private int size = 1;
    @BeforeEach
    void setUp(){
        grid = new BasicSquare[size][size];
        BasicSquare square = new BasicSquare();
        grid[size-1][size-1] = square;
        board = new Board(grid);
    }
    @Test
    void getWidthTest_1() {
        assertThat(board.getWidth()).isEqualTo(size);
    }

    @Test
    void getWidthTest_2() {
        assertThat(board.getWidth()).isNotEqualTo(0);
    }
    @Test
    void getWidthTest_3() {
        assertThat(board.getWidth()).isNotEqualTo(-1);
    }
    @Test
    void getHeightTest_1() {
        assertThat(board.getHeight()).isEqualTo(size);
    }
    @Test
    void getHeightTest_2() {
        assertThat(board.getHeight()).isNotEqualTo(0);
    }
    @Test
    void getHeightTest_3() {
        assertThat(board.getHeight()).isNotEqualTo(-1);
    }
    @Test
    void getSquareAtTest_1() {
        assertThat(board.squareAt(0,0)).isEqualTo(grid[0][0]);
    }
    @Test
    void getSquareAtTest_2() {
        BasicSquare[][] new_grid = new BasicSquare[2][2];
        assertThat(board.squareAt(0,0)).isNotEqualTo(new_grid[1][1]);
    }
    @Test
    void withinBordersTest_1() {
        assertThat(board.withinBorders(0,0)).isTrue();
    }
    @Test
    void withinBordersTest_2() { assertThat(board.withinBorders(-1,-1)).isFalse(); }
    @Test
    void NullSquareTest() {
        BasicSquare[][] square_null = new BasicSquare[size][size];
        // Assert for Throw Exception
        assertThrows(AssertionError.class, () -> {new Board(square_null);});
    }
}
