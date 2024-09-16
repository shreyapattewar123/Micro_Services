package com.bank.cust.service.cust_service.service;

import com.bank.cust.service.cust_service.entity.customer;
import com.bank.cust.service.cust_service.feignclient.AddressClient;
import com.bank.cust.service.cust_service.repository.CustomerRepo;
import com.bank.cust.service.cust_service.response.AddressResponse;
import com.bank.cust.service.cust_service.response.CustomerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerService {
    @Autowired (required = true)
    private CustomerRepo customerRepo;
    @Autowired

    private ModelMapper modelMapper;
    //    @Autowired
//    private RestTemplate restTemplate;

    @Value("${addressservice.base.url}")
    private String addressBaseUrl;
    @Autowired
    private AddressClient addressClient;

    public CustomerService() {

    }


    public CustomerResponse getCustomerById(int id) {

        customer com = customerRepo.findById(id).get();
        //AddressResponse addressResponse = new AddressResponse();
        CustomerResponse customerResponse = modelMapper.map(com, CustomerResponse.class);
        ResponseEntity<AddressResponse>addressResponseEntity=addressClient.getAddressByCustomer(id);
        AddressResponse addressResponse=addressResponseEntity.getBody();
        //AddressResponse addressResponse1 = addressClient.getAddressByCustomer(id);
        customerResponse.setAddressResponse(addressResponse);
        return customerResponse;

    }

}
