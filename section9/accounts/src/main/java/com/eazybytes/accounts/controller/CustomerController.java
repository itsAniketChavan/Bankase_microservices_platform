package com.eazybytes.accounts.controller;


import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.service.ICustomerService;
import jakarta.validation.constraints.Pattern;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {

    private final ICustomerService iCustomerService;

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(ICustomerService iCustomerService){
        this.iCustomerService = iCustomerService;
    }

    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(
                                                            @RequestHeader("eazybank-correlation-id")
                                                            String correlationid,
                                                            @RequestParam
                                                            @Pattern(regexp ="(^$|[0-9]{10})", message = "Mobile number should be 10 digit" )
                                                            String mobileNumber){

        logger.debug("eazybank correlation id found: {}", correlationid);
        CustomerDetailsDto customerDetailsDto = iCustomerService.fetchCustomerDetails(mobileNumber, correlationid);

        return ResponseEntity.status(HttpStatus.SC_OK).body(customerDetailsDto);

    }

}
