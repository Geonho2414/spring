package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Mileage;
import dw.wholesale_company.repository.CustomerRepository;
import dw.wholesale_company.repository.MileageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MileageRepository mileageRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    //실습 : 고객 전체의 평균 마일리지보다 마일리지가 큰 고객 정보
    public List<Customer> getCustomerWithHighMileThenAvg() {
        List<Customer> customers = customerRepository.findAll();
        int sum = 0;
        for (int i = 0; i < customers.size(); i++) {
            sum = sum + customers.get(i).getMileage();
        }
        Double avg = (double) sum / (double) customers.size();
        return customers.stream().filter(c -> c.getMileage() > avg).collect(Collectors.toList());
    }

    //실습 : 마일리지 등급별로 고객수를 보이시오
//    public List<Customer> getCustomerByMileageGrade(String grade) {
//        List<Customer> customers = customerRepository.findAll();
//        List<Mileage> mileages = mileageRepository.findAll();
//        List<Mileage> KK = new ArrayList(){};
//        int sum = 0;
//        for (int i = 0; i < customers.size(); i ++){
//            for (int j = 0; j < mileages.size(); j++)
//            if (mileages.get(j).getHighLimit() > customers.get(i).getMileage()) {
//                if (mileages.get(j).getLowLimit() > customers.get(i).getMileage()) {
//                    sum++;
//                }
//            }
//        }
//        return mileages.stream().sorted (m -> m.getMileageGrade() = ).collect(Collectors.toList());
//    }
}