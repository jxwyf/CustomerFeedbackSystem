package com.dy.wind.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dy.wind.entity.DyFeedbackOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Hasee
 */
@Mapper
public interface DyFeedbackOrderMapper extends BaseMapper<DyFeedbackOrder> {
    /**
     * 查询所有并翻翻页
     * @param page
     * @return
     */
    IPage<DyFeedbackOrder> defaultAll(IPage<DyFeedbackOrder> page,@Param("feedbackName") String feedbackName);

    /**
     * 根据反馈单号进行更新问题类别和问题描述
     * @param singleNumber
     * @param category
     * @param problemDescription
     * @return
     */
    int updateBySingle(@Param("singleNumber") Long singleNumber,
                       @Param("category") String category,
                       @Param("problemDescription") String problemDescription);


    List<DyFeedbackOrder> selectCondition(@Param("singleNum") Long singleNum,
                                          @Param("feedbackName") String feedbackName,
                                          @Param("feedbackPhone") String feedbackPhone);
}