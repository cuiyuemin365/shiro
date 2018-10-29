/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shiro.authc;

/**
 * An Authenticator is responsible for authenticating accounts in an application.  It
 * is one of the primary entry points into the Shiro API.
 * <p/>
 * Although not a requirement, there is usually a single 'master' Authenticator configured for
 * an application.  Enabling Pluggable Authentication Module (PAM) behavior
 * (Two Phase Commit, etc.) is usually achieved by the single {@code Authenticator} coordinating
 * and interacting with an application-configured set of {@link org.apache.shiro.realm.Realm Realm}s.
 * <p/>
 * Note that most Shiro users will not interact with an {@code Authenticator} instance directly.
 * Shiro's default architecture is based on an overall {@code SecurityManager} which typically
 * wraps an {@code Authenticator} instance.
 *
 * @see org.apache.shiro.mgt.SecurityManager
 * @see AbstractAuthenticator AbstractAuthenticator
 * @see org.apache.shiro.authc.pam.ModularRealmAuthenticator ModularRealmAuthenticator
 * @since 0.1
 */
//Authenticator负责验证应用程序中的帐户。它是Shiro API的主要入口之一。
//
//虽然不是必需的，但通常会为应用程序配置一个“主”验证器。启用可插入身份验证模块（PAM）行为（两阶段提交等）通常由单个身份验证器协调并与应用程序配置的域集进行交互来实现。
//
//请注意，大多数Shiro用户不会直接与Authenticator实例进行交互。 Shiro的默认体系结构基于整体SecurityManager，它通常包装Authenticator实例。
public interface Authenticator {

    /**
     * Authenticates a user based on the submitted {@code AuthenticationToken}.
     * <p/>
     * If the authentication is successful, an {@link AuthenticationInfo} instance is returned that represents the
     * user's account data relevant to Shiro.  This returned object is generally used in turn to construct a
     * {@code Subject} representing a more complete security-specific 'view' of an account that also allows access to
     * a {@code Session}.
     *
     * @param authenticationToken any representation of a user's principals and credentials submitted during an
     *                            authentication attempt.
     * @return the AuthenticationInfo representing the authenticating user's account data.
     * @throws AuthenticationException if there is any problem during the authentication process.
     *                                 See the specific exceptions listed below to as examples of what could happen
     *                                 in order to accurately handle these problems and to notify the user in an
     *                                 appropriate manner why the authentication attempt failed.  Realize an
     *                                 implementation of this interface may or may not throw those listed or may
     *                                 throw other AuthenticationExceptions, but the list shows the most common ones.
     * @see ExpiredCredentialsException
     * @see IncorrectCredentialsException
     * @see ExcessiveAttemptsException
     * @see LockedAccountException
     * @see ConcurrentAccessException
     * @see UnknownAccountException
     */
    //根据提交的AuthenticationToken对用户进行身份验证。
    //
    //如果身份验证成功，则返回AuthenticationInfo实例，该实例表示用户与Shiro相关的帐户数据。
    // 这个返回的对象通常用于构造一个Subject，该Subject代表一个更完整的特定于安全性的“视图”，该视图也允许访问Session。
    public AuthenticationInfo authenticate(AuthenticationToken authenticationToken)
            throws AuthenticationException;
}
