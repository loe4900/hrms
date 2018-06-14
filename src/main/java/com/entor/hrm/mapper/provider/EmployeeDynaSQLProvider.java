package com.entor.hrm.mapper.provider;

import com.entor.hrm.po.Employee;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.EMPLOYEE_TABLE;

/**
 * 用户表SQL构建器
 */
public class EmployeeDynaSQLProvider {

    /**
     * 分页动态查询通知
     *
     * @param params
     * @return
     */
    public String selectWithParams(Map<String, Object> params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM(EMPLOYEE_TABLE);
            if (params.get("employee") != null) {
                Employee employee = (Employee) params.get("employee");
                if (employee.getDept() !=null) {
                    WHERE("dept_id = #{employee.dept.id} ");
                }
                if (employee.getJob() !=null){
                    WHERE("job_id = #{employee.job.id}");
                }
                if (!StringUtils.isEmpty(employee.getName())){
                    WHERE("name like concat ('%',#{employee.name},'%')");
                }
                if (!StringUtils.isEmpty(employee.getCardId())){
                    WHERE("card_id = #{employee.cardId}");
                }
                if (!StringUtils.isEmpty(employee.getAddress())){
                    WHERE("address = #{employee.address}");
                }
                if (!StringUtils.isEmpty(employee.getEmail())){
                    WHERE("email = #{employee.email}");
                }
                if (employee.getSex() != null){
                    WHERE("sex=#{employee.sex}");
                }
                if (employee.getCreateDate() != null) {
                    WHERE("date_format(create_date, '%Y-%m-%d') = date_format(#{notice.createDate}, '%Y-%m-%d') ");
                }
            }
        }}.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
        }
        return sql;
    }
    /**
     * 动态查询通知总记录数
     *
     * @param params
     * @return
     */
    public String count(Map<String, Object> params) {
        String sql = new SQL() {{
            SELECT("count(*)");
            FROM(EMPLOYEE_TABLE);
            if (params.get("employee") != null) {
                Employee employee = (Employee) params.get("employee");
                if (employee.getDept() !=null) {
                    WHERE("dept_id = #{employee.dept.id} ");
                }
                if (employee.getJob() !=null){
                    WHERE("job_id = #{employee.job.id}");
                }
                if (!StringUtils.isEmpty(employee.getName())){
                    WHERE("name like concat ('%',#{employee.name},'%')");
                }
                if (!StringUtils.isEmpty(employee.getCardId())){
                    WHERE("card_id = #{employee.cardId}");
                }
                if (!StringUtils.isEmpty(employee.getAddress())){
                    WHERE("address = #{employee.address}");
                }
                if (!StringUtils.isEmpty(employee.getEmail())){
                    WHERE("email = #{employee.email}");
                }
                if (employee.getSex() != null){
                    WHERE("sex=#{employee.sex}");
                }
                if (employee.getCreateDate() != null) {
                    WHERE("date_format(create_date, '%Y-%m-%d') = date_format(#{notice.createDate}, '%Y-%m-%d') ");
                }
            }
        }}.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
        }
        return sql;
    }
    /**
     * 动态更新通知
     *
     * @param employee
     * @return
     */
    public String updateEmployee(Employee employee) {
        return new SQL() {{
            UPDATE(EMPLOYEE_TABLE);
            if (employee.getDept() !=null) {
                SET("dept_id=#{dept.id}");
            }
            if (employee.getJob() !=null) {
                SET("job_id=#{job.id}");
            }
            if (!StringUtils.isEmpty(employee.getName())) {
                SET("name=#{name}");
            }
            if (!StringUtils.isEmpty(employee.getCardId())) {
                SET("card_id=#{cardId}");
            }if (!StringUtils.isEmpty(employee.getAddress())) {
                SET("address=#{address}");
            }
            if (!StringUtils.isEmpty(employee.getPostcode())) {
                SET("post_code=#{postcode}");
            }
            if (!StringUtils.isEmpty(employee.getTel())) {
                SET("tel=#{tel}");
            }
            if (!StringUtils.isEmpty(employee.getPhone())) {
                SET("phone=#{phone}");
            }
            if (!StringUtils.isEmpty(employee.getQqNum())) {
                SET("qq_num=#{qqNum}");
            }
            if (!StringUtils.isEmpty(employee.getEmail())) {
                SET("email=#{email}");
            }
            if (employee.getSex() != null) {
                SET("sex=#{sex}");
            }
            if (!StringUtils.isEmpty(employee.getParty())) {
                SET("party=#{party}");
            }
            if (!StringUtils.isEmpty(employee.getBirthday())) {
                SET("birthday=#{birthday}");
            }
            if (!StringUtils.isEmpty(employee.getRace())) {
                SET("race=#{race}");
            }
            if (!StringUtils.isEmpty(employee.getEducation())) {
                SET("education=#{education}");
            }
            if (!StringUtils.isEmpty(employee.getSpeciality())) {
                SET("speciality=#{speciality}");
            }
            if (!StringUtils.isEmpty(employee.getHobby())) {
                SET("hobby=#{hobby}");
            }
            if (!StringUtils.isEmpty(employee.getRemark())) {
                SET("remark=#{remark}");
            }
            if (employee.getCreateDate() != null) {
                SET("createDate=#{createDate}");
            }
            WHERE(" id=#{id} ");
        }}.toString();
    }

    /**
     * 根据id批量删除通知
     *
     * @param params
     * @return
     */
    public String batchDeleteEmployee(Map<String, Object> params) {
        return CommonDynaSQLProvider.batchDelete(EMPLOYEE_TABLE, params);
    }

    /**
     * 动态插入通知
     *
     * @param employee
     * @return
     */
    public String insertEmployee(Employee employee) {
        return new SQL() {{
            INSERT_INTO(EMPLOYEE_TABLE);
            if (employee.getId() != null) {
                VALUES("id", "#{id}");
            }
            if (employee.getDept() != null) {
                VALUES("dept_id", "#{dept.id}");
            }
            if (employee.getJob() != null) {
                VALUES("job_id", "#{job.id}");
            }
            if (!StringUtils.isEmpty(employee.getName())){
                VALUES("name","#{name}");
            }
            if (!StringUtils.isEmpty(employee.getCardId())){
                VALUES("card_id","#{cardId}");
            }
            if (!StringUtils.isEmpty(employee.getAddress())){
                VALUES("address","#{address}");
            }
            if (!StringUtils.isEmpty(employee.getPostcode())){
                VALUES("post_code","#{postcode}");
            }
            if (!StringUtils.isEmpty(employee.getTel())){
                VALUES("tel","#{tel}");
            }
            if (!StringUtils.isEmpty(employee.getPhone())){
                VALUES("phone","#{phone}");
            }
            if (!StringUtils.isEmpty(employee.getQqNum())){
                VALUES("qq_num","#{qqNum}");
            }
            if (!StringUtils.isEmpty(employee.getEmail())){
                VALUES("email","#{email}");
            }
            if (employee.getSex() != null){
                VALUES("sex","#{sex}");
            }
            if (!StringUtils.isEmpty(employee.getParty())){
                VALUES("party","#{party}");
            }
            if (!StringUtils.isEmpty(employee.getBirthday())){
                VALUES("birthday","#{birthday}");
            }
            if (!StringUtils.isEmpty(employee.getRace())){
                VALUES("race","#{race}");
            }
            if (!StringUtils.isEmpty(employee.getEducation())){
                VALUES("education","#{education}");
            }
            if (!StringUtils.isEmpty(employee.getSpeciality())){
                VALUES("speciality","#{speciality}");
            }
            if (!StringUtils.isEmpty(employee.getHobby())){
                VALUES("hobby","#{hobby}");
            }
            if (!StringUtils.isEmpty(employee.getRemark())){
                VALUES("remark","#{remark}");
            }
            if (employee.getCreateDate() != null){
                VALUES("createDate","#{createDate}");
            }
        }}.toString();
    }
}
