import org.junit.Assert.*
import org.junit.Test
import ru.netology.*

class WallServiceTest {
    val testArray: Array<Attachment> = arrayOf(
        AudioAttachment("audio", Audio(1, "link")), VideoAttachment(
            "video",
            Video(1, "link")
        ), DocAttachment("doc", Doc(1, "link"))
    )

    @Test
    fun addTest() {
        val post = Post(
            1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true, testArray
        )
        WallService.add(post)
        assertEquals(1, WallService.last().id)

    }

    @Test
    fun updateTestTrue() {
        Post(
            1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true, testArray
        )
        val post1 = Post(
            1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true, testArray
        )

        assertEquals(true, WallService.update(post1))
    }

    @Test
    fun updateTestFalse() {
        Post(
            1, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true, testArray
        )
        val post1 = Post(
            5, 280124, "Hello", true, Comments("World"), true, true,
            true, false, true, testArray
        )

        assertEquals(false, WallService.update(post1))
    }

}