package com.bank.custaddressservice.controller;

import com.bank.custaddressservice.response.AddressResponse;
import com.bank.custaddressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAddressController {
    @Autowired
    AddressService addressService;
//    @GetMapping("/address/{id}")
//    public ResponseEntity<AddressResponse> getaddressDetails(@PathVariable("id") int id) {
//        AddressResponse addressResponse = addressService.findAddressByAddressId(id);
//
//        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
//    }
    @GetMapping("/address/{customerid}")
    public ResponseEntity<AddressResponse> getAddressByCustomer(@PathVariable("customerid") int id){
        AddressResponse addressResponse=null;
        addressResponse=addressService.findAddressByAddressId(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }
}
