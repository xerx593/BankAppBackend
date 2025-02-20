package mzatka.bankappbackend.services;

import mzatka.bankappbackend.models.entities.Account;
import mzatka.bankappbackend.models.entities.Customer;
import mzatka.bankappbackend.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static mzatka.bankappbackend.models.enums.ProductType.CHECKING_ACCOUNT;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

  private final ProductService productService;
  private final AccountRepository accountRepository;

  public AccountServiceImpl(ProductService productService, AccountRepository accountRepository) {
    this.productService = productService;
    this.accountRepository = accountRepository;
  }

  @Override
  public Account createNewAccount(Customer customer) {
    Account account = new Account(customer);
    account.getProducts().add(productService.createProduct(CHECKING_ACCOUNT, account));
    accountRepository.save(account);
    return account;
  }
}
