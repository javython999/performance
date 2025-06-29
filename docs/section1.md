# 단축 URL 서비스 성능 측정하기
## 단축 URL 애플리케이션 코드 확인하기
> 단축 URL 생성 API
1. 단축 URL Key 생성
2. DB에 존재하는지 체크
3. 단축 URL DB에 저장

> 단축 URL 조회 API
1. 단축 URL Key를 통해 DB 조회
2. redirectCount를 1 증가
3. 변경된 redirectCount를 반영하기 위해 DB에 업데이트

## 서버에 배포하기
> vultr 배포
1. application-server
2. database-server

## 생성 API 성능 측정하기
```yaml
config:
  target: "http:141.164.34.91:8080"
  phases:
    - duration: 100
      arrivalRate: 10
      rampTo: 100
  payload:
    path: "urls.csv"
    fields:
      - "url"

scenarios:
  - name: "create shorten url"
    flow:
      - post:
          url: "/shortenUrl"
          json:
            originalUrl: "{{ url }}:"
```

* 아무것도 튜닝하지 않은 상태
```shell
http.response_time:
  min: ............ 35
  max: ............ 265
  mean: ........... 47.4
  median: ......... 45.2
  p95: ............ 61
  p99: ............ 83.9
```

## 조회 API 성능 측정하기
```yaml
config:
  target: "http:141.164.34.91:8080"
  phases:
    - duration: 100
      arrivalRate: 10
      rampTo: 100
  payload:
    path: "keys.csv"
    fields:
      - "shortenUrlKey"

scenarios:
  - flow:
      - get:
          url: "/{{ shortenUrlKey }}"
          followRedirect: false
```
* 아무것도 튜닝하지 않은 상태
```shell
http.response_time:
  min: ............ 34
  max: ............ 149
  mean: ........... 41.2
  median: ......... 40.9
  p95: ............ 47
  p99: ............ 56.3
```
* DB 인덱스 제거후 테스트
```shell
http.response_time:
  min: ............ 47
  max: ............ 956
  mean: ........... 144.7
  median: ......... 85.6
  p95: ............ 450.4
  p99: ............ 804.5
```