package bookapp

class Customer {
     String firstName
    String lastName

    String email

    static hasMany=[books:Book]

    static constraints = {


        firstName blank: false
        lastName  blank: false
        email nullable: true

    }
    static mapping={
        version(false)
        books(cascade: 'all-delete-orphan')
    }
}
