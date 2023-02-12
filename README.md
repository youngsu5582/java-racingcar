# java-racingcar

자동차 경주 미션 저장소

# 기능목록
## 입력
- [x] 쉼표로 구분지어 자동차 이름을 입력한다.
  - [예외상황] 쉼표로 구분된 자동차 각각의 이름은 5자 이하다.
- [x] 몇 번 이동할지 입력한다.
  - [예외상황] 숫자만 가능하다.
  - [예외상황] 1이상의 숫자만 가능하다.

## 게임진행
- [x] 전체 시도횟수 만큼 돌린다.
  - [x] 각 자동차 별로 random값을 추출한다.
  - [x] 추출된 random값을 바탕으로 전진 여부를 판단한다.
    - [x] random값이 4이상이면 전진한다.
  - [x] 결과를 자동차에 반영한다.
  - [x] 반영된 결과를 출력한다.
- [x] 우승자를 출력한다.
  - [x] 공동우승의 경우 쉼표로 구분한다.

## 리팩토링 예정
- MovingCount 기본 타입으로 변경
- CarInfo 출력 메소드

- controller인스턴스 변수 줄이기
- 우승자 출력 시, 최종결과 함께 출력
- 예외발생 시 다시 입력받도록
- indent 1로
- 메서드 15line이내로

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
