package com.blb.authority.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.blb.authority.mapper.ShiroUserMapper;


public class BlbAuthRealm extends AuthorizingRealm {

	@Autowired
	private ShiroUserMapper userMapper;
	
	/**
	  *  权限认证
	 * <p>Title: doGetAuthorizationInfo</p>
	 * <p>Description: </p>
	 * @param principals
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = userMapper.getRole(username);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;

	}

	/**
         * 登录认证
	 * <p>Title: doGetAuthenticationInfo</p>
	 * <p>Description: </p>
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		System.out.println("————身份认证方法————");
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		// 从数据库获取对应用户名密码的用户
		String password = userMapper.getPassword(token.getUsername());
		if (null == password) {
			throw new AccountException("用户名不正确");
		} else if (!password.equals(new String((char[]) token.getCredentials()))) {
			throw new AccountException("密码不正确");
		}
		return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
	}

}
