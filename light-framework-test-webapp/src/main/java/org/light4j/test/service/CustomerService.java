package org.light4j.test.service;

import org.light4j.framework.annotation.Service;
import org.light4j.framework.helper.DatabaseHelper;
import org.light4j.test.model.Customer;

import java.util.List;

/**
 * 提供客户数据服务
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        Customer customer = new Customer();
        customer.setContact("1359888");
        customer.setEmail("wmt@123");
        customer.setId(1);
        customer.setName("wmt");
//        return Arrays.asList(customer);
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

//    /**
//     * 获取客户
//     */
//    public Customer getCustomer(long id) {
//        String sql = "SELECT * FROM customer WHERE id = ?";
//        return DatabaseHelper.queryEntity(Customer.class, sql, id);
//    }
//
//    /**
//     * 创建客户
//     */
//    public boolean createCustomer(Map<String, Object> fieldMap) {
//        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
//    }
//
//    /**
//     * 更新客户
//     */
//    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
//        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
//    }
//
//    /**
//     * 删除客户
//     */
//    public boolean deleteCustomer(long id) {
//        return DatabaseHelper.deleteEntity(Customer.class, id);
//    }

}
