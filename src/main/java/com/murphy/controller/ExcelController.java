package com.murphy.controller;

import com.murphy.service.ExcelService;
import com.murphy.vo.excel.ExcelBeHospVo;
import com.murphy.vo.excel.ExcelDoctorVo;
import com.murphy.vo.excel.ExcelDrugVo;
import com.murphy.vo.excel.ExcelRegisterVo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 导出Excel - Controller
 *
 * @author murphy
 * @since 2021/8/4 5:57 下午
 */
@Controller
@RequestMapping("excel")
@ResponseBody
public class ExcelController {

    @Resource
    private ExcelService excelService;

    /**
     * 导出 Excel
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public void excel(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<ExcelRegisterVo> list = excelService.queryExcelInfo();
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
        for (ExcelRegisterVo register: list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(register.getRe_id());
            dataRow.createCell(1).setCellValue(register.getRe_name());
            dataRow.createCell(2).setCellValue(register.getD_name());
            dataRow.createCell(3).setCellValue(register.getRe_createTime().toString());
            dataRow.createCell(4).setCellValue(register.getD_keshi());
            if (register.getRe_state() == 0) {
                state = "已挂号";
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

    /**
     * 导出 Excel
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "beHosp", method = RequestMethod.GET)
    public void excelBeHosp(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<ExcelBeHospVo> list = excelService.queryBeHospInfo();
        System.out.println(list);
        // 创建Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建Sheet页
        HSSFSheet sheet = wb.createSheet("住院信息表");
        // 创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("病例号");
        titleRow.createCell(1).setCellValue("病人名称");
        titleRow.createCell(2).setCellValue("床位号");
        titleRow.createCell(3).setCellValue("联系电话");
        titleRow.createCell(4).setCellValue("押金缴纳");
        titleRow.createCell(5).setCellValue("主治医生");
        titleRow.createCell(6).setCellValue("入院时间");
        titleRow.createCell(7).setCellValue("科室");
        titleRow.createCell(8).setCellValue("当前状态");
        // 遍历将数据放到Excel列中
        String state = "";
        for (ExcelBeHospVo beHosp : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(beHosp.getBeH_id());
            dataRow.createCell(1).setCellValue(beHosp.getRe_name());
            dataRow.createCell(2).setCellValue(beHosp.getBeH_bedNum());
            dataRow.createCell(3).setCellValue(beHosp.getRe_phone());
            dataRow.createCell(4).setCellValue(beHosp.getBeH_total() + " / " + beHosp.getBeH_antecedent());
            dataRow.createCell(5).setCellValue(beHosp.getD_name());
            dataRow.createCell(6).setCellValue(beHosp.getBeH_createTime().toString());
            dataRow.createCell(7).setCellValue(beHosp.getD_keshi());
            if (beHosp.getBeH_closePrice() == 1 && beHosp.getBeH_state() == 0) {
                state = "已结算";
            } else if (beHosp.getBeH_closePrice() == 1 && beHosp.getBeH_state() == 1) {
                state = "已退院";
            } else if (beHosp.getBeH_closePrice() == 1 && beHosp.getBeH_state() == 2) {
                state = "已出院";
            } else if (beHosp.getBeH_closePrice() == 0 && beHosp.getRe_state() == 1){
                state = "已住院";
            }
            dataRow.createCell(8).setCellValue(state);
        }

        // 设置下载时客户端Excel的名称
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=" + new String("住院信息".getBytes(),
                "iso-8859-1") + ".xls");

        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 导出 Excel - 医生信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "doc", method = RequestMethod.GET)
    public void excelDoctor(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<ExcelDoctorVo> doctors = excelService.queryDoctorInfo();
        System.out.println(doctors);
        // 创建Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建Sheet页
        HSSFSheet sheet = wb.createSheet("住院信息表");
        // 创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("医生编号");
        titleRow.createCell(1).setCellValue("医生名称");
        titleRow.createCell(2).setCellValue("性别");
        titleRow.createCell(3).setCellValue("联系电话");
        titleRow.createCell(4).setCellValue("座机");
        titleRow.createCell(5).setCellValue("电子邮箱");
        titleRow.createCell(6).setCellValue("入院时间");
        titleRow.createCell(7).setCellValue("科室");
        titleRow.createCell(8).setCellValue("学历");
        titleRow.createCell(9).setCellValue("就职状态");
        // 遍历将数据放到Excel列中
        String sex = "";
        String state = "";
        for (ExcelDoctorVo doctor : doctors) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(doctor.getD_id());
            dataRow.createCell(1).setCellValue(doctor.getD_name());
            if (doctor.getD_sex() == 0) {
                sex = "女";
            } else {
                sex = "男";
            }
            dataRow.createCell(2).setCellValue(sex);
            dataRow.createCell(3).setCellValue(doctor.getD_phone());
            dataRow.createCell(4).setCellValue(doctor.getD_telPhone());
            dataRow.createCell(5).setCellValue(doctor.getD_email());
            dataRow.createCell(6).setCellValue(doctor.getD_inTime().toString());
            dataRow.createCell(7).setCellValue(doctor.getD_keshi());
            dataRow.createCell(8).setCellValue(doctor.getD_edu());
            if (doctor.getD_state() == 0) {
                state = "在职";
            } else {
                state = "已离职";
            }
            dataRow.createCell(9).setCellValue(state);
        }

        // 设置下载时客户端Excel的名称
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=" + new String("医生信息".getBytes(),
                "iso-8859-1") + ".xls");

        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 导出 Excel - 药品信息
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "drug", method = RequestMethod.GET)
    public void excelDrug(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<ExcelDrugVo> drugs = excelService.queryDrugInfo();
        System.out.println(drugs);
        // 创建Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建Sheet页
        HSSFSheet sheet = wb.createSheet("药品信息表");
        // 创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("药品编号");
        titleRow.createCell(1).setCellValue("药品名称");
        titleRow.createCell(2).setCellValue("药品种类");
        titleRow.createCell(3).setCellValue("简要说明");
        titleRow.createCell(4).setCellValue("保质期");
        titleRow.createCell(5).setCellValue("生产厂商");
        titleRow.createCell(6).setCellValue("服用指南");
        titleRow.createCell(7).setCellValue("库存量");
        titleRow.createCell(8).setCellValue("药品状态");
        // 遍历将数据放到Excel列中
        String state = "";
        for (ExcelDrugVo drug : drugs) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(drug.getDr_id());
            dataRow.createCell(1).setCellValue(drug.getDr_name());
            dataRow.createCell(2).setCellValue(drug.getDr_type());
            dataRow.createCell(3).setCellValue(drug.getDr_simpleDesc());
            dataRow.createCell(4).setCellValue(drug.getDr_expiration());
            dataRow.createCell(5).setCellValue(drug.getDr_factory());
            dataRow.createCell(6).setCellValue(drug.getDr_direction());
            dataRow.createCell(7).setCellValue(drug.getDr_number());
            if (drug.getDr_state() == 0 && drug.getDr_number() != 0) {
                state = "销售中";
            } else if (drug.getDr_state() == 0 && drug.getDr_number() == 0) {
                state = "缺货中";
            } else {
                state = "已下架";
            }
            dataRow.createCell(8).setCellValue(state);

        }

        // 设置下载时客户端Excel的名称
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=" + new String("药品信息".getBytes(),
                "iso-8859-1") + ".xls");

        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
