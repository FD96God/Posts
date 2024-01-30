import org.junit.Assert.*
import org.junit.Test
import ru.netology.Comments
import ru.netology.Post
import ru.netology.WallService

class WallServiceTest {

    @Test
    fun addTest() {
        val post = Post(1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true)
        WallService.add(post)
        assertEquals(1, WallService.last().id)

    }



    @Test
    fun updateTestTrue() {
        Post(1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true)
        val post1 = Post(1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true)

        assertEquals(true,WallService.update(post1) )
    }
    @Test
    fun updateTestFalse() {
        Post(1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true)
        val post1 = Post(5, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true)

        assertEquals(false,WallService.update(post1) )
    }

}