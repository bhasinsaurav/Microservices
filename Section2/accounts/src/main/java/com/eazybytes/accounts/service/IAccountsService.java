package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Creates a new account for the customer.
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetches accounts for a given mobile number.
     * @param mobileNumber
     */
    CustomerDto fetchAccounts(String mobileNumber);

    /**
     * Updates account details for the customer.
     * @param customerDto
     * @return
     */
    boolean updateAccount(CustomerDto customerDto);
}
