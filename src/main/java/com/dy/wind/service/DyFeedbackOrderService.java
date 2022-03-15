package com.dy.wind.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dy.wind.entity.DyFeedbackOrder;

import java.util.List;

/**
 * @author Hasee
 */
public interface DyFeedbackOrderService extends IService<DyFeedbackOrder> {

    IPage<DyFeedbackOrder> selectAllOrder(Page<DyFeedbackOrder> page, String feedbackName);

    List<DyFeedbackOrder> selectByLike(Long singleNum, String feedbackName, String feedbackPhone);

    /**
     * 根据反馈单号进行更新问题类别和问题描述
     * @param singleNumber
     * @param category
     * @param problemDescription
     */
    void updateOrder(Long singleNumber, String category, String problemDescription);

}
