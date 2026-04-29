package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftPadUtilsTest {
    @Tag("specification")
    @Test
    void leftPad_nullString_returnsNull() {
        assertNull(LeftPadUtils.leftPad(null, 5, "x"));
    }

    @Tag("specification")
    @Test
    void leftPad_nullPadStr_usesSpace() {
        assertEquals("  cat", LeftPadUtils.leftPad("cat", 5, null));
    }

    @Tag("specification")
    @Test
    void leftPad_emptyPadStr_usesSpace() {
        assertEquals("  cat", LeftPadUtils.leftPad("cat", 5, ""));
    }

    @Tag("specification")
    @Test
    void leftPad_noPaddingNeeded_whenSizeEqualsStringLength() {
        assertEquals("cat", LeftPadUtils.leftPad("cat", 3, "x"));
    }

    @Tag("specification")
    @Test
    void leftPad_noPaddingNeeded_whenSizeLessThanStringLength() {
        assertEquals("cat", LeftPadUtils.leftPad("cat", 2, "x"));
    }

    @Tag("specification")
    @Test
    void leftPad_singleCharacterPad() {
        assertEquals("xxcat", LeftPadUtils.leftPad("cat", 5, "x"));
    }

    @Tag("specification")
    @Test
    void leftPad_multiCharacterPad_exactPadLength() {
        assertEquals("abcat", LeftPadUtils.leftPad("cat", 5, "ab"));
    }

    @Tag("specification")
    @Test
    void leftPad_multiCharacterPad_partialPadLength() {
        assertEquals("acat", LeftPadUtils.leftPad("cat", 4, "abc"));
    }

    @Tag("structural")
    @Test
    void leftPad_multiCharacterPad_repeatsPadString() {
        assertEquals("ababacat", LeftPadUtils.leftPad("cat", 8, "ab"));
    }

    @Tag("structural")
    @Test
    void leftPad_emptyOriginalString() {
        assertEquals("xxx", LeftPadUtils.leftPad("", 3, "x"));
    }

    @Tag("structural")
    @Test
    void leftPad_sizeZero_returnsOriginalString() {
        assertEquals("cat", LeftPadUtils.leftPad("cat", 0, "x"));
    }
}
