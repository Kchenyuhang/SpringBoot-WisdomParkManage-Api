package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@SpringBootTest
class AddressBookRepositoryTest {
    @Resource
    private AddressBookRepository addressBookRepository;
    @Resource
    private UserAccountRepository userAccountRepository;

    @Test
    void getAddressBookByPhoneNumber() {
        System.out.println(addressBookRepository.getAddressBookByUserId("1"));
    }


}