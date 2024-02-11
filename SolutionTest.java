package effectivejava.chapter10.item74;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest extends ModifiedIndexOutOfBoundsException {

    /**
     * IndexOutOfBoundsException 생성한다.
     *
     * @param lowerBound 인덱스의 최솟값
     * @param upperBound 인덱스의 최댓값 + 1
     * @param index      인덱스의 실젯값
     */
    public SolutionTest(int lowerBound, int upperBound, int index) {
        super(lowerBound, upperBound, index);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createSolution() {
    }

    @Test
    void solution() {
    }
}