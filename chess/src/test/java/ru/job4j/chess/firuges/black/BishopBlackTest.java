package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.chess.firuges.Cell.*;

class BishopBlackTest {

    @Test
    void position() {
        BishopBlack bishopBlack = new BishopBlack(F6);
        Assertions.assertEquals(F6, bishopBlack.position());
    }

    @Test
    void way() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] way = bishopBlack.way(G5);
        Assertions.assertEquals(way[0], D2);
        Assertions.assertEquals(way[1], E3);
        Assertions.assertEquals(way[2], F4);
        Assertions.assertEquals(way[3], G5);
    }

    @Test
    void whenWayProhibited() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bishopBlack.way(G4);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to G4");
    }

    @Test
    void isDiagonal() {
    }

    @Test
    void copy() {
        Figure bishopBlack = new BishopBlack(F6);
        bishopBlack = bishopBlack.copy(Cell.H6);
        Assertions.assertEquals(H6, bishopBlack.position());
    }
}