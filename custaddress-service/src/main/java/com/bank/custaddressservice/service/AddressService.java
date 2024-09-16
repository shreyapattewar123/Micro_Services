package com.bank.custaddressservice.service;

import com.bank.custaddressservice.entity.Address;
import com.bank.custaddressservice.repository.AddressRepo;
import com.bank.custaddressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
@Autowired
    AddressRepo addressRepo;
@Autowired
    private ModelMapper modelMapper;
public AddressResponse findAddressByAddressId(int customerId){
    Address address =addressRepo.findById(customerId).get();
    AddressResponse addressResponse = modelMapper.map(address,AddressResponse.class);
   return addressResponse;
}

}
