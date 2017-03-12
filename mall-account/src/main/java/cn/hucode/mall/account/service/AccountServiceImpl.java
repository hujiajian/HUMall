package cn.hucode.mall.account.service;

import cn.hucode.mall.account.model.Account;
import cn.hucode.mall.account.dao.AccountDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 账号表 服务
 *
 * @author Bigjin
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

//    @Override
//    public List<Account> getListByPage(PageBounds pageBounds, Conditions conditions){
//        return accountDao.queryAll(pageBounds);
//    }

    public void saveAccount(Account account){
        accountDao.insert(account);
    }

    public void updateAccount(Account account){
        accountDao.updateByPrimaryKey(account);
    }

    public void deleteAccount(Account account){
        accountDao.delete(account);
    }

}
