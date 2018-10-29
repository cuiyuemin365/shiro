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

import java.io.Serializable;

/**
 * <p>An <tt>AuthenticationToken</tt> is a consolidation of an account's principals and supporting
 * credentials submitted by a user during an authentication attempt.
 * <p/>
 * <p>The token is submitted to an {@link Authenticator Authenticator} via the
 * {@link Authenticator#authenticate(AuthenticationToken) authenticate(token)} method.  The
 * Authenticator then executes the authentication/log-in process.
 * <p/>
 * <p>Common implementations of an <tt>AuthenticationToken</tt> would have username/password
 * pairs, X.509 Certificate, PGP key, or anything else you can think of.  The token can be
 * anything needed by an {@link Authenticator} to authenticate properly.
 * <p/>
 * <p>Because applications represent user data and credentials in different ways, implementations
 * of this interface are application-specific.  You are free to acquire a user's principals and
 * credentials however you wish (e.g. web form, Swing form, fingerprint identification, etc) and
 * then submit them to the Shiro framework in the form of an implementation of this
 * interface.
 * <p/>
 * <p>If your application's authentication process is  username/password based
 * (like most), instead of implementing this interface yourself, take a look at the
 * {@link UsernamePasswordToken UsernamePasswordToken} class, as it is probably sufficient for your needs.
 * <p/>
 * <p>RememberMe services are enabled for a token if they implement a sub-interface of this one, called
 * {@link RememberMeAuthenticationToken RememberMeAuthenticationToken}.  Implement that interface if you need
 * RememberMe services (the <tt>UsernamePasswordToken</tt> already implements this interface).
 * <p/>
 * <p>If you are familiar with JAAS, an <tt>AuthenticationToken</tt> replaces the concept of a
 * {@link javax.security.auth.callback.Callback}, and  defines meaningful behavior
 * (<tt>Callback</tt> is just a marker interface, and of little use).  We
 * also think the name <em>AuthenticationToken</em> more accurately reflects its true purpose
 * in a login framework, whereas <em>Callback</em> is less obvious.
 *
 * @see RememberMeAuthenticationToken
 * @see HostAuthenticationToken
 * @see UsernamePasswordToken
 * @since 0.1
 */
//AuthenticationToken是用户在身份验证尝试期间提交的帐户主体和支持凭据的合并。
//
//令牌通过authenticate（token）方法提交给Authenticator。然后，Authenticator执行身份验证/登录过程。
//
//AuthenticationToken的常见实现将具有用户名/密码对，X.509证书，PGP密钥或您能想到的任何其他内容。令牌可以是Authenticator正确验证所需的任何内容。
//
//由于应用程序以不同方式表示用户数据和凭据，因此该接口的实现是特定于应用程序的。
// 您可以随意获取用户的主体和凭证（例如Web表单，Swing表单，指纹识别等），然后以此接口的实现形式将它们提交给Shiro框架。
//
//如果您的应用程序的身份验证过程基于用户名/密码（与大多数人一样），而不是自己实现此界面，请查看UsernamePasswordToken类，因为它可能足以满足您的需求。
//
//如果一个令牌实现了一个名为RememberMeAuthenticationToken的子接口，则会为该令牌启用RememberMe服务。
// 如果需要RememberMe服务，则实现该接口（UsernamePasswordToken已实现此接口）。
//
//如果您熟悉JAAS，则AuthenticationToken将取代javax.security.auth.callback.Callback的概念，并定义有意义的行为（Callback只是一个标记接口，几乎没用）。
// 我们还认为AuthenticationToken这个名称更准确地反映了它在登录框架中的真正目的，而Callback则不太明显。
public interface AuthenticationToken extends Serializable {

    /**
     * Returns the account identity submitted during the authentication process.
     * <p/>
     * <p>Most application authentications are username/password based and have this
     * object represent a username.  If this is the case for your application,
     * take a look at the {@link UsernamePasswordToken UsernamePasswordToken}, as it is probably
     * sufficient for your use.
     * <p/>
     * <p>Ultimately, the object returned is application specific and can represent
     * any account identity (user id, X.509 certificate, etc).
     *
     * @return the account identity submitted during the authentication process.
     * @see UsernamePasswordToken
     */
    Object getPrincipal();

    /**
     * Returns the credentials submitted by the user during the authentication process that verifies
     * the submitted {@link #getPrincipal() account identity}.
     * <p/>
     * <p>Most application authentications are username/password based and have this object
     * represent a submitted password.  If this is the case for your application,
     * take a look at the {@link UsernamePasswordToken UsernamePasswordToken}, as it is probably
     * sufficient for your use.
     * <p/>
     * <p>Ultimately, the credentials Object returned is application specific and can represent
     * any credential mechanism.
     *
     * @return the credential submitted by the user during the authentication process.
     */
    Object getCredentials();

}
