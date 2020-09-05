package bookapp

class CustomerController {
    //static scaffold=Customer

    def calculationsService
    CustomerService customerService
    def index() {
        def response= customerService.list(params)
        [customerlist:response.list, total:response.count]

    }
    def create(){
        [CustomerInstance: flash.redirectParams]//store object for the next request
    }
     def lookup(){
          def customerInstance=Customer.list()
         [customerInstancelist:customerInstance]
     }
    def checkin(){

    }
    def customerlookup(Customer lookupinstance){  //Lookupinstance contains all infos will be paste for the form

        def(customerInstance,welcomeMessage)= calculationsService.processCheckin(lookupinstance)
        render(view: "checkin",model:[customerInstance : customerInstance,welcomeMessage: welcomeMessage])
        //Query customer id
        // if no result
        //Create a new customer
        // Create a welcome message
        // Add bookapp record
        // Save Customer
        //Send welcome to the kiosk
        //if customer found
        //calculate Total point
        // Create a welcome message
        // Add bookapp record
        // Save Customer

    }
    def save(){
        def response= customerService.save(params)
        if(!response.isSuccess){
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "customer", action: "create")
        }else{
            flash.message = AppUtil.infoMessage(g.message(code: "saved"))
            redirect(controller: "customer", action: "index")
        }

    }
    def edit(Integer id) {
        if (flash.redirectParams) {
            [customer: flash.redirectParams]
        } else {
            def response = customerService.getById()
            if (!response) {
                flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "customer", action: "index")
            } else {
                [customer: response]
            }
        }
    }

}
