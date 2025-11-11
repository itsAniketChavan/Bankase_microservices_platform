package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.dto.CustomerDto;

public interface ICustomerService {

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
