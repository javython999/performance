package com.errday.performance.infrastructure;

import com.errday.performance.domain.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {
    ShortenUrl findByShortenUrlKey(String shortenUrlKey);
}
