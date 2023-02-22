package Object;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final  String id;
    private List <Customer> customers;

    // constructor
    public Bank (){
        this.id="";
        this.customers = null;
    }
    public Bank(String id, List<Customer> customers) {
        this.id = id;
        this.customers = customers;
    }
    // method
    // thêm khách hàng vào ngân hàng
    public  void  addCustomer ( Customer  newCustomer){
        int test =0;
        if( this.customers != null ) {
            for (Customer customer : this.customers) {
                if (customer.getCustomerId().equals(newCustomer.getCustomerId()))
                    test += 1;
            }
            if(test == 0)
                this.customers.add(newCustomer);
        }else {
            this.customers = new ArrayList<>();
            this.customers.add(newCustomer);
        }
    }
    // kiểm tra khách hàng đó có tồn tại trong danh sách khách hàng hay không
    public boolean isCustomerExisted (String customerId){
        if(this.customers != null){
            for (Customer customer : this.customers){
                if (customer.getCustomerId().equals(customerId)) {
                    return true;

                }
            }
        }
        return  false;
    }
    // display thông tin ngân hàng
    public  void display(){
        if(this.customers != null){
            for(Customer customer : this.customers){
                customer.displayInformation();
            }
        }else{
            System.out.println("Khong co khach hang nao !!!");
        }

    }

    // getter
    // lấy id ngân hàng
    public String getId() {
        return id;
    }
    // lấy danh sách khách hàng của ngân hàng
    public List<Customer> getCustomers() {
        return customers;
    }
}
