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
package org.apache.shiro.web.filter.session;

import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * A {@code PathMatchingFilter} that will disable creating new Sessions during the request.  This is a useful
 * filter to place in the front of any filter chains that may result in REST, SOAP or other service invocations that
 * are not intended to participate in a session.
 * <p/>
 * This filter enables the following behavior:
 * <ol>
 * <li>If a {@code Subject} does not yet have a Session by the time this filter is called, this filter effectively
 * disables all calls to {@code subject}.{@link org.apache.shiro.subject.Subject#getSession() getSession()} and
 * {@code subject}.{@link org.apache.shiro.subject.Subject#getSession(boolean) getSession(true)}.  If either are called
 * during the request, an exception will be thrown.</li>
 * <li>
 * However, if the {@code Subject} already has an associated session before this filter is invoked, either because it
 * was created in another part of the application, or a filter higher in the chain created one, this filter has no
 * effect.
 * </li>
 * </ol>
 * Finally, calls to <code>subject.getSession(false)</code> (i.e. a {@code false} boolean value) will be unaffected
 * and may be called without repercussion in all cases.
 *
 * @since 1.2
 */
//PathMatchingFilter，用于在请求期间禁用创建新会话。
// 这是一个有用的过滤器，可放置在任何过滤器链的前面，这些过滤器链可能导致REST，SOAP或其他不打算参与会话的服务调用。
//
//此筛选器启用以下行为：
//如果在调用此过滤器时Subject还没有Session，则此过滤器会有效禁用对subject.getSession（）和subject.getSession（true）的所有调用。
// 如果在请求期间调用任何一个，则将抛出异常。
//但是，如果在调用此过滤器之前，Subject已经有一个关联的会话，要么是因为它是在应用程序的另一部分中创建的，要么是链中较高的过滤器创建过滤器，此过滤器无效。
//最后，对subject.getSession（false）的调用（即错误的布尔值）将不受影响，并且在所有情况下都可以在没有反响的情况下调用。
public class NoSessionCreationFilter extends PathMatchingFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        request.setAttribute(DefaultSubjectContext.SESSION_CREATION_ENABLED, Boolean.FALSE);
        return true;
    }
}
