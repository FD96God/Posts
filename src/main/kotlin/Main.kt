package ru.netology

class Comments(val comment: String)
data class Post(val id: Int,
           val date: Int,
           val text: String,
           val friendsOnly: Boolean,
           val comments: Comments,
           val canPin: Boolean,
           val canDelete: Boolean,
           val canEdit: Boolean,
           val isPinned: Boolean,
           val isFavorite: Boolean)

object WallService {
    private var posts = emptyArray<Post>()
    private var id = posts.size + 1

    fun add(post: Post): Post  {
        posts += post.copy(id = id)
        return posts.last()
    }

    fun update (postUp: Post): Boolean {
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



fun main() {
}