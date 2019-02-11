package org.kiskampi.customerservice.customer;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "search-service")
interface CustomerSearchClient {

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @Headers("Content-Type: application/json")
    void indexCustomer(@RequestBody Customer customer);

}
