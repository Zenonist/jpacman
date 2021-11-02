package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;
    private BasicSquare[][] grid;
    private int size = 1;

    /**
     * SetUp
     */
    @BeforeEach
    void setUp() {
        grid = new BasicSquare[size][size];
        BasicSquare square = new BasicSquare();
        grid[size - 1][size - 1] = square;
        board = new Board(grid);
    }

    /*
    Compare the board's width that has the same size
    */
    @Test
    void getWidthTest_1() {
        assertThat(board.getWidth()).isEqualTo(size);
    }

    /*
    Compare the board's width that is not 0
    */
    @Test
    void getWidthTest_2() {
        assertThat(board.getWidth()).isNotEqualTo(0);
    }

    /*
    Compare the board's width that is not -1
    */
    @Test
    void getWidthTest_3() {
        assertThat(board.getWidth()).isNotEqualTo(-1);
    }

    /*
    Compare the board's height that has the same size
    */
    @Test
    void getHeightTest_1() {
        assertThat(board.getHeight()).isEqualTo(size);
    }

    /*
    Compare the board's height that is not 0
    */
    @Test
    void getHeightTest_2() {
        assertThat(board.getHeight()).isNotEqualTo(0);
    }

    /*
    Compare the board's height that is not -1
    */
    @Test
    void getHeightTest_3() {
        assertThat(board.getHeight()).isNotEqualTo(-1);
    }

    /*
    Compare the square in specific board is same
    */
    @Test
    void getSquareAtTest_1() {
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
    }

    /*
    Compare the square in specific board is not same as other square
    */
    @Test
    void getSquareAtTest_2() {
        BasicSquare[][] new_Grid = new BasicSquare[2][2];
        assertThat(board.squareAt(0, 0)).isNotEqualTo(new_Grid[1][1]);
    }

    /*
    make your that specific location is within border
    */
    @Test
    void withinBordersTest_1() {
        assertThat(board.withinBorders(0, 0)).isTrue();
    }

    /*
    Compare the square in specific board is not within border
    */
    @Test
    void withinBordersTest_2() { assertThat(board.withinBorders(-1, -1)).isFalse(); }
    
    /*
    Test that square should not be null
    */
    @Test
    void nullSquareTest() {
        BasicSquare[][] square_Null = new BasicSquare[size][size];
        // Assert for Throw Exception
        assertThrows(AssertionError.class, () -> { new Board(square_Null); });
    }
}
