**2021 소프트웨어프로젝트** 

**프로젝트 1 – 프로그램 실행시간 측정**

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.001.jpeg)

**중앙대학교 소프트웨어프로젝트 03 분반 20176963 홍지중** 

**목 차** 

1. **실행 시간 측정 프로그램 검증……………………………………………3** 
1. **d2x( ) 메소드 검증 (1).………………………………………..……………4** 
1. **Eclipse 를 통한 실행 시간 측정…………………………………………..6** 
1. **d2x( ) 메소드 검증 (2).……………………………………………………..7** 
1. **Eclipse 를 통한 실행 시간 측정…………………………………………..9** 
1. **실행 시간 비교 및 결론……………………………………………………11** 
1. **원본 소스코드…………………………………………………………………12** 
1. **자체 평가표……………………………………………………………………14** 
1. **실행 시간 측정 프로그램 검증 ![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.002.png)**
1) eclipse를 통한 프로젝트 및 ExecTime 클래스 생성 l  Project1 프로젝트 생성 

l  ExecTime 클래스 생성![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.003.png)

2) ExecTime 일관성 검증 

l  실습 시간에 작성한 ExecTime이 적절히 작동하는지 확인하기 위해 10회 실행 후 실행 결과의 

편차를 고려한다. 총 1,000,000회 시행 후 해당 시행 횟수 만큼 나눈 값을 사용한다. 

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.004.png)

l  실행 결과 



|실행 |1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
| - | - | - | - | - | - | - | - | - | - | - | - |
|결과 |39.0 |38.0 |37.0 |40.0 |37.0 |39.0 |38.0 |39.0 |39.0 |38.0 |38.4 |


- 총 10회 실행 결과 평균 실행 시간은 38.4로 나타남 
- 실행 결과 중에서 큰 오차로 벗어난 항목이 없으므로 시간 측정 프로그램이 정상 작동함을    알 수 있음 
2. **d2x( )  메소드 검증(1)** 

l  검증에서는 기존에 작성해둔 main 함수의 시간 측정 코드를 주석 처리한 후, d2x( )의 반환 

값을 출력하는 코드를 추가하여 검증하였다.  

l  검증에는 실행 시간을 측정할 65535를 포함하여, 10~100000자리의 임의의 숫자, 16의 배수를 

변환하였다. 

l  Eclipse 환경에서 실행하기 위해 작성한 d2x( ) 메소드는 다음과 같다. 

l  입력 받은 값을 16으로 나눈 나머지 값 remainder를 result 변수에 대입한다. ![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.005.png)![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.006.png)

l  나머지가 10 이상인 경우에는 알파벳이 들어가도록 한다. 

l  만약 몫이 0이 아니라면 이후 result에 과제의 요구사항인 ‘ ‘를 삽입한다. 이를 break과 

연계하여 결과물에 마지막 자리에 ‘ ‘가 들어가지 않도록 한다. 

l  n의 값을 16으로 나눈다.  

l  위 과정을 몫이 0이 될 때 까지 반복한다. 

l  이후 result값을 역으로 만든 result2를 반환한다.  

1) 65535 결과 확인  l  정상 출력 

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.007.png)

2) 자리수별 검증  

l  1~100000 자리의 임의의 수 8, 19, 983, 5555, 125080 실행 결과 정상 출력

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.008.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.009.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.010.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.011.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.012.png)

3) 16의 배수 검증 

l  몫이 0인 경우에 반복문이 끝나게 되므로 16의 배수를 처리할 수 있는지 확인 결과 정상 출력

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.013.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.014.png)

3. **Eclipse 를 통한 실행시간 측정** 
1) 코드 추가 

l  시간 측정 시 사용한 System.nanoTime() 대신 d2x() 메소드를 입력한다. l  I/O 관련 변수가 많으므로 결과물을 출력하는 코드를 삭제한다 

2) 실행 결과 ![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.015.png)![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.016.png)



|실행|`  `1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
| - | - | - | - | - | - | - | - | - | - | - | - |
|결과|`  `365.0 |369.0 |351.0 |367.0 |371.0 |364.0 |366.0 |369.0 |360.0 |362.0 |364.4|
l  총 10회 실행 결과 평균 실행 시간은 364.4로 나타났음 

l  실행 결과 중에서 큰 오차로 벗어난 항목이 없으므로 프로그램이 정상 작동함을 알 수 있음 

4. **d2x( )  메소드 검증(2)** 

l  2번째 검증에서는 텍스트 에디터를 사용한 코드를 이클립스로 옮겨와 테스트를 

진행하였다. 

l  검증에는 첫 번째 검증과 같이 실행 시간을 측정할 65535를 포함하여, 10~100000자리의 

임의의 숫자, 16의 배수를 변환하였다. 

l  Terminal 환경에서 실행하기 위해 작성한 d2x( ) 메소드는 다음과 같다. 

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.017.png)

l  구현 방법에 따른 차이를 실험해보기 위하여 코드를 보다 간소화하였다. 

l  If-else를 통해 나머지 값을 추가할 값으로 배정했던 첫 구현과 달리 16진수의 구성요소를 

String으로 지정하고, 해당 인덱스를 참조하도록 하였다.  

l  이후 result값을 역으로 만든 result2를 반환한다.  

1) 65535 결과 확인 

l  정상 출력 

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.018.png)

2) 자리수별 검증 

l  1~100000 자리의 임의의 수 8, 19, 983, 5555, 125080 실행 결과 정상 출력

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.019.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.020.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.021.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.022.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.023.png)

3) 16의 배수 검증 

l  몫이 0인 경우에 반복문이 끝나게 되므로 16의 배수를 처리할 수 있는지 확인 결과 정상 출력

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.024.png)

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.025.png)

5. **Terminal 을 통한 실행시간 측정** 
1) 코드 추가 

l  Mac OS에 기본 내장된 텍스트편집기를 활용하여 프로그램 작성 후 ExexTime.java로 저장

![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.026.png)

2) 컴파일 

l  $ javac ExecTime.java로 컴파일 후 $ ls 명령어로 ExecTime.class 파일 생성 확인 l  컴파일러가 중간 코드로 짜여진 프로그램을 class 파일에 저장

3) 실행 및 결과 

l  $ java ExecTime 명령어로 자바 인터프리터가 파일 실행 



|실행 |1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
| - | - | - | - | - | - | - | - | - | - | - | - |
|결과 |249.0 |249.0 |227.0 |222.0 |225.0 |226.0 |229.0 |228.0 |224.0 |227.0 |230.6|
l  총 10회 실행 결과 평균 실행 시간은 230.6로 나타남 

l  실행 결과 중에서 1회와 2회의 경우 249로 측정되었지만 이후 속도가 개선 되었음 

l  기존 실험 결과보다 편차가 상승하였지만 심각한 편차라고 보기 어려우므로 프로그램이 정상 

작동함을 알 수 있음 

6. **실행시간 비교 및 결론** 



|실행 |1회 |2회 |3회 |4회 |5회 |6회 |7회 |8회 |9회 |10회 |평균 |
| - | - | - | - | - | - | - | - | - | - | - | - |
|Eclipse |365.0 |369.0 |351.0 |367.0 |371.0 |364.0 |366.0 |369.0 |360.0 |362.0 |364.4 |
|Terminal |249.0 |249.0 |227.0 |222.0 |225.0 |226.0 |229.0 |228.0 |224.0 |227.0 |230.6 |
l  이클립스 환경에서 실행한 첫번째 d2x() 메소드의 평균은 364.4이며, 두번째 d2x() 메소드의 10회 

수행 평균은 230.6으로 드러났다. 

l  코드를 간소화하고, 문자열의 index를 통하여 값을 할당한 두번째 구현방식이If-else 방식을 

활용하여 값을 할당한 첫번째 구현방식보다 63%가량 빠른 것을 알 수 있다. 

l  이를 통해 같은 작업을 수행하더라도 구현 방식에 따라서 유의미한 차이가 날 수 있다는 사실을 

확인이 가능하다.  

7. **원본 소스코드 – 1(Eclipse) ![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.027.jpeg)**

public class ExecTime {

public static void main(String[] args) { 

long startTime, endTime, execTime;

int N = 1000000;

startTime = System.nanoTime();

for (int i=0; i<N; i++) {

d2x(65535);

} 

endTime = System.nanoTime();

execTime = endTime - startTime;

System.out.println("Execution Time in nano seconds = " + (double)(execTime/N)); System.out.println("20176963 홍지중"); 

} 

public static String d2x(int n) { 

int remainder; String result = ""; String result2 = "";

while (true) {

remainder = n % 16;

if (remainder == 15){

result = result + 'f';

} else if (remainder == 14) {

result = result + 'e';

} 

else if (remainder == 13) {

result = result + 'd';

} 

else if (remainder == 12) {

result = result + 'c';

} 

else if (remainder == 11) {

result = result + 'b';

} 

else if (remainder == 10) {

result = result + 'a';

} 

else {

result = result + remainder; } 

if (n / 16 == 0) {

break;

} else{

result = result + ' ';

} 

n = n / 16;

} 

for (int i = result.length()-1; i>=0; i--) { 

result2 = result2 + result.charAt(i); } 

return result2;

} 

} 

**7. 원본 소스코드 – 2(Terminal) ![](Aspose.Words.f4b51d15-2bd3-4773-8b9f-813f215466d9.027.jpeg)**

public class ExecTime { 

public static void main(String[] args) { 

long startTime, endTime, execTime; int N = 1000000; 

startTime = System.*nanoTime*(); 

for (int i=0; i<N; i++) { 

*d2x*(65535); } 

endTime = System.*nanoTime*(); 

execTime = endTime - startTime; 

//System.out.println("Execution Time in nano seconds = " + (double)(execTime/N)); System.***out***.println("20176963 홍지중"); 

} 

public static String d2x(int n) { 

String result = ""; 

String result2 = ""; 

String numbers = "0123456789ABCDEF"; 

do { 

result = result + numbers.charAt(n % 16) + ' '; 

n /= 16; 

` `} while (n != 0); 

for (int i = result.length()-2; i>=0; i--) { 

result2 = result2 + result.charAt(i); 

} 

return result2; 

} 

} 

평  가  표 



|평가  항목|학생  자체  평가 (리포트  해당  부분  표시  및 간단한  의견) |<p>평가 </p><p>(빈칸) </p>|<p>점수 </p><p>(빈칸) </p>|
| - | :-: | - | - |
|<p>- 실행  시간  동작? </p><p>- d2x()  정확히  동작? </p><p>* 여러  테스트 </p><p>* d2x(65535)의  실행  시간 </p><p>- 충분한  실험? (수행시 간이  작은  경우  포함?) </p>|<p>1) 실행  시간의  경우  10 회  실행  시  큰  편차  없이 실행되었음  - 4p </p><p>2) 두  가지  방식의  d2x()를  65535, 1~100000 자리의 임의의  수, 16 의  배수로  테스트  하였고  정상적으로 결과가  출력됨  – 5p, 7p </p><p>3) 수행시간이  작은  경우를  고려해  1,000,000 번  시행 후  시행  숫자  만큼  나누었음</p>|||
|Eclipse 를  이용한  실행 |<p>이클립스를  통해  프로젝트,  클래스를  생성하고  실행 </p><p>- 3p, 6p </p>|||
|<p>에디터와  명령어를  이용 한  실행 </p><p>- 각  단계별  결과물과 그  의미는? </p>|<p>에디터로  프로그램을  작성 </p><p>Javac  명령어로  컴파일  후  실행  Java  명령어로  프로그램  실행 </p><p>- 9p </p>|||
|<p>리포트  작성 </p><p>- 평가  항목에  맞게  리 포트  작성? </p><p>- 모든  파일을  하나의 </p><p>pdf  문서로 </p>|요구사항에  충족하였음 |||
|기타  추가  설명  (필요한  경우) |<p>본인이  작성한  코드임을  </p><p>1) 프로그램  실행  시  마지막에  학번과  이름  출력 </p><p>2) 터미널의  User name 을  통해  증명하였음 </p>|||
|총평/계 |프로젝트  생성에서  실행까지의  단계를  세분화하여 기술하였고,  이를  리포트  앞부분에  목차로  표현하였음|||


* 학생  자체  평가는  점수에  반영되지  않음.  
* 학생  스스로  자신의  보고서를  평가하면서,  체계적으로  프로젝트를  마무리하도록  유도하는  것이  목적임. 
PAGE13 
