package com.dy.wind.config;

import com.dy.wind.entity.DyUser;
import com.dy.wind.mapper.DyUserMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * @author Hasee
 * @Description TODO 业务校验
 * @date 2022/3/2-19:02
 */
@Slf4j
public class UserValidation<T extends Annotation> implements ConstraintValidator<T, DyUser> {
    protected Predicate<DyUser> predicate = c -> true;

    @Override
    public void initialize(T constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Resource
    protected DyUserMapper dyUserMapper;

    @Override
    public boolean isValid(DyUser dyUser, ConstraintValidatorContext context) {
        return dyUserMapper == null || predicate.test(dyUser);
    }

    /**
     * 校验用户是否唯一
     * 即判断数据库是否存在当前新用户的信息，如用户名
     */
    public static class UniqueUserValidator extends UserValidation<UniqueUser>{
        @Override
        public void initialize(UniqueUser uniqueUser) {
            predicate = c -> !dyUserMapper.selectByUsername(c.getUsername());
        }
    }

    /**
     * 校验是否与其他用户冲突
     * 将用户名改成与现有完全不重复的，或者只与自己重复的，就不算冲突
     */
    public static class NotConflictUserValidator extends UserValidation<NotConflictUser>{
        @Override
        public void initialize(NotConflictUser notConflictUser) {
            predicate = c -> {
                log.info("user detail is {}",c);
                Collection<DyUser> collection = dyUserMapper.selectByUserName(c.getUsername());
                // 将用户名、邮件、电话改成与现有完全不重复的，或者只与自己重复的，就不算冲突
                return collection.isEmpty() || (collection.size() == 1 && collection.iterator().next().getUsername().equals(c.getUid()));
            };
        }
    }

}
