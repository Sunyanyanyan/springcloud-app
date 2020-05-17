package com.cn.springcloudprovider.mapper;

import com.cn.springcloudprovider.entity.Power;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PowerMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Power queryById(String pId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Power> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param power 实例对象
     * @return 对象列表
     */
    List<Power> queryAll(Power power);

    /**
     * 新增数据
     *
     * @param power 实例对象
     * @return 影响行数
     */
    int insert(Power power);

    /**
     * 修改数据
     *
     * @param power 实例对象
     * @return 影响行数
     */
    int update(Power power);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(String pId);

}
