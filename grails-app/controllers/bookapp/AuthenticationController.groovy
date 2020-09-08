package bookapp

class AuthenticationController {

    AuthenticationService authenticationService
    CustomerService customerService
   // def index() { }

    def login(){
        if(authenticationService.isAuthenticated()){
            redirect(controller: "dashboard",action: "index")

        }
    }

    def justlogin(){
        if(authenticationService.doLogin(params.email,params.password)){
            redirect(controller: "dashboard",action: "index")
        }else {
            redirect(controller: "authentication",action: "login")
        }
    }

    def logout(){
        session.invalidate()
        redirect(controller: "authentication",action: "login")
    }
    def registration() {
        [customer: flash.redirectParams]
    }


    def doRegistration() {
        def response = customerService.save(params)
        if (response.isSuccess) {
            authenticationService.setMemberAuthorization(response.model)
            redirect(controller: "dashboard", action: "index")
        } else {

            redirect(controller: "authentication", action: "registration")
        }
    }
}
