package com.murphy.test;

import com.github.pagehelper.PageInfo;
import com.murphy.mapper.DoctorMapper;
import com.murphy.mapper.RegisterMapper;
import com.murphy.pojo.BeHosp;
import com.murphy.pojo.Register;
import com.murphy.pojo.RegisterExample;
import com.murphy.service.BeHospService;
import com.murphy.service.ExcelService;
import com.murphy.service.RegisterService;
import com.murphy.vo.RegisterExcelVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service方法调用
 *
 * @author murphy
 * @since 2021/7/27 2:13 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class ServiceTest {
    @Resource
    private RegisterService registerService;
    @Resource
    private RegisterMapper registerMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private ExcelService excelService;
    @Resource
    private BeHospService beHospService;

    @Test
    public void test() {
        PageInfo<Register> registerPageInfo = registerService.queryByPage(1, 5, null);
        System.out.println(registerPageInfo);
    }

    @Test
    public void test2() {
        PageInfo<Register> registerPageInfo = registerService.queryByPage1(1, 5, null);
        System.out.println(registerPageInfo);
    }

    @Test
    public void test1() {
        PageInfo<Register> pageInfo = registerService.queryByPage(1, 5, null);
        System.out.println(pageInfo);
    }

    @Test
    public void test3() {
        List<Register> registers = registerMapper.selectByExample(null);
        for (Register register : registers) {
            register.setDoctor(doctorMapper.selectByPrimaryKey(register.getD_id()));
            System.out.println(register);
        }
    }

    @Test
    public void test4() {
        List<RegisterExcelVo> list = excelService.queryExcelInfo();
//        System.out.println(list);
        for (RegisterExcelVo registerExcelVo : list) {
            System.out.println(registerExcelVo.getRe_createTime().toString());
        }
    }

    @Test
    public void test5() {
        PageInfo<BeHosp> beHospPageInfo = beHospService.queryByPage(1, 5, null);
        System.out.println(beHospPageInfo);
    }

    @Test
    public void test6() {
        BeHosp beHosp = beHospService.queryById(1009);
        System.out.println(beHosp);
    }

    @Test
    public void test7() {
        System.out.println("GitHub");
    }



    
}
