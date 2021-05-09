**2021소프트웨어프로젝트**

**프로젝트 4 – Generic Stack**



![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.001.jpeg)

**중앙대학교**

**소프트웨어프로젝트 03 분반**

**20176963 홍지중**

**목 차**

**1. Generic Stack with limited capacity………………………….……………….3**

**1) 클래스 분석………..……….…………..……….………..……….…………….……………3**

**2) 실행 결과………..……….…………..……….………..……….……................................5**

**2. Generic Stack with unlimited capacity ……………….....................7**

**1) Overriding 및 재정의….……….………..……….……..…………………………….......7**

**2) 실행 결과……..…..………..………............................................................................9**

**3. Parameterized Generic Stack with unlimited capacity….……..10**

**1) 구현 사항….……….………..……….……..…………………………….........................10**

**2) 실행 결과……..………………………………………………..………………………….....12**

**4. 원본소스코드………………………………………..………………………15**

**1) GenericStackLimitedCapacity……..…………………………..………………………….15**

**2) GenericStack……..………………………………………………..………………………….16**

**3) ParaStack……..…………………………………………………………………………….….17**

**4) TestMain……..…………………………………………………………………………….…..18**

**5. 자체평가표……………………………………………………………………19**


**1. Generic Stack with limited capacity**

**1) 클래스 분석**

- UML Class
- 정적스택인 GenericStackLimitedCapacity의 UML 클래스는 다음과 같다.

|<p>**<Class name>**</p><p>GenericStackLimitedCapacity</p>|
| :- |
|<p>**<Data field>**</p><p>- top: int</p><p>- INIT\_CAPACITY: int{readOnly}</p><p>- list: Object[]</p>|
|<p>**<Constructors>**</p><p>+ GenericStackLimitedCapacity ( )</p><p>+ GenericStackLimitedCapacity (capacity: int)</p><p></p><p>**<Methods>**</p><p>+ isEmpty( ) : boolean</p><p>+ pop( ) : Object</p><p>+ push(o : Object) </p><p>+ toString( ) : String </p>|












- 데이터 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.002.png)

- Private int top : Stack의 가장 최근 데이터 위치를 표시해주는 변수로서, Stack이 처음 생성되는 경우 데이터가 없기 때문에 -1로 지정한다.
- Private final int INIT\_CAPACITY : 따로 크기를 지정해주지 않을 경우 상수 2를 두어 이를 스택의 크기로 정한다.
- Private Object[] list : 스택의 데이터가 삽입되는 배열으로, type이 최상위 객체인 Object 객체로 지정되어 어떠한 데이터도 삽입이 가능하다.



- 생성자

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.003.png)

- GenericStackLimitedCapcity()
  - No-arg 생성자로서 상수값인 2크기의 Object 배열을 생성한다.
  - 더불어 이 생성자는 추후 상속 후 sub class 생성 시 super()가 자동으로 호출되므로 이에 대비하여 생성하는 것이 좋다. 
- GenericStackLimitedCapcity(int capacity)
  - 정수값의 capacity를 인자로 받아 해당 크기 만큼 Object 배열을 생성한다.

- 메소드 
- public boolean isEmpty()

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.004.png)

- 스택이 비었는지 확인하는 메소드이다.
- 스택이 비었다면 top 변수의 값은 -1이 된다. 그러므로 top이 음수인지 여부를 반환하도록 한다.

- public Object pop()

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.005.png)

- 배열 내에 데이터가 존재한다면 list[top]을 반환하고, 가장 최근 데이터를 가리키는 top변수를 줄인다.
- 만약 존재하지 않는 경우 null값을 반환한다.

- public void push(Object o)

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.006.png)

- 데이터를 추가하는 메소드로서, top변수를 increment한 후 해당 인덱스에 인자로 받은 Object o를 대입한다.

- public String toString()

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.007.png)

- Object class의 toString()메소드를 override하여 재정의한 것으로, 스택 내의 데이터를 하나의 문자열로 만들어 반환한다.
- 과제의 목적인 generic programming과 동적 바인딩을 잘 보여주고, 다른 스택과의 비교를 용이하도록 하기위하여 해당 클래스의 이름을 출력하고, 내부의 데이터는 배열 선언 시와 비슷한 모습으로 출력하도록 변경하였다.

**2) 실행 결과**

- TestMain 클래스에서는 정적스택에 대해 다음 항목을 실험한다.
- 주어진 용량을 넘어서 데이터를 추가할 수 있는가?
- 생성자의 인자로 capacity를 받아 해당 크기 만큼의 배열을 생성하는가?
- 어떠한 객체든 스택의 데이터로 사용할 수 있는가?
- 이를 위하여 두 개의 정적 스택을 생성하였다.

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.008.png)

- 동적 바인딩을 확인하기 위하여 printStack 메소드는 스택 인스턴스를 인자로 받아 toString을 호출하고, 반환받은 문자열을 출력하도록 해 generic programming을 구현하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.009.png)

- 주어진 용량을 넘어서서 데이터를 추가할 수 있는지 확인한다.
- 이를 위해 다음과 같은 코드를 실행한다. 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.010.png)

- s1 인스턴스는 생성자의 인자 없이 생성되었으므로 최대 용량은 2이다. 그러나 삽입하려는 데이터는 3개 이므로 오류가 발생하여야 한다.
- 실행 결과 ArrayIndexOuntOfBoundsException이 발생하였다.

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.011.png)

- 생성자의 인자로 capacity를 받아 해당 크기 만큼의 배열을 생성하고, 모든 객체를 스택의 데이터로 사용할 수 있는지 확인한다.
- 이를 위해 다음과 같은 코드를 실행한다

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.012.png)

- 생성자 인자를 4로 하여 새로운 인스턴스를 생성한다.
- isEmpty 메소드의 동작을 확인하기 위해 데이터 삽입 전, 후에 이를 실행한다.
- Push와 pop 메소드 동작을 확인하기 위해 1을 삽입 후 삭제한다.
- 정수, 문자열, 실수를 담은 동일 클래스의 인스턴스 참조변수, 배열의 참조변수 총 4개의 데이터를 삽입한다. 이를 통해 모든 객체를 데이터로 사용할 수 있는지 확인한다.

- 실행결과

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.013.png)

- True/false 값을 통해 isEmpty 메소드가 잘 작동한 것을 볼 수 있다.
- 스택의 데이터 값에 1이 없으므로 Push와 pop 메소드가 잘 작동한 것을 볼 수 있다.
- 4개의 데이터가 문제 없이 삽입되었으므로 스택의 크기를 인자로 받아 설정할 수 있다.
- 삽입한 모든 데이터의 type이 다르다. 이는 Object class는 모든 객체의 super class이기 때문이다. 

**2. Generic Stack with unlimited capacity**

GenericStack 클래스는 정적스택을 상속받아 동적스택으로 확장한다.

**1) Overriding 및 재정의**

- super class의 데이터를 protected로 변경

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.014.png)

- 상속을 통해 데이터에 접근하려면 super class의 데이터가 visiable 및 accessible 해야 한다.
- 그러나 기존처럼 Private인 경우에는 이에 접근할 수 없다. 그러므로 subclass에서 접근이 가능하도록 protected로 데이터 필드의 속성을 재정의한다.

- 클래스 선언 

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.015.png)

- GenericStack 클래스는 GenericStackLimitedCapacity를 상속한다.
- 즉, super class를 확장하여 보다 상세한 구현을 하는 것이 목적이다.

- constructor

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.016.png)

- GenericStack을 생성 시 super 클래스의 인스턴스를 우선 생성한 후 인스턴스를 생성한다.
- No-arg 생성자 호출 시 2크기 만큼의 배열이 생성되고, capacity를 인자로 받으면 해당 크기 만큼의 배열이 생성된다.

- push

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.017.png)

- 데이터를 추가하는 메소드로서, top변수를 increment한 후 해당 인덱스에 인자로 받은 Object o를 대입한다.
- 데이터 추가 시 배열이 꽉 찬 상태라면, 배열의 용량을 2배로 늘려준다.
- 이를 위해 기존 크기의 2배 배열을 생성한 후, 해당 배열에 기존 데이터를 copy한다. 
- 이후 기존 배열이 새로운 배열을 가리키도록 한다.

- toString

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.018.png)

- super class의 toString()메소드를 override하여 재정의한 것으로, 스택 내의 데이터를 하나의 문자열로 만들어 반환하는 것은 동일하다.
- 그러나 이름을 현재 클래스 이름으로 변경하는 작업을 추가하여 override 작업을 수행했다.

- 이외의 사항은 super클래스와 동일한 데이터로 동일한 작업을 수행하므로 추가적인 override를 진행하지 않는다.


**2) 실행 결과**

- TestMain 클래스에서는 동적스택에 대해 다음 항목을 실험한다.
- 주어진 용량을 넘어서 데이터를 추가할 수 있는가?
- 어떠한 객체든 스택의 데이터로 사용할 수 있는가?
- 메소드의 동적 바인딩이 작동하는가?
- 이를 위하여 두 개의 동적 스택을 생성하였다.

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.019.png)

- 동적 바인딩을 확인하기 위하여 printStack 메소드는 스택 인스턴스를 인자로 받아 toString을 호출하고, 반환받은 문자열을 출력하도록 해 generic programming을 구현하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.009.png)

- 이를 위해 다음과 같은 코드를 실행한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.020.png)

- No-arg 생성자를 통해 새로운 인스턴스를 생성한다. 이 때 배열의 크기는 2이다.
- isEmpty 메소드의 동작을 확인하기 위해 데이터 삽입 전, 후에 이를 실행한다.
- Push와 pop 메소드 동작을 확인하기 위해 1을 삽입 후 삭제한다.
- 정수, 문자열, 실수를 담은 동일 클래스의 인스턴스 참조변수, 총 3개의 데이터를 삽입한다. 이를 통해 배열의 크기가 조정되고, 모든 객체를 데이터로 사용할 수 있는지 확인한다.

- 실행 결과 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.021.png)

- True/false 값을 통해 isEmpty 메소드가 잘 작동한 것을 볼 수 있다.
- 스택의 데이터 값에 1이 없으므로 Push와 pop 메소드가 잘 작동한 것을 볼 수 있다.
- 3개의 데이터가 문제 없이 삽입되었으므로 동적으로 스택의 크기를 설정할 수 있다.
- 삽입한 모든 데이터의 type이 다르다. 이는 Object class는 모든 객체의 super class이기 때문이다. 
- 스택의 이름이 super 클래스의 이름이 아니라 GenericStack으로 출력되었다. 이를 통해 다형성과 동적 바인딩을 통한 generic programming을 확인 할 수 있다.

**3. Parameterized Generic Stack with unlimited capacity**

ParaStack은 동적스택에 type을 인자로 받아 type-safe를 구현한 스택이다.

**1) 구현 사항**

- 클래스 선언 

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.022.png)

- 클래스 선언과 더불어 Parameterized Type을 추가하여 type을 인자로 받도록 한다.

- 변수

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.023.png)

- 데이터 필드는 기존의 스택과 동일하다.
- List의 type을 Object로 선언하여 generic programming이 가능하도록 한다.

- 생성자

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.024.png)

- 생성자는 기존의 스택과 같이 no-arg 생성자로 초기 배열값을 고정하거나, capacity를 인자로 받아 해당 크기의 배열을 선언한다.
- 생성된 배열에 인자로 받은 type으로 명시적 캐스팅을 진행한다. 이 때 unchecked cast 컴파일 경고가 나오게 되는데 run time에서 동적으로 type이 결정되기 때문에 compile time에서 안정성을 보장할 수 없음을 의미한다. 그러나 이번 과제에서는 의도적으로 형안정성을 위배하거나 유지하므로 추가적인 조치를 하지 않는다.

- Public boolean isEmpty()

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.025.png)

- 이전과 동일하게, 스택이 비었는지 확인하는 메소드이다.
- 스택이 비었다면 top 변수의 값은 -1이 된다. 그러므로 top의 음수 여부를 반환하도록 한다.

- Public E pop()

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.026.png)

- 배열 내에 데이터가 존재한다면 list[top]을 반환하고, 가장 최근 데이터를 가리키는 top변수를 줄인다. 만약 존재하지 않는 경우 null값을 반환한다.
- 반환값을 type변수로 지정하고, 실행 전 list는 Object형이므로 명시적 캐스팅을 진행한다.

- Public void push(E o)

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.027.png)

- 이전과 동일하게 인자로 받은 데이터를 배열에 추가한다. 이 때 배열이 포화상태라면 배열의 크기를 2배로 증가시킨다.
- 이 때도 미지정된 type의 데이터를 인자로 받도록하며, 새로운 배열 생성 시 명시적 캐스팅을 진행한다.
- Public String toString

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.028.png)

- Object class의 toString()메소드를 override하여 재정의한 것으로, 스택 내의 데이터를 하나의 문자열로 만들어 반환한다.

**2) 실행 결과**

- TestMain 클래스에서는 type-safe한 동적스택에 대해 다음 항목을 실험한다.
- 지정한 type외에 다른 데이터를 스택에 추가할 수 있는가?
- 어떠한 객체든 스택의 데이터로 사용할 수 있는가?
- 이를 위하여 String과 Double로 type을 지정한 두 개의 동적 스택을 생성하였다.

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.029.png)

- 동적 바인딩을 확인하기 위하여 printStack 메소드는 스택 인스턴스를 인자로 받아 toString을 호출하고, 반환받은 문자열을 출력하도록 해 generic programming을 구현하였다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.009.png)

- 지정한 type외에 다른 데이터를 스택에 추가할 수 있는지 확인
- 이를 위해 다음 코드를 실행한다. 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.030.png)

- String 형으로 type이 결정된 스택에 정수, 문자열, 실수를 담은 Double형 스택의 인스턴스 참조변수, 총 4개의 데이터를 삽입한다. 이를 통해 지정 type외에 데이터가 추가되는지 확인한다.

- 실행 결과 

![](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.031.png)

- 지정 type외에 데이터가 추가되지 않음을 확인할 수 있다.

- 어떠한 객체든 스택의 데이터로 사용할 수 있는지 확인
- 이를 위해 다음과 같은 코드를 실행하여 지정 type의 데이터만을 push한다.

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.032.png) ![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.033.png)

- 실행 결과 

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.034.png)

![텍스트이(가) 표시된 사진

자동 생성된 설명](Aspose.Words.6fa8b420-2e55-4fec-abeb-d83e0ef84482.035.png)

- 지정 type의 데이터가 정상적으로 추가되었음을 확인할 수 있다.
- 기능에 대한 평가

Inheritence : 공통된 특징을 가진 클래스를 상속하여 중복을 피하고, 고유한 속성은 추가하거나 오버라이딩하여 손쉽게 변경 및 확장(구체화)가 가능하다.

Generic : 가상의 형을 만들어 일반화된 메소드 작성이 가능하고, 이에 어떤 인자가 와도 사용이 가능하다.  

Type-safe : Generic 사용 시 특정 상황에서 다른 타입의 인자가 처리되는 것을 미연에 방지할 수 있다. Runtime에서 type으로 인해 문제가 발생하는 것을 방지하고, compile time에서 문제를 인식한다.

**4. 원본 소스코드 – GenericStackLimitedCapacity**

|<p></p><p>class GenericStackLimitedCapcity {</p><p>`	`protected int top = -1;</p><p>`	`protected final int INIT\_CAPACITY = 2;</p><p>`	`protected Object[] list;</p><p>	</p><p>`	`GenericStackLimitedCapcity(){</p><p>`		`list = new Object[INIT\_CAPACITY];</p><p>`	`}</p><p>	</p><p>`	`GenericStackLimitedCapcity(int capacity){</p><p>`		`list = new Object[capacity];</p><p></p><p>`	`}</p><p>	</p><p>`	`public boolean isEmpty() {</p><p>`		`return (top<0);</p><p>`	`}</p><p>	</p><p>`	`public Object pop() {</p><p>`		`if (top >= 0) </p><p>`			`return list[top--];</p><p>`		`else</p><p>`			`return null;</p><p>`	`}</p><p>	</p><p>`	`public void push(Object o) {</p><p>`		`list[++top] = o;</p><p>`	`}</p><p>	</p><p>`	`/\*\* Override the toString in the Object class\*/</p><p>	</p><p>`	`public String toString() {</p><p>`		`String ss = "GenericStackLimitedCapcity: {";</p><p>`		`for(int i =0; i < top; i++)</p><p>`			`ss += list[i] + ", ";</p><p>`		`ss += list[top];</p><p>`		`ss += "}";</p><p>`		`return ss;</p><p>`	`}</p><p>	</p><p>}** </p>|
| :- |




**4. 원본 소스코드 – GenericStack**

|<p></p><p>public class GenericStack extends GenericStackLimitedCapcity{</p><p>	</p><p>`	`GenericStack(){</p><p>`		`super();</p><p>`	`}</p><p>	</p><p>`	`GenericStack(int capacity){</p><p>`		`super(capacity);</p><p>`	`}</p><p>	</p><p>`	`public void push(Object o) {</p><p>		</p><p>`		`if (top >= list.length-1) {</p><p>`			`Object[] temp = new Object[list.length \* 2];</p><p>`			`System.*arraycopy*(list, 0, temp, 0, list.length);</p><p>`			`list = temp;</p><p>`		`}</p><p>`			`list[++top] = o;</p><p></p><p>`	`}</p><p>	</p><p>	</p><p>`	`/\*\* Override the toString in the GenericStackLimitedCapcity class\*/</p><p>`	`public String toString() {</p><p>`		`String ss = super.toString();</p><p>`		`ss = ss.replace("GenericStackLimitedCapcity", "GenericStack");</p><p>`		`return ss;</p><p>`	`}</p><p>	</p><p>} </p>|
| :- |

**


**4. 원본 소스코드 – ParaStack**

|<p></p><p>public class ParaStack<E>{</p><p>	</p><p>`	`private int top = -1;</p><p>`	`private final int INIT\_CAPACITY = 2;</p><p>`	`private Object[] list;</p><p>	</p><p>`	`ParaStack(){</p><p>`		`list = (E[]) new Object[INIT\_CAPACITY];</p><p>`	`}</p><p>	</p><p>`	`ParaStack(int capacity){</p><p>`		`list = (E[]) new Object[capacity];</p><p>`	`}</p><p>	</p><p>	</p><p>`	`public boolean isEmpty() {</p><p>`		`return (top<0);</p><p>`	`}</p><p>	</p><p>`	`public E pop() {</p><p>`		`if (top >= 0) </p><p>`			`return (E) list[top--];</p><p>`		`else</p><p>`			`return null;</p><p>`	`}</p><p>	</p><p>`	`public void push(E o) {</p><p>		</p><p>`		`if (top+1 >= list.length) {</p><p>`			`E[] temp = (E[]) new Object[list.length \* 2];</p><p>`			`System.*arraycopy*(list, 0, temp, 0, list.length);</p><p>`			`list = temp;</p><p>`		`}</p><p>`			`list[++top] = o;</p><p>`	`}</p><p>	</p><p>`	`public String toString() {</p><p>`		`String ss = "ParaStack: {";</p><p>`		`for(int i =0; i < top; i++)</p><p>`			`ss += list[i] + ", ";</p><p>`		`ss += list[top];</p><p>`		`ss += "}";</p><p>`		`return ss;</p><p>`	`}</p><p>	</p><p>}</p>|
| :- |

**

**4. 원본 소스코드 – TestMain**

|<p></p><p></p><p>public class TestMain {</p><p></p><p>`	`public static void main(String[] args) {</p><p>`		`GenericStackLimitedCapcity s0 = new GenericStackLimitedCapcity();</p><p>`		`GenericStackLimitedCapcity s1 = new GenericStackLimitedCapcity();</p><p>`		`GenericStack s2 = new GenericStack();</p><p>`		`GenericStack s3 = new GenericStack();</p><p>`		`ParaStack<String> s4 = new ParaStack<String>();</p><p>`		`ParaStack<Double> s5 = new ParaStack<Double>();</p><p>		</p><p>`		`/\*</p><p>`		`//(1-1) GenericStackLimitedCapcity 실험 - 오류 </p><p>`		`s1.push(1);</p><p>`		`s1.pop();</p><p>`		`s1.push("Java");</p><p>`		`s1.push(2);</p><p>`		`s0.push(3.141592); //실수 삽입</p><p>`		`s1.push(s0); </p><p>`		`printStack(s1); // 에러 발생</p><p>`		`\*/</p><p>		</p><p>		</p><p>`		`//(1-2) GenericStackLimitedCapcity 실험 - 정상 </p><p>`		`System.***out***.println(s1.isEmpty());</p><p>`		`s1 = new GenericStackLimitedCapcity(4);</p><p>`		`s1.push(1); // 정수 삽입 </p><p>`		`s1.pop(); //삭제 </p><p>`		`s1.push("Java"); // 문자열 삽입 </p><p>`		`s1.push(2); // 정수 삽입 </p><p>`		`s0.push(3.141592); //실수 삽입</p><p>`		`s1.push(s0); // 인스턴스 삽입 </p><p>`		`System.***out***.println(s1.isEmpty());</p><p>`		`*printStack*(s1); // 정상출력</p><p>		</p><p>		</p><p>`		`//(2-1) GenericStack 실험 </p><p>`		`System.***out***.println(s2.isEmpty());</p><p>`		`s2.push(1); //정수 삽입</p><p>`		`s2.pop();</p><p>`		`s2.push("홍지중"); //문자열 삽입 </p><p>`		`s2.push(3); // 정수 삽입 </p><p>`		`s3.push(2.718281); //실수 삽입</p><p>`		`s2.push(s3); // 인스턴스 삽입 </p><p>`		`System.***out***.println(s2.isEmpty());</p><p>`		`*printStack*(s2); // 정상출력</p><p>		</p><p>		</p><p>`		`/\*</p><p>`		`// (3-1) ParaStack 실험 - 오류 </p><p>`		`s4.push(1); //정수 삽입</p><p>`		`s4.pop();</p><p>`		`s4.push("test"); //문자열 삽입 </p><p>`		`s4.push(3); // 정수 삽입 </p><p>`		`s5.push(3.141592); //실수 삽입</p><p>`		`s4.push(s5); // 클래스 삽입 </p><p>`		`printStack(s4); //오류 </p><p>`		`\*/</p><p>		</p><p>		</p><p>`		`// (3-2) ParaStack 실험 - 정상 </p><p>`		`System.***out***.println(s4.isEmpty());</p><p>`		`s4.push("This"); // 문자열만 삽입 </p><p>`		`s4.push("is");</p><p>`		`s4.push("parastack");</p><p>`		`s4.push("test");</p><p>`		`System.***out***.println(s4.isEmpty());</p><p>`		`*printStack*(s4); // 정상출력</p><p>		</p><p>		</p><p>`		`// (3-3) ParaStack 실험 - 정상 </p><p>`		`System.***out***.println(s5.isEmpty());</p><p>`		`s5.push(3.141592); // 문자열만 삽입 </p><p>`		`s5.push(2.718281);</p><p>`		`s5.push(1.0);</p><p>`		`s5.push(-2.0176963);</p><p>`		`System.***out***.println(s5.isEmpty());</p><p>`		`*printStack*(s5); // 정상출력</p><p>		</p><p>`	`}</p><p>	</p><p>`	`public static void printStack(Object x) {</p><p>`		`System.***out***.println(x.toString()+'\n');</p><p>`	`}</p><p></p><p>}}</p>|
| :- |


**


**5. 자체평가표** 

평 가 표

|평가 항목|<p>학생 자체 평가 </p><p>(리포트 해당 부분 표시 및 </p><p>간단한 의견)</p>|평가 (빈칸)|<p>점수</p><p>(빈칸)</p>|
| :-: | :-: | :-: | :-: |
|<p></p><p></p><p>-GenericStack 구현?</p><p>\* super class 개념 이용해서</p><p>\* array 용량 제한을 해결</p><p>\* inheritance 이용 필수</p><p>-실험으로 검증?</p><p>\* 검증사항? generic, 용량</p><p></p><p></p>|<p>7p : GenericStackLimitedCapacity 상속</p><p></p><p>8p : push함수 재정의로 용량제한 해결</p><p></p><p>9p : 실행결과를 통해 용량제한 및 generic programming 구현</p>|||
|<p></p><p></p><p></p><p>ParaStack 구현?</p><p>\* parameterized coding</p><p>\* type-safe 작업</p><p></p><p>-실험으로 검증?</p><p>\* parameterizing</p><p>\* type-safety</p><p></p><p></p><p></p>|<p>10~11p : parameterized type추가 및 명시적 캐스팅을 통한 type-safe 작업</p><p></p><p>12~13p : 실행결과 지정된 type으로만 데이터 추가 가능</p><p></p><p></p>|||
|기타|<p></p><p>스택에 추가한 문자열과 실수에 본인의 이름과 학번을 적어 본인 인증</p><p></p>|||
|총평/계|<p></p><p>과제의 요구사항을 최대한 준수하고자 노력하였음</p><p></p>|||

` `PAGE 3

