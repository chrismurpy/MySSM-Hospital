package com.murphy.mapper;

import com.murphy.vo.RegisterExcelVo;

import java.util.List;

/**
 * 导出Excel - Mapper
 *
 * @author murphy
 * @since 2021/8/4 11:02 下午
 */
public interface ExcelMapper {

    List<RegisterExcelVo> queryExcelInfo();

}
