public interface AccountService {

    void withdraw(int accountId, float amount) throws UnknownAccountException, NotEnoughMoneyException, NegativeAmountException;

    void balance(int accountId) throws UnknownAccountException;

    void deposit(int accountId, float amount) throws UnknownAccountException, NegativeAmountException;

    void transfer(int fromAccountId, int toAccountId, float amount) throws UnknownAccountException, NotEnoughMoneyException, NegativeAmountException;
}
