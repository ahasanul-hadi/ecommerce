package com.wsd.ecommerce.customer;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;

}
