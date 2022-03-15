package com.dy.wind.service.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dy.wind.entity.DyFeedbackOrder;
import com.dy.wind.exception.DyException;
import com.dy.wind.mapper.DyFeedbackOrderMapper;
import com.dy.wind.result.ResultCodeEnum;
import com.dy.wind.service.DyFeedbackOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hasee
 */
@Service
public class DyFeedbackOrderServiceImpl extends ServiceImpl<DyFeedbackOrderMapper, DyFeedbackOrder> implements DyFeedbackOrderService {
    @Autowired
    private DyFeedbackOrderMapper dyFeedbackOrderMapper;

    @Override
    public IPage<DyFeedbackOrder> selectAllOrder(Page<DyFeedbackOrder> page, String feedbackName) {
        return dyFeedbackOrderMapper.defaultAll(page,feedbackName);
    }

    /**
     * 根据反馈单编号查询数据
     *
     * @param singleNum
     * @return
     */
    @Override
    public List<DyFeedbackOrder> selectByLike(Long singleNum, String feedbackName, String feedbackPhone) {

        return dyFeedbackOrderMapper.selectCondition(singleNum,feedbackName,feedbackPhone);
    }

    /**
     * 根据反馈单号进行更新问题类别和问题描述
     * @param singleNumber
     * @param category
     * @param problemDescription
     */
    @Override
    public void updateOrder(Long singleNumber, String category, String problemDescription) {
        int countNum = dyFeedbackOrderMapper.updateBySingle(singleNumber, category, problemDescription);

        if (countNum != 1) {
            throw new DyException(ResultCodeEnum.FAIL);
        }
    }

}
