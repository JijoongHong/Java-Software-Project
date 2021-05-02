# 프로젝트 1 – 프로그램 실행시간 측정


# 목 차 

## 1. 실행 시간 측정 프로그램 검증
## 2. d2x( ) 메소드 검증 (1)
## 3. Eclipse 를 통한 실행 시간 측정
## 4. d2x( ) 메소드 검증 (2)
## 5. Eclipse 를 통한 실행 시간 측정
## 6. 실행 시간 비교 및 결론

# 

# 1. 실행 시간 측정 프로그램 검증 
## 1) eclipse를 통한 프로젝트 및 ExecTime 클래스 생성 
- Project1 프로젝트 생성 

  ![image](https://user-images.githubusercontent.com/63644587/116820193-a7095d00-abae-11eb-9088-9413c2a15784.png)

- ExecTime 클래스 생성

  ![image](https://user-images.githubusercontent.com/63644587/116820195-aa044d80-abae-11eb-9252-2ff2999ec8a8.png)


## 2) ExecTime 일관성 검증 

- 실습 시간에 작성한 ExecTime이 적절히 작동하는지 확인하기 위해 10회 실행 후 실행 결과의 편차를 고려한다. 
- 총 1,000,000회 시행 후 해당 시행 횟수 만큼 나눈 값을 사용한다. 
  
  ![image](https://user-images.githubusercontent.com/63644587/116820206-b8eb0000-abae-11eb-97c0-4e635b75d489.png)


- 실행 결과 


|실행 |1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
| - | - | - | - | - | - | - | - | - | - | - | - |
|결과 |39.0 |38.0 |37.0 |40.0 |37.0 |39.0 |38.0 |39.0 |39.0 |38.0 |38.4 |


- 총 10회 실행 결과 평균 실행 시간은 38.4로 나타남 
- 실행 결과 중에서 큰 오차로 벗어난 항목이 없으므로 시간 측정 프로그램이 정상 작동함을 알 수 있음 


# 2. d2x( )  메소드 검증(1)

- 검증에서는 기존에 작성해둔 main 함수의 시간 측정 코드를 주석 처리한 후, d2x( )의 반환 값을 출력하는 코드를 추가하여 검증하였다.  

- 검증에는 실행 시간을 측정할 65535를 포함하여, 10~100000자리의 임의의 숫자, 16의 배수를 변환하였다. 

- Eclipse 환경에서 실행하기 위해 작성한 d2x( ) 메소드는 다음과 같다. 

  ![image](https://user-images.githubusercontent.com/63644587/116820223-d5873800-abae-11eb-9c79-f8fb5c6009d5.png)


- 입력 받은 값을 16으로 나눈 나머지 값 remainder를 result 변수에 대입한다. 
- 나머지가 10 이상인 경우에는 알파벳이 들어가도록 한다. 
- 만약 몫이 0이 아니라면 이후 result에 과제의 요구사항인 ‘ ‘를 삽입한다. 이를 break과 
연계하여 결과물에 마지막 자리에 ‘ ‘가 들어가지 않도록 한다. 
- n의 값을 16으로 나눈다.  
- 위 과정을 몫이 0이 될 때 까지 반복한다. 
- 이후 result값을 역으로 만든 result2를 반환한다.  

## 1) 65535 결과 확인
- 정상 출력 

  ![image](https://user-images.githubusercontent.com/63644587/116820238-e33cbd80-abae-11eb-9410-40d8083e5074.png)



## 2) 자리수별 검증  

- 1~100000 자리의 임의의 수 8, 19, 983, 5555, 125080 실행 결과 정상 출력

  ![image](https://user-images.githubusercontent.com/63644587/116820241-e89a0800-abae-11eb-9b77-6f71703c251e.png)
  
  ![image](https://user-images.githubusercontent.com/63644587/116820245-ee8fe900-abae-11eb-9fce-108c54c3e0c8.png)
  
  ![image](https://user-images.githubusercontent.com/63644587/116820249-f2237000-abae-11eb-9c04-b18e4cbaf135.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820258-fa7bab00-abae-11eb-96f5-6e945a546547.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820260-fe0f3200-abae-11eb-96ab-9faa5c9c259d.png)



## 3) 16의 배수 검증 

- 몫이 0인 경우에 반복문이 끝나게 되므로 16의 배수를 처리할 수 있는지 확인 결과 정상 출력

  ![image](https://user-images.githubusercontent.com/63644587/116820262-036c7c80-abaf-11eb-9f9d-2e3eae680ee4.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820265-07000380-abaf-11eb-8f9e-b4ff4b10937e.png)


# 3. Eclipse 를 통한 실행시간 측정
## 1) 코드 추가 

- 시간 측정 시 사용한 System.nanoTime() 대신 d2x() 메소드를 입력한다.
- I/O 관련 변수가 많으므로 결과물을 출력하는 코드를 삭제한다 

  ![image](https://user-images.githubusercontent.com/63644587/116820271-154e1f80-abaf-11eb-8885-e3bdf2b8f53e.png)


## 2) 실행 결과

  <img width="893" alt="스크린샷 2021-05-03 오전 1 30 59" src="https://user-images.githubusercontent.com/63644587/116820293-37e03880-abaf-11eb-81a2-d55938d893c0.png">


  |실행|`  `1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
  | - | - | - | - | - | - | - | - | - | - | - | - |
  |결과|`  `365.0 |369.0 |351.0 |367.0 |371.0 |364.0 |366.0 |369.0 |360.0 |362.0 |364.4|
- 총 10회 실행 결과 평균 실행 시간은 364.4로 나타났음 
- 실행 결과 중에서 큰 오차로 벗어난 항목이 없으므로 프로그램이 정상 작동함을 알 수 있음 

# 4. d2x( )  메소드 검증(2)

- 2번째 검증에서는 텍스트 에디터를 사용한 코드를 이클립스로 옮겨와 테스트를 진행하였다. 
- 검증에는 첫 번째 검증과 같이 실행 시간을 측정할 65535를 포함하여, 10~100000자리의 임의의 숫자, 16의 배수를 변환하였다. 
- Terminal 환경에서 실행하기 위해 작성한 d2x( ) 메소드는 다음과 같다. 
  
  ![image](https://user-images.githubusercontent.com/63644587/116820305-4cbccc00-abaf-11eb-9e8f-66331c6a43d7.png)

- 구현 방법에 따른 차이를 실험해보기 위하여 코드를 보다 간소화하였다. 
- If-else를 통해 나머지 값을 추가할 값으로 배정했던 첫 구현과 달리 16진수의 구성요소를 String으로 지정하고, 해당 인덱스를 참조하도록 하였다.  
- 이후 result값을 역으로 만든 result2를 반환한다.  

## 1) 65535 결과 확인 

- 정상 출력 

  ![image](https://user-images.githubusercontent.com/63644587/116820315-5d6d4200-abaf-11eb-8535-47ede6c01aee.png)


## 2) 자리수별 검증 

- 1~100000 자리의 임의의 수 8, 19, 983, 5555, 125080 실행 결과 정상 출력
  
  ![image](https://user-images.githubusercontent.com/63644587/116820321-652ce680-abaf-11eb-8587-01e1ceb5a306.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820323-678f4080-abaf-11eb-8e1a-aaf298aa041e.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820325-69f19a80-abaf-11eb-8f8a-942d7ad34fa5.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820329-6cec8b00-abaf-11eb-9e6d-080c95ae925f.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820331-6fe77b80-abaf-11eb-91ec-040252e66e8d.png)


## 3) 16의 배수 검증 

- 몫이 0인 경우에 반복문이 끝나게 되므로 16의 배수를 처리할 수 있는지 확인 결과 정상 출력

  ![image](https://user-images.githubusercontent.com/63644587/116820338-770e8980-abaf-11eb-80d7-17e88ae0fcdd.png)

  ![image](https://user-images.githubusercontent.com/63644587/116820342-7970e380-abaf-11eb-8c16-a87650041ce6.png)

  
# 5. Terminal 을 통한 실행시간 측정 
## 1) 코드 추가 

- Mac OS에 기본 내장된 텍스트편집기를 활용하여 프로그램 작성 후 ExexTime.java로 저장

  ![image](https://user-images.githubusercontent.com/63644587/116820350-8097f180-abaf-11eb-885c-edd0fce3af60.png)


## 2) 컴파일 

- $ javac ExecTime.java로 컴파일 후 $ ls 명령어로 ExecTime.class 파일 생성 확인 
- 컴파일러가 중간 코드로 짜여진 프로그램을 class 파일에 저장

  ![image](https://user-images.githubusercontent.com/63644587/116820354-8d1c4a00-abaf-11eb-9739-7095f26fffeb.png)


## 3) 실행 및 결과 

- $ java ExecTime 명령어로 자바 인터프리터가 파일 실행 

  ![image](https://user-images.githubusercontent.com/63644587/116820356-92799480-abaf-11eb-977e-3722fc7b0259.png)


  |실행 |1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
  | - | - | - | - | - | - | - | - | - | - | - | - |
  |결과 |249.0 |249.0 |227.0 |222.0 |225.0 |226.0 |229.0 |228.0 |224.0 |227.0 |230.6|

- 총 10회 실행 결과 평균 실행 시간은 230.6로 나타남 

- 실행 결과 중에서 1회와 2회의 경우 249로 측정되었지만 이후 속도가 개선 되었음 

- 기존 실험 결과보다 편차가 상승하였지만 심각한 편차라고 보기 어려우므로 프로그램이 정상 작동함을 알 수 있음 


# 6. 실행시간 비교 및 결론


  |실행 |1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
  | - | - | - | - | - | - | - | - | - | - | - | - |
  |Eclipse |365.0 |369.0 |351.0 |367.0 |371.0 |364.0 |366.0 |369.0 |360.0 |362.0 |364.4 |
  |Terminal |249.0 |249.0 |227.0 |222.0 |225.0 |226.0 |229.0 |228.0 |224.0 |227.0 |230.6 |
  
- 이클립스 환경에서 실행한 첫번째 d2x() 메소드의 평균은 364.4이며, 두번째 d2x() 메소드의 10회 수행 평균은 230.6으로 드러났다. 

- 코드를 간소화하고, 문자열의 index를 통하여 값을 할당한 두번째 구현방식이If-else 방식을 활용하여 값을 할당한 첫번째 구현방식보다 63%가량 빠른 것을 알 수 있다. 

- 이를 통해 같은 작업을 수행하더라도 구현 방식에 따라서 유의미한 차이가 날 수 있다는 사실을 확인이 가능하다.  

