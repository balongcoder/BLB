package com.blb.authority.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@Mapper
@CacheConfig(cacheNames = "users")
public interface ShiroUserMapper {

	@Select("select password from blbuser where username = #{arg0}")
	public String getPassword(String username);

	@Select("select r.role from role r left join blbuser bu on bu.rolerid = r.resourceid where bu.username = #{arg0}")
	public String getRole(String username);
	
	@Insert("insert into user(name,password) values(#{name},#{password})")
    int addUser(@Param("name")String name,@Param("password")String password);
	
/*	@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。

	@CachePut，指定key，将更新的结果同步到redis中

	@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
	*/
/*    @Select("select * from user where id =#{id}")
    @Cacheable(key ="#p0") 
    User findById(@Param("id") String id);*/
    
    @CachePut(key = "#p0")
    @Update("update user set name=#{name} where id=#{id}")
    void updataById(@Param("id")String id,@Param("name")String name);
    
    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    @Delete("delete from user where id=#{id}")
    void deleteById(@Param("id")String id);
}
