package com.study.boot.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.boot.persistence.Transaction1Mapper;
import com.study.boot.persistence.Transaction2Mapper;

@Service
@Qualifier("buyTicketServiceImpl_TransactionTemplate")
public class BuyTicketServiceImpl_TransactionTemplate implements BuyTicketService{


	@Autowired
	Transaction1Mapper dao1;
	
	@Autowired
	Transaction2Mapper dao2;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Override
	public int buy(String customerid, int amount, String error) {
		
		
		try {
			
			//트랜잭션 범위의 비지니스 로직을 감싸서 볼 수 있고, 커밋과 롤백이 자동으로 처리된다.
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				//내부에 비지니스 로직 작성
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					dao1.buy(customerid, amount);//이게 만약 출금처리
					
					//의도적 에러발생
					if(error.equals("1")) {
						int n = 10/0;
					}
					
					dao2.buy(customerid, amount);//입금처리 라면 ....?
				}
			});
			
			return 1;
			
		}catch(Exception e) {
			return 0;
		}
	}

}
