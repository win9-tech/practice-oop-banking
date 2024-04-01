package bank.clerk;

import bank.BankSystem;
import exception.account.BelowTargetException;
import exception.account.InsufficienBalancetException;
import exception.clerk.InputAccountNumberException;
import exception.system.AccountStatusException;
import exception.system.NotFoundAccountException;
import lombok.RequiredArgsConstructor;
import validate.ValidationUtils;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class WithdrawClerk implements Clerk{
    private static final String CLERK_REQUEST = "[출금] 계좌, 금액을 작성해주세요";

    private final BankSystem bankSystem;

    public void action() {
        System.out.println(CLERK_REQUEST);
        withdraw();}

    public void withdraw() {
        while (true){
            try {
                String accountNum = getUserInput();
                ValidationUtils.isValidAccountNumber(accountNum);
                BigDecimal balance = ValidationUtils.createBalance(getUserInput());
                String balanceResult = bankSystem.withdraw(accountNum, balance);
                resultMessage(balanceResult);
                break;
            }catch (NotFoundAccountException | InputAccountNumberException | BelowTargetException |
                    InsufficienBalancetException | AccountStatusException e) {
                System.out.println(e.getMessage());
            }}}}