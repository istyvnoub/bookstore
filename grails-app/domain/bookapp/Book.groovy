package bookapp

class Book {
    String name
    String isbn
    Float price

    static belongTo =[author: Author]

    static constraints = {
        name blank: false, nullable: false
        isbn blank: false, nullable: false
        price nullable: false
    }
}
