package com.errday.performance.presentation;

import com.errday.performance.domain.ShortenUrl;

public class ShortenUrlInformationDto {

    private String originalUrl;
    private String shortenUrlKey;
    private Long redirectCount;

    public ShortenUrlInformationDto(ShortenUrl shortenUrl) {
        this.originalUrl = shortenUrl.getOriginalUrl();
        this.shortenUrlKey = shortenUrl.getShortenUrlKey();
        this.redirectCount = shortenUrl.getRedirectCount();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }
}
