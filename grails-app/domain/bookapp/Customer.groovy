package bookapp

class Customer {
     String firstName
    String lastName
    Long phone
    String email
    Integer totalPoint
    static hasMany=[books:Books]

    static constraints = {


        firstName blank: false
        lastName  blank: false
        email nullable: true
        totalPoint nullable:true
    }
    static mapping={
        version(false)
        books(cascade: 'all-delete-orphan')
    }
}