package cn.hucode.mall.account.service;

import cn.hucode.mall.account.model.Account;

/**
 * 账号表 服务层
 *
 * @author hujj
 */
public interface AccountService {

//   List<Account> getListByPage(PageBounds pageBounds);

   void saveAccount(Account account);

   void updateAccount(Account account);

   void deleteAccount(Account account);
}
