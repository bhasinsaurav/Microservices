package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Creates a new account for the customer.
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
}
