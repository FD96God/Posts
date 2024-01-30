package ru.netology

class Comments(val comment: String)
data class Post(
    val id: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean,
    val comments: Comments,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val isFavorite: Boolean,
    val attachment: Array<Attachment>
)

object WallService {
    private var posts = emptyArray<Post>()
    private var id = posts.size + 1

    fun add(post: Post): Post {
        posts += post.copy(id = id)
        return posts.last()
    }

    fun update(postUp: Post): Boolean {
        var i = 0
        while (i in posts.indices) {
            if (posts[i].id == postUp.id) {
                posts[i] = postUp
                return true
            }
            i++
        }
        return false
    }

    fun last(): Post {
        return posts.last()
    }
}

interface Attachment {
    val type: String
}

class AudioAttachment(override val type: String, val audio: Audio) : Attachment
class Audio(val id: Int, val link: String)

class VideoAttachment(override val type: String, val video: Video) : Attachment
class Video(val id: Int, val link: String)

class LinkAttachment(override val type: String, val Link: Link) : Attachment
class Link(val link: String)

class PhotoAttachment(override val type: String, val photo: Photo) : Attachment
class Photo(val id: Int, val link: String)

class DocAttachment(override val type: String, val doc: Doc) : Attachment
class Doc(val id: Int, val link: String)

fun main() {
}