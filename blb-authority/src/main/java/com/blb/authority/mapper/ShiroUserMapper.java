package com.blb.authority.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShiroUserMapper {

	@Select("select password from blbuser where username = #{arg0}")
	public String getPassword(String username);

	@Select("select r.role from role r left join blbuser bu on bu.rolerid = r.resourceid where bu.username = #{arg0}")
	public String getRole(String username);
}
