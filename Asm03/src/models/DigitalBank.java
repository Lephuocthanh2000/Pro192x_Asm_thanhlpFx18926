package models;
import  Object.Bank;
import  Object.Customer;
//quản lý ngân hàng tiềm năng.
public class DigitalBank extends Bank {

    public Customer getCustomerById (String customerId){
//        Chỉ trả về khách hàng nếu như tồn tại CCCD trong hệ thống ngân hàng, ngược lại trả về null.
        if(this.isCustomerExisted(customerId)){
            for(Customer customer: this.getCustomers()){
                if(customer.getCustomerId().equals(customerId)) {
                    System.out.println(customer.getCustomerId());
                    return customer;
                }
            }

        }
        return null;
    }
//    hàm cho phép khách hàng rút tiền theo tài khoản
    public boolean withdraw(String customerId ,String accountNumber, double amount ){
//        Hàm này kiểm tra nếu customerId không tồn tại thì trả về , ngược lại có tồn tại thì gọi hàm withdraw của đối tượng khách hàng tìm được.
        Customer customer = this.getCustomerById(customerId);
        if( customer!= null){
            customer = new DigitalCustomer();
            customer.withDraw(accountNumber,amount);
            return true;
        }
        return false;
    }
}
