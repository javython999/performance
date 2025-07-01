package com.errday.performance.infrastructure;

import com.errday.performance.domain.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface JpaShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {
    ShortenUrl findByShortenUrlKey(String shortenUrlKey);

    @Modifying
    @Transactional
    @Query("UPDATE ShortenUrl su SET su.redirectCount = su.redirectCount + 1 WHERE su.shortenUrlKey = :shortenUrlKey")
    int incrementRedirectCount(String shortenUrlKey, @Param("increment") int increment);
}