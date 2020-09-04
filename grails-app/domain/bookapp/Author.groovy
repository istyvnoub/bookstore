package bookapp

class Author {
    String name
    static hasMany = [books: Book]

    static mapping = {
        books cascade: 'all-delete-orphan'
    }

    static constraints = {
        books nullable: false
    }
}
