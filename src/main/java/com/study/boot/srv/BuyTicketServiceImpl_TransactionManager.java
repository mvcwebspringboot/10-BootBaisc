package com.study.boot.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.study.boot.persistence.Transaction1Mapper;
import com.study.boot.persistence.Transaction2Mapper;

@Service
@Qualifier("buyTicketServiceImpl_TransactionManager")
public class BuyTicketServiceImpl_TransactionManager implements BuyTicketService{


	@Autowired
	Transaction1Mapper dao1;
	
	@Autowired
	Transaction2Mapper dao2;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	TransactionDefinition definition;
	
	
	@Override
	public int buy(String customerid, int amount, String error) {
		
		TransactionStatus ststus = transactionManager.getTransaction(definition);
		
		try {
			
			dao1.buy(customerid, amount);//이게 만약 출금처리
			
			//의도적 에러발생
			if(error.equals("1")) {
				int n = 10/0;
			}
			
			dao2.buy(customerid, amount);//입금처리 라면 ....?
			
			transactionManager.commit(ststus);
			return 1;
			
		}catch(Exception e) {
			transactionManager.rollback(ststus);
			return 0;
		}
	}

}
