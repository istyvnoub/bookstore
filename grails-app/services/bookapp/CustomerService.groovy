package bookapp

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class CustomerService {

    def serviceMethod() {

    }
    def save(GrailsParameterMap params){
        Customer customer= new Customer(params)
        def response= AppUtil.saveResponse(false,customer)

        if(customer.validate()){
            customer.save(flush:true)
            if(!customer.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def update(Customer customer, GrailsParameterMap params) {
        customer.properties = params
        def response = AppUtil.saveResponse(false, customer)
        if (customer.validate()) {
            customer.save(flush: true)
            if (!customer.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }
    def getById(Serializable id) {
        return Customer.get(id)
    }
    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Customer> customerList = Customer.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list: customerList, count: Customer.count()] //return a list and Anzahl con Customer
    }
}
