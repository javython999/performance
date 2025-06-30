package com.errday.performance.domain;

public interface ShortenUrlRepository {
    void saveShortenUrl(ShortenUrl shortenUrl);
    ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey);
    void asyncSaveShortenUrl(ShortenUrl shortenUrl);

}
