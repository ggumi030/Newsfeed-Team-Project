package com.sparta.newsfeedteamproject.service;

import com.sparta.newsfeedteamproject.dto.BaseResDto;
import com.sparta.newsfeedteamproject.dto.feed.FeedResDto;
import com.sparta.newsfeedteamproject.repository.FeedRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    // 게시글 조회
    public BaseResDto<List<FeedResDto>> getAllFeeds() {

        List<FeedResDto> feedList = feedRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(feed -> new FeedResDto(feed))
                .collect(Collectors.toList());

        String message = feedList.isEmpty() ? "게시물 조회가 완료되었습니다!" : "먼저 작성하여 소식을 알려보세요!";

        return new BaseResDto<>(HttpStatus.OK.value(), message, feedList);
    }
}