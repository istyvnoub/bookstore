package bookapp

import grails.gorm.transactions.Transactional

@Transactional
class AuthenticationService {

    private static final String AUTHORIZED = "AUTHORIZED"

    def serviceMethod() {

    }
    def setMemberAuthorization(Customer customer) {
        def authorization = [isLoggedIn: true, member: customer]
        AppUtil.getAppSession()[AUTHORIZED] = authorization
    }

    def doLogin(String email, String password){ //check user email and password
        password = password.encodeAsMD5()
        Customer member = Member.findByEmailAndPassword(email, password)
        if (member){
            setMemberAuthorization(member)
            return true
        }
        return false
    }

    boolean isAuthenticated(){
        def authorization = AppUtil.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn){
            return true
        }
        return false
    }
    def getMember(){
        def authentication=AppUtil.getAppSession()[AUTHORIZED]
        return authentication?.member
    }
    def getMemberName(){
        def member= getMember()
     return "${member.firstName} ${member.lastName}"
    }
}
