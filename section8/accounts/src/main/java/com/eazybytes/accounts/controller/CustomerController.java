package com.eazybytes.accounts.controller;


import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.service.ICustomerService;
import jakarta.validation.constraints.Pattern;
import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {

    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService){
        this.iCustomerService = iCustomerService;
    }

    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam
                                                            @Pattern(regexp ="(^$|[0-9]{10})", message = "Mobile number should be 10 digit" )
                                                            String mobileNumber){

        CustomerDetailsDto customerDetailsDto = iCustomerService.fetchCustomerDetails(mobileNumber);

        return ResponseEntity.status(HttpStatus.SC_OK).body(customerDetailsDto);

    }

}
