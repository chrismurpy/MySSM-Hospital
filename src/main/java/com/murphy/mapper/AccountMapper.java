package com.murphy.mapper;

import com.murphy.pojo.BeHosp;
import com.murphy.vo.query.QueryAccountVo;

import java.util.List;

/**
 * 住院结算 - Account - 多条件查询
 *
 * @author murphy
 * @since 2021/8/7 11:36 上午
 */
public interface AccountMapper {
    /**
     * 多条件动态查询 - 结算情况
     * @param vo
     * @return
     */
    List<BeHosp> queryByVo(QueryAccountVo vo);
}
