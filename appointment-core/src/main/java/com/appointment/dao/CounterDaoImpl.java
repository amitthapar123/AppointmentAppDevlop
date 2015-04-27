package com.appointment.dao;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Counter;

@Repository("counterDao")
public class CounterDaoImpl extends AbstractBaseDao<Counter> implements
		CounterDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public long getNextSequence(String name) {
		// get sequence id
		Query query = new Query(Criteria.where("name").is(name));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seqNum", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		options.upsert(true);

		Counter counter = mongoTemplate.findAndModify(query, update, options,
				Counter.class);

		return counter.getSeqNum();
	}

	@Override
	public Counter update(Counter entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
