package com.yongze.project.service;

import com.yongze.project.model.MongoBaike;
import java.util.List;

/**
 * 百科对象用于操作MongoDB 服务类接口
 * @author YI
 * @date 2018-8-22 15:19:39
 */
public interface MongoDbBaiKeService {
    /**
     * 根据id查找对象
     * @param id 百科id
     * @return
     */
    MongoBaike findById(Integer id);

    /**
     * 添加文档
     * @param baike 对象
     * @return
     */
    MongoBaike addDict(MongoBaike baike);

    /**
     * 根据鄙视的数量查找
     * @param bad 鄙视数
     * @return
     */
    List<MongoBaike> queryBad(int bad);

    /**
     * 根据文档标签点一个赞给文章
     * @param tag   标签
     * @return
     */
    String addOne(String tag);

    /**
     * 根据标签分页查找
     * @param tag   标签
     * @param pageNum   当前页
     * @return
     */
    List<MongoBaike> findBaike(String tag, int pageNum);

    /**
     * 多条件查找
     * @param tag   标签
     * @param good  点赞数
     * @param bad   鄙视数
     * @return
     */
    List<MongoBaike> findBaike(String tag, int good, int bad);

    /**
     * 更新文档
     * @param baike
     * @return
     */
    MongoBaike updateDict(MongoBaike baike);

    /**
     * 根据id删除文档
     * @param id 文档id
     * @return
     */
    MongoBaike deleteDict(Integer id);
}