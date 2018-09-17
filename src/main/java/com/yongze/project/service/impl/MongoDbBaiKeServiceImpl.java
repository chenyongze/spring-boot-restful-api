package com.yongze.project.service.impl;

import com.yongze.project.dao.MongoDbBaiKeDao;
import com.yongze.project.model.MongoBaike;
import com.yongze.project.service.MongoDbBaiKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * 百科对象用于操作MongoDB 服务类
 * @author YI
 * @date 2018-3-20 09:58:18
 */
@Service
public class MongoDbBaiKeServiceImpl implements MongoDbBaiKeService {
    @Autowired
    MongoDbBaiKeDao mongoDbBaiKeDao;

    @Override
    public MongoBaike findById(Integer id) {
        return mongoDbBaiKeDao.findById(id);
    }

    @Override
    public MongoBaike addDict(MongoBaike baike) {
        baike.setCrateDate(new Date());
        baike.setUpdateDate(new Date());

        return mongoDbBaiKeDao.addDict(baike);
    }

    @Override
    public List<MongoBaike> queryBad(int bad) {
        Criteria criteria = where("bad").gte(bad);

        return mongoDbBaiKeDao.queryBad(criteria);
    }

    @Override
    public String addOne(String tag) {
        Criteria criteria = where("tag").in(tag);
        Update update = new Update();
        update.inc("good", 1);

        long updateResult = mongoDbBaiKeDao.addOne(criteria, update);

        StringBuilder append = new StringBuilder().append("成功修改--->").append(updateResult);
        return append.toString();
    }

    @Override
    public List<MongoBaike> findBaike(String tag, int pageNum) {
        Criteria criteria = where("tag").in(tag);
        Query query = query(criteria);
        //查询总数
        long totalCount = mongoDbBaiKeDao.count(query);
        //每页个数
        int numOfPage = 10;
        //计算总数
        long totalPage =
                totalCount % numOfPage == 0 ? (totalCount / numOfPage) : (totalCount / numOfPage + 1);

        int skip = (pageNum - 1) * numOfPage;
        query.skip(skip).limit(numOfPage);

        List<MongoBaike> baike = mongoDbBaiKeDao.findBaike(query, numOfPage);

        return baike;
    }

    @Override
    public List<MongoBaike> findBaike(String tag, int good, int bad) {
        Criteria criteria1 = where("tag").in(tag);
        Criteria criteria2 = where("bad").gt(bad);
        Criteria criteria3 = where("good").lt(good);

        Query query = query(criteria1.andOperator(criteria2, criteria3));

        List<MongoBaike> baike = mongoDbBaiKeDao.findBaike(query);
        return baike;
    }

    @Override
    public MongoBaike updateDict(MongoBaike baike) {
        baike.setUpdateDate(new Date());

        return mongoDbBaiKeDao.updateDict(baike);
    }

    @Override
    public MongoBaike deleteDict(Integer id) {
        MongoBaike baike = new MongoBaike();
        baike.setId(id);

        return mongoDbBaiKeDao.deleteDict(baike);
    }
}