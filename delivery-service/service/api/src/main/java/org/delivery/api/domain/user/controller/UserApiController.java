package org.delivery.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.delivery.api.domain.user.business.UserBusiness;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserBusiness userBusiness;

    // 로그인 필요 Api
}
