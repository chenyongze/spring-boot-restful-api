package com.yongze.project.dao;

import com.mongodb.client.result.UpdateResult;
import com.yongze.project.model.MongoBaike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * MongoDB操作Baike
 * @author YI
 * @date 2018-8-22 15:17:44
 */
@Repository
public class MongoDbBaiKeDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public MongoBaike findById(Integer id) {

        MongoBaike dict = mongoTemplate.findById(id, MongoBaike.class);
        return dict;
    }

    public MongoBaike addDict(MongoBaike baike) {
        mongoTemplate.insert(baike);

        return baike;
    }

    public List<MongoBaike> queryBad(Criteria criteria) {
        List<MongoBaike> list = mongoTemplate.find(query(criteria), MongoBaike.class);

        return list;
    }

    public long addOne(Criteria criteria, Update update) {
        UpdateResult result = mongoTemplate.updateMulti(query(criteria), update, MongoBaike.class);

        return result.getModifiedCount();
    }

    public List<MongoBaike> findBaike(Query query, int pageNum) {

        List<MongoBaike> list = mongoTemplate.find(query, MongoBaike.class);
        return list;
    }

    public List<MongoBaike> findBaike(Query query) {
        List<MongoBaike> list = mongoTemplate.find(query, MongoBaike.class);

        return list;
    }

    public long count(Query query) {
        long totalCount = mongoTemplate.count(query, MongoBaike.class);

        return totalCount;
    }

    public MongoBaike updateDict(MongoBaike baike) {
        mongoTemplate.save(baike);

        return baike;
    }

    public MongoBaike deleteDict(MongoBaike baike) {
        mongoTemplate.remove(baike);

        return baike;
    }
}