package bookapp

class BootStrap {
     

    def init = { servletContext ->


        def book1= new Book(name:"Morning Yvan ",isbn: "MB01",price: 14.94).save(failOnError: true)
        def book2 =new Book(name:"NightYvan ",isbn: "NY01",price: 13.94).save(failOnError: true)
        

	Author.withTransaction { status ->
     	    Author author = new Author(name:"Yvan Loic",books:[book1, book2]).save(failOnError: true)
	}

        new Customer( firstName: "Luther", lastName: "Allison",email: "luther@mai.com").save()
        new Customer( firstName: "Bessie", lastName: "Brown",email: "Bessie@mai.com").save()
        new Customer( firstName: "Bo", lastName: "Diddley",email: "B@mai.com").save()
        new Customer( firstName: "Leroy", lastName: "Foster",email: "leroy@mai.com").save()
        new Customer( firstName: "Earl", lastName: "Hooker",email: "Earl@mai.com").save()
        new Customer( firstName: "Maggie", lastName: "Jones",email: "Maggie@mai.com").save()
        new Customer( firstName: "Nick", lastName: "Moss",email: "Nick@mai.com").save()
        new Customer( firstName: "Odie", lastName: "Payne",email: "Odie@mai.com").save()
        new Customer( firstName: "Jonny", lastName: "Shines",email: "Jonny@mai.com").save()
        new Customer( firstName: "Ethel", lastName: "Waters",email: "Ethel@mai.com").save()
        new Customer( firstName: "Scrapper", lastName: "Blackwell",email: "Scrapper@mai.com").save()
        new Customer( firstName: "Archie", lastName: "Edwards",email: "Archie@mai.com").save()
        new Customer( firstName: "Jessie", lastName: "Fuller",email: "Jessie@mai.com").save()
        new Customer( firstName: "Ida", lastName: "Goodson",email: "Ida@mai.com").save()
        new Customer( firstName: "Bumble Bee", lastName: "Smith",email: "Bumblebee@mai.com").save()
        new Customer( firstName: "Sippie", lastName: "Wallace", email: "Sippie@mai.com").save()


    }
    def destroy = {
    }
}
