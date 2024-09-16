package com.bank.cust.service.cust_service.service;

import com.bank.cust.service.cust_service.entity.customer;
import com.bank.cust.service.cust_service.repository.CustomerRepo;
import com.bank.cust.service.cust_service.response.AddressResponse;
import com.bank.cust.service.cust_service.response.CustomerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired

    private ModelMapper modelMapper;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;
    @Value("${addressservice.base.url}")
    private String addressBaseUrl;

//    public CustomerService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//
//    }
//    public CustomerService(@Value("${addressservice.base.url}") String addressBaseUrl ,RestTemplateBuilder restTampletBuilder){
//        System.out.println("uri"+addressBaseUrl);
//        this.restTemplate=restTampletBuilder.rootUri(addressBaseUrl).build();
//    }


    public CustomerResponse getCustomerById(int id){

        customer com =customerRepo.findById(id).get();
        AddressResponse addressResponse =new AddressResponse();
        CustomerResponse customerResponse =modelMapper.map(com,CustomerResponse.class);
          //addressResponse =restTemplate.getForObject(addressBaseUrl+"/address/{id}",AddressResponse.class,id);
       AddressResponse addressResponse1=webClient.get().uri("/address/"+id)
                       .retrieve().bodyToMono(AddressResponse.class).block();
        System.out.println("url" +addressBaseUrl);
               customerResponse.setAddressResponse(addressResponse1);
                return customerResponse;

    }

}
