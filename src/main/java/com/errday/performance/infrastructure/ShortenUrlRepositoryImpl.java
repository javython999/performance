package com.errday.performance.infrastructure;

import com.errday.performance.domain.ShortenUrl;
import com.errday.performance.domain.ShortenUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public class ShortenUrlRepositoryImpl implements ShortenUrlRepository {

    private final JpaShortenUrlRepository jpaShortenUrlRepository;

    @Autowired
    public ShortenUrlRepositoryImpl(JpaShortenUrlRepository jpaShortenUrlRepository) {
        this.jpaShortenUrlRepository = jpaShortenUrlRepository;
    }

    @Override
    public void saveShortenUrl(ShortenUrl shortenUrl) {
        jpaShortenUrlRepository.save(shortenUrl);
    }

    @Override
    public ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey) {
        return jpaShortenUrlRepository.findByShortenUrlKey(shortenUrlKey);
    }

    @Async
    @Override
    public void asyncSaveShortenUrl(ShortenUrl shortenUrl) {
        jpaShortenUrlRepository.save(shortenUrl);
    }
}
