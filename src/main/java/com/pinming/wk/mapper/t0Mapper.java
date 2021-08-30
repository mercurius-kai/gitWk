package com.pinming.wk.mapper;

import com.pinming.wk.model.t0;
import com.pinming.wk.model.t0Example;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface t0Mapper {
    long countByExample(t0Example example);

    int deleteByExample(t0Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(t0 record);

    int insertSelective(t0 record);

    List<t0> selectByExample(t0Example example);

    int updateByExampleSelective(@Param("record") t0 record, @Param("example") t0Example example);

    int updateByExample(@Param("record") t0 record, @Param("example") t0Example example);
}