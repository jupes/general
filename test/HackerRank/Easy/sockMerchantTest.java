package HackerRank.Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SockMerchantTest {

    @Test
    @DisplayName("Happy Path Test - only two socks, matching")
    void test1() {
        //arrange
        int[] testArray = {1,1};
        int expected = 1;
        //act
        int result = sockMerchant(2, testArray);
        //assert
        assertEquals(expected, result);
    }

}