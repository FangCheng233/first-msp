package com.fc.msp.protocol.http;

import com.fc.msp.config.threadpool.ThreadPoolManager;
import com.fc.msp.service.impl.HttpProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HttpHandler
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/8/21 2:56 下午
 * @Version 1.0
 */
@Slf4j
@Component
public class HttpReceiveHandler extends OncePerRequestFilter {

    @Override
    protected boolean isAsyncDispatch(HttpServletRequest request) {
        return super.isAsyncDispatch(request);
    }

    @Override
    protected boolean isAsyncStarted(HttpServletRequest request) {
        return super.isAsyncStarted(request);
    }

    @Override
    protected String getAlreadyFilteredAttributeName() {
        return super.getAlreadyFilteredAttributeName();
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return super.shouldNotFilter(request);
    }

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return super.shouldNotFilterAsyncDispatch();
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return super.shouldNotFilterErrorDispatch();
    }

    @Override
    protected void doFilterNestedErrorDispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        super.doFilterNestedErrorDispatch(request, response, filterChain);
    }
    /**
     *
     * @Description 重写doFilterInternal 方法
     * @Author fangcheng
     * @param httpServletRequest :
     * @param httpServletResponse :
     * @param filterChain :
     * @return void
     * @throws
     * @Date 2020/8/21 11:06 上午
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpProcessService.getHttpProcessService().handlerRequest(httpServletRequest, httpServletResponse);
//        ThreadPoolManager.getThreadPools().get("HttpPools").execute(new HttpServerStarter(httpServletRequest,httpServletResponse));
    }

}
