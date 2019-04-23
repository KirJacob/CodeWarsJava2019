package cw6_who_likes;

import org.junit.Test;

import static cw6_who_likes.WhoLikes.whoLikesIt;
import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void staticTests() {
        assertEquals("no one likes this", whoLikesIt());
        assertEquals("Peter likes this", whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}
