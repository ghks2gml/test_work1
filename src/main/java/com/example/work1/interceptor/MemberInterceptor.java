package com.example.work1.interceptor;

import com.example.work1.dao.MemberDao;
import com.example.work1.exception.ServerException;
import com.example.work1.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberInterceptor implements HandlerInterceptor {
    private final TokenService tokenService;
    private final MemberDao memberDao;

    private static final String HEADER_TOKEN = "x-token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info(">MemberInterceptor preHandle");

        //step : 헤더 정보를 가져와서 token을 검사한다.
        String token = request.getHeader(HEADER_TOKEN);
        if(token == null || "".equals(token)){
            throw new ServerException(506, "토큰을 찾을 수 없습니다.");
        }

        tokenService.validToken(token);

        int memberId = tokenService.getMemberId(token);

        request.setAttribute("membrer", memberDao.getMember(memberId));

        return true;
    }

}
