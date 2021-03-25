package com.MJ.converterMaciejJanik.db.repositiories;

import com.MJ.converterMaciejJanik.db.collections.ConversionInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepo extends MongoRepository<ConversionInfo,String> {
}
