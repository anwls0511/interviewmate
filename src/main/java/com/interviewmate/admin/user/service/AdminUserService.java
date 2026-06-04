package com.interviewmate.admin.user.service;

import com.interviewmate.admin.user.dto.request.AdminUserSearchRequest;
import com.interviewmate.admin.user.dto.request.AdminUserStatusUpdateRequest;
import com.interviewmate.admin.user.dto.response.AdminUserListResponse;
import com.interviewmate.admin.user.dto.response.AdminUserPageResponse;
import com.interviewmate.admin.user.dto.response.AdminUserStatusResponse;
import com.interviewmate.admin.user.mapper.AdminUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final AdminUserMapper adminUserMapper;

    public AdminUserPageResponse getUsers(
            AdminUserSearchRequest request
    ) {
        int totalCount =
                adminUserMapper.countUsers(request);

        List<AdminUserListResponse> users =
                adminUserMapper.findUsers(request)
                        .stream()
                        .map(AdminUserListResponse::from)
                        .toList();

        return new AdminUserPageResponse(
                totalCount,
                request.getPage(),
                request.getSize(),
                users
        );
    }

    public AdminUserStatusResponse updateUserStatus(
            Long userId,
            AdminUserStatusUpdateRequest request
    ) {
        adminUserMapper.updateUserStatus(
                userId,
                request.getStatus()
        );

        return new AdminUserStatusResponse(
                userId,
                request.getStatus()
        );
    }
}