package com.dy.wind.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dy.wind.entity.DyFeedbackOrder;
import com.dy.wind.result.Result;
import com.dy.wind.service.DyFeedbackOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hasee
 */
@Api(tags = "表单接口")
@RestController
@RequestMapping(value = "dy/feedback/order")
public class DyFeedOrderController {

    @Autowired
    private DyFeedbackOrderService dyFeedbackOrderService;
    /**
     * @Description:
     * @Param: [dyFeedbackOrder, request]
     * @return: com.dy.wind.result.Result
     * @Author: wind
     * @Date: 2022-03-01 13:29:45-
     **/
    @PostMapping(value = "insertOrder")
    @ApiOperation(value = "表单添加")
    public Result insertOrder(@RequestBody DyFeedbackOrder dyFeedbackOrder,
                              HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("username");
        dyFeedbackOrder.setSingleNumber(singleRandom());
        boolean save = dyFeedbackOrderService.save(dyFeedbackOrder);

        if (!save) {
            return Result.fail("添加失败");
        }
        return Result.ok("添加成功");
    }

    /**
     * 默认查询所有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "selectPage")
    @ApiOperation(value = "分页查询")
    public Result<Map> selectPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(required = false) String feedbackName) {
        Map<String, Object> returnMap = new HashMap<>();
        Page<DyFeedbackOrder> page = new Page<>(pageNum, pageSize);
        IPage<DyFeedbackOrder> queryOrderVoIPage = dyFeedbackOrderService.selectAllOrder(page, feedbackName);
        returnMap.put("count", queryOrderVoIPage.getTotal());
        returnMap.put("data", queryOrderVoIPage.getRecords());
        return Result.ok(returnMap);
    }

    @PostMapping(value = "selectBySingle")
    @ApiOperation(value = "条件查询反馈单")
    public Result selectCondition(@RequestParam(required = false) Long singleNum,
                                  @RequestParam(required = false) String feedbackName,
                                  @RequestParam(required = false) String feedbackPhone) {
        List<DyFeedbackOrder> dyFeedbackOrder = dyFeedbackOrderService.selectByLike(singleNum, feedbackName, feedbackPhone);

        return Result.ok(dyFeedbackOrder);
    }


    @PostMapping(value = "updateByLike")
    @ApiOperation(value = "修改反馈")
    public Result update(@RequestParam Long singleNumber,
                         @RequestParam String category,
                         @RequestParam String problemDescription) {

        dyFeedbackOrderService.updateOrder(singleNumber, category, problemDescription);
        return Result.ok();
    }

    // 根据当前时间生成随机单号
    public static Long singleRandom() {
        //获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return Long.parseLong(dateFormat.format(date).trim());
    }

}
