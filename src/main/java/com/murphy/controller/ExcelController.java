package com.murphy.controller;

import com.murphy.service.ExcelService;
import com.murphy.vo.RegisterExcelVo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * 导出Excel - Controller
 *
 * @author murphy
 * @since 2021/8/4 5:57 下午
 */
@Controller
public class ExcelController {

    @Resource
    private ExcelService excelService;

    /**
     * 导出 Excel
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "excel", method = RequestMethod.GET)
    public void excel(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<RegisterExcelVo> list = excelService.queryExcelInfo();
        System.out.println(list);
        // 创建Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建Sheet页
        HSSFSheet sheet = wb.createSheet("挂号信息表");
        // 创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("病例号");
        titleRow.createCell(1).setCellValue("病人名称");
        titleRow.createCell(2).setCellValue("主治医生");
        titleRow.createCell(3).setCellValue("挂号时间");
        titleRow.createCell(4).setCellValue("挂号科室");
        titleRow.createCell(5).setCellValue("挂号状态");
        // 遍历将数据放到Excel列中
        String state = "";
        for (RegisterExcelVo register: list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(register.getRe_id());
            dataRow.createCell(1).setCellValue(register.getRe_name());
            dataRow.createCell(2).setCellValue(register.getD_name());
            dataRow.createCell(3).setCellValue(register.getRe_createTime().toString());
            dataRow.createCell(4).setCellValue(register.getD_keshi());
            if (register.getRe_state() == 0) {
                state = "挂号";
            } else if (register.getRe_state() == 1) {
                state = "已住院";
            } else if (register.getRe_state() == 2) {
                state = "已出院";
            } else {
                state = "已退号";
            }
            dataRow.createCell(5).setCellValue(state);
        }

        // 设置下载时客户端Excel的名称
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=" + new String("挂号信息".getBytes(),
                "iso-8859-1") + ".xls");

        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
