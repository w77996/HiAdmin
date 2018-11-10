package com.w77996.admin.core.shiro;

import com.w77996.admin.model.UserInfo;
import com.w77996.admin.service.RolePermService;
import com.w77996.admin.service.UserInfoService;
import com.w77996.admin.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermService rolePermService;

    /**
     * 告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
     */
    {
        log.info("CustomRealm static");
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName("md5");
        hashMatcher.setStoredCredentialsHexEncoded(true);
        //加密的次数
        hashMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashMatcher);
    }


    /**
     *  定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("enter doGetAuthorizationInfo");
        if (principals == null) {
            log.info("doGetAuthorizationInfo principals is null");
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        UserInfo user = (UserInfo) getAvailablePrincipal(principals);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(user.getRoles());
        info.setStringPermissions(user.getPerms());
        return info;
    }

    /**
     * 定义如何获取用户信息的业务逻辑，给shiro做登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("enter doGetAuthenticationInfo");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        if (username == null) {
            log.info("doGetAuthenticationInfo usrename is null");
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        UserInfo userDB = userService.selectUserInfoByUsername(username);
        if (userDB == null) {
            throw new UnknownAccountException("No account found for admin [" + username + "]");
        }
        log.info("userInfo {}",userDB.toString());
        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
        List<String> roleList = userRoleService.getRolesByUserId(userDB.getId());
        log.info("roleList {}",ArrayUtils.toArray(roleList));
        List<String> permList = rolePermService.getPermsByUserId(userDB.getId());
        log.info("permList {}",ArrayUtils.toArray(permList));
        Set<String> roles = new HashSet(roleList);
        Set<String> perms = new HashSet(permList);
        userDB.setRoles(roles);
        userDB.setPerms(perms);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPassword(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt()));
        return info;

    }

}

