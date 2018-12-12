/**
 * 
 */
package com.library.rest.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.rest.model.Charge;
import com.library.rest.repository.ChargeRepository;
import com.library.rest.service.ChargeService;

/**
 * @author ANIZAM
 *
 */

@Transactional
@Service
public class ChargeServiceImpl implements ChargeService {

	@Autowired
	private ChargeRepository chargeRepository;
	
	@Override
	public Charge saveCharge(Charge charge) {
		// TODO Auto-generated method stub
		int totalData = chargeRepository.getTotalData();
		int seqId = 0;	
		if(totalData == 0) {
			seqId = 1;
		}else {
			seqId = chargeRepository.getSequenceId()+1;
		}
    	charge.setId(seqId);
    	String idcharge = Integer.valueOf(seqId).toString();
    	charge.setidcharge("CHR".concat(idcharge));
    	charge.setStatus(true);
		return chargeRepository.save(charge);
	}
	
}
