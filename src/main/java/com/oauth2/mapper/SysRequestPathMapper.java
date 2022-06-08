package com.oauth2.mapper;

import com.oauth2.entity.SysRequestPath;
import com.oauth2.entity.SysRequestPathExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRequestPathMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    long countByExample(SysRequestPathExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int deleteByExample(SysRequestPathExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int insert(SysRequestPath record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int insertSelective(SysRequestPath record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    List<SysRequestPath> selectByExample(SysRequestPathExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    SysRequestPath selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysRequestPath record, @Param("example") SysRequestPathExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysRequestPath record, @Param("example") SysRequestPathExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysRequestPath record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_request_path
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysRequestPath record);
}