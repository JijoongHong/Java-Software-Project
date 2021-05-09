# **프로젝트 4 – Generic Stack**





## **목 차**

## **1. Generic Stack with limited capacity**

### **1) 클래스 분석**

### **2) 실행 결과**

## **2. Generic Stack with unlimited capacity**

### **1) Overriding 및 재정의**

### **2) 실행 결과**

## **3. Parameterized Generic Stack with unlimited capacity**

### **1) 구현 사항**

### **2) 실행 결과**





# **1. Generic Stack with limited capacity**

## **1) 클래스 분석**

- UML Class
- 정적스택인 GenericStackLimitedCapacity의 UML 클래스는 다음과 같다.

  |<p>**<Class name>**</p><p>GenericStackLimitedCapacity</p>|
  | :- |
  |<p>**<Data field>**</p><p>- top: int</p><p>- INIT\_CAPACITY: int{readOnly}</p><p>- list: Object[]</p>|
  |<p>**<Constructors>**</p><p>+ GenericStackLimitedCapacity ( )</p><p>+ GenericStackLimitedCapacity (capacity: int)</p><p></p><p>**<Methods>**</p><p>+ isEmpty( ) : boolean</p><p>+ pop( ) : Object</p><p>+ push(o : Object) </p><p>+ toString( ) : String </p>|












- 데이터 


  ![image](https://user-images.githubusercontent.com/63644587/117577161-9cf1dc00-b123-11eb-8dc8-34240838cdc7.png)


  - Private int top : Stack의 가장 최근 데이터 위치를 표시해주는 변수로서, Stack이 처음 생성되는 경우 데이터가 없기 때문에 -1로 지정한다.
  - Private final int INIT\_CAPACITY : 따로 크기를 지정해주지 않을 경우 상수 2를 두어 이를 스택의 크기로 정한다.
  - Private Object[] list : 스택의 데이터가 삽입되는 배열으로, type이 최상위 객체인 Object 객체로 지정되어 어떠한 데이터도 삽입이 가능하다.



- 생성자

  ![image](https://user-images.githubusercontent.com/63644587/117577177-a713da80-b123-11eb-8fc4-4beee0e8a01a.png)


  - GenericStackLimitedCapcity()
    - No-arg 생성자로서 상수값인 2크기의 Object 배열을 생성한다.
    - 더불어 이 생성자는 추후 상속 후 sub class 생성 시 super()가 자동으로 호출되므로 이에 대비하여 생성하는 것이 좋다. 
  - GenericStackLimitedCapcity(int capacity)
    - 정수값의 capacity를 인자로 받아 해당 크기 만큼 Object 배열을 생성한다.

- 메소드 
  - public boolean isEmpty()

    ![image](https://user-images.githubusercontent.com/63644587/117577189-b6932380-b123-11eb-9a20-4b8cb6404c0e.png)

    - 스택이 비었는지 확인하는 메소드이다.
    - 스택이 비었다면 top 변수의 값은 -1이 된다. 그러므로 top이 음수인지 여부를 반환하도록 한다.

  - public Object pop()

    ![image](https://user-images.githubusercontent.com/63644587/117577197-beeb5e80-b123-11eb-9108-342d2f81de1c.png)

    - 배열 내에 데이터가 존재한다면 list[top]을 반환하고, 가장 최근 데이터를 가리키는 top변수를 줄인다.
    - 만약 존재하지 않는 경우 null값을 반환한다.

  - public void push(Object o)

    ![image](https://user-images.githubusercontent.com/63644587/117577222-e3dfd180-b123-11eb-9373-b26bdc1220e4.png)

    - 데이터를 추가하는 메소드로서, top변수를 increment한 후 해당 인덱스에 인자로 받은 Object o를 대입한다.

  - public String toString()  

    ![image](https://user-images.githubusercontent.com/63644587/117577225-e93d1c00-b123-11eb-9184-00333d22b603.png)


    - Object class의 toString()메소드를 override하여 재정의한 것으로, 스택 내의 데이터를 하나의 문자열로 만들어 반환한다.
    - 과제의 목적인 generic programming과 동적 바인딩을 잘 보여주고, 다른 스택과의 비교를 용이하도록 하기위하여 해당 클래스의 이름을 출력하고, 내부의 데이터는 배열 선언 시와 비슷한 모습으로 출력하도록 변경하였다.

## **2) 실행 결과**

- TestMain 클래스에서는 정적스택에 대해 다음 항목을 실험한다.
  - 주어진 용량을 넘어서 데이터를 추가할 수 있는가?
  - 생성자의 인자로 capacity를 받아 해당 크기 만큼의 배열을 생성하는가?
  - 어떠한 객체든 스택의 데이터로 사용할 수 있는가?
  - 이를 위하여 두 개의 정적 스택을 생성하였다.

    ![image](https://user-images.githubusercontent.com/63644587/117577249-01ad3680-b124-11eb-9568-64c386482322.png)


  - 동적 바인딩을 확인하기 위하여 printStack 메소드는 스택 인스턴스를 인자로 받아 toString을 호출하고, 반환받은 문자열을 출력하도록 해 generic programming을 구현하였다.

    ![image](https://user-images.githubusercontent.com/63644587/117577256-070a8100-b124-11eb-8106-c3f81f4b3bd0.png)


- 주어진 용량을 넘어서서 데이터를 추가할 수 있는지 확인한다.
  - 이를 위해 다음과 같은 코드를 실행한다. 

    ![image](https://user-images.githubusercontent.com/63644587/117577263-138ed980-b124-11eb-95ef-a370c85fa4f0.png)


    - s1 인스턴스는 생성자의 인자 없이 생성되었으므로 최대 용량은 2이다. 그러나 삽입하려는 데이터는 3개 이므로 오류가 발생하여야 한다.


  - 실행 결과 ArrayIndexOuntOfBoundsException이 발생하였다.


    ![image](https://user-images.githubusercontent.com/63644587/117577284-21445f00-b124-11eb-83d7-ad53766a217f.png)


- 생성자의 인자로 capacity를 받아 해당 크기 만큼의 배열을 생성하고, 모든 객체를 스택의 데이터로 사용할 수 있는지 확인한다.
  - 이를 위해 다음과 같은 코드를 실행한다

    ![image](https://user-images.githubusercontent.com/63644587/117577296-2a353080-b124-11eb-9286-fcff5db0d0e5.png)


    - 생성자 인자를 4로 하여 새로운 인스턴스를 생성한다.
    - isEmpty 메소드의 동작을 확인하기 위해 데이터 삽입 전, 후에 이를 실행한다.
    - Push와 pop 메소드 동작을 확인하기 위해 1을 삽입 후 삭제한다.
    - 정수, 문자열, 실수를 담은 동일 클래스의 인스턴스 참조변수, 배열의 참조변수 총 4개의 데이터를 삽입한다. 이를 통해 모든 객체를 데이터로 사용할 수 있는지 확인한다.

  - 실행결과
      
    ![image](https://user-images.githubusercontent.com/63644587/117577308-34572f00-b124-11eb-9052-a1bcd4d5529c.png)

    - True/false 값을 통해 isEmpty 메소드가 잘 작동한 것을 볼 수 있다.
    - 스택의 데이터 값에 1이 없으므로 Push와 pop 메소드가 잘 작동한 것을 볼 수 있다.
    - 4개의 데이터가 문제 없이 삽입되었으므로 스택의 크기를 인자로 받아 설정할 수 있다.
    - 삽입한 모든 데이터의 type이 다르다. 이는 Object class는 모든 객체의 super class이기 때문이다. 




# **2. Generic Stack with unlimited capacity**

GenericStack 클래스는 정적스택을 상속받아 동적스택으로 확장한다.

## **1) Overriding 및 재정의**

- super class의 데이터를 protected로 변경
  
  ![image](https://user-images.githubusercontent.com/63644587/117577323-4c2eb300-b124-11eb-95aa-6e4736c71a95.png)


  - 상속을 통해 데이터에 접근하려면 super class의 데이터가 visiable 및 accessible 해야 한다.
  - 그러나 기존처럼 Private인 경우에는 이에 접근할 수 없다. 그러므로 subclass에서 접근이 가능하도록 protected로 데이터 필드의 속성을 재정의한다.

- 클래스 선언 

  ![image](https://user-images.githubusercontent.com/63644587/117577328-518bfd80-b124-11eb-9cfc-8ea75977d394.png)


    - GenericStack 클래스는 GenericStackLimitedCapacity를 상속한다.
    - 즉, super class를 확장하여 보다 상세한 구현을 하는 것이 목적이다.

- constructor

  ![image](https://user-images.githubusercontent.com/63644587/117577338-5a7ccf00-b124-11eb-939d-2a815074f747.png)


    - GenericStack을 생성 시 super 클래스의 인스턴스를 우선 생성한 후 인스턴스를 생성한다.
    - No-arg 생성자 호출 시 2크기 만큼의 배열이 생성되고, capacity를 인자로 받으면 해당 크기 만큼의 배열이 생성된다.

- push

  ![image](https://user-images.githubusercontent.com/63644587/117577348-610b4680-b124-11eb-9764-f07badb660d0.png)


  - 데이터를 추가하는 메소드로서, top변수를 increment한 후 해당 인덱스에 인자로 받은 Object o를 대입한다.
  - 데이터 추가 시 배열이 꽉 찬 상태라면, 배열의 용량을 2배로 늘려준다.
  - 이를 위해 기존 크기의 2배 배열을 생성한 후, 해당 배열에 기존 데이터를 copy한다. 
  - 이후 기존 배열이 새로운 배열을 가리키도록 한다.

- toString

  ![image](https://user-images.githubusercontent.com/63644587/117577363-6ec0cc00-b124-11eb-9e6d-3d8bb5f35824.png)


  - super class의 toString()메소드를 override하여 재정의한 것으로, 스택 내의 데이터를 하나의 문자열로 만들어 반환하는 것은 동일하다.
  - 그러나 이름을 현재 클래스 이름으로 변경하는 작업을 추가하여 override 작업을 수행했다.


- 이외의 사항은 super클래스와 동일한 데이터로 동일한 작업을 수행하므로 추가적인 override를 진행하지 않는다.


## **2) 실행 결과**

- TestMain 클래스에서는 동적스택에 대해 다음 항목을 실험한다.
  - 주어진 용량을 넘어서 데이터를 추가할 수 있는가?
  - 어떠한 객체든 스택의 데이터로 사용할 수 있는가?
  - 메소드의 동적 바인딩이 작동하는가?
  - 이를 위하여 두 개의 동적 스택을 생성하였다.

    ![image](https://user-images.githubusercontent.com/63644587/117577374-7b452480-b124-11eb-9bd6-fbb3bf8d688f.png) 


  - 동적 바인딩을 확인하기 위하여 printStack 메소드는 스택 인스턴스를 인자로 받아 toString을 호출하고, 반환받은 문자열을 출력하도록 해 generic programming을 구현하였다.

    ![image](https://user-images.githubusercontent.com/63644587/117577383-8304c900-b124-11eb-9e9b-abbc60ac8aeb.png)


- 이를 위해 다음과 같은 코드를 실행한다.


  ![image](https://user-images.githubusercontent.com/63644587/117577387-88621380-b124-11eb-9f9b-5cd1c4902611.png)


  - No-arg 생성자를 통해 새로운 인스턴스를 생성한다. 이 때 배열의 크기는 2이다.
  - isEmpty 메소드의 동작을 확인하기 위해 데이터 삽입 전, 후에 이를 실행한다.
  - Push와 pop 메소드 동작을 확인하기 위해 1을 삽입 후 삭제한다.
  - 정수, 문자열, 실수를 담은 동일 클래스의 인스턴스 참조변수, 총 3개의 데이터를 삽입한다. 이를 통해 배열의 크기가 조정되고, 모든 객체를 데이터로 사용할 수 있는지 확인한다.

- 실행 결과 

  ![image](https://user-images.githubusercontent.com/63644587/117577407-9fa10100-b124-11eb-9313-7396aefa0e7c.png)


  - True/false 값을 통해 isEmpty 메소드가 잘 작동한 것을 볼 수 있다.
  - 스택의 데이터 값에 1이 없으므로 Push와 pop 메소드가 잘 작동한 것을 볼 수 있다.
  - 3개의 데이터가 문제 없이 삽입되었으므로 동적으로 스택의 크기를 설정할 수 있다.
  - 삽입한 모든 데이터의 type이 다르다. 이는 Object class는 모든 객체의 super class이기 때문이다. 
  - 스택의 이름이 super 클래스의 이름이 아니라 GenericStack으로 출력되었다. 이를 통해 다형성과 동적 바인딩을 통한 generic programming을 확인 할 수 있다.

# **3. Parameterized Generic Stack with unlimited capacity**

ParaStack은 동적스택에 type을 인자로 받아 type-safe를 구현한 스택이다.

## **1) 구현 사항**

- 클래스 선언 
  
  ![image](https://user-images.githubusercontent.com/63644587/117577423-adef1d00-b124-11eb-88e7-3ebedd9a22d1.png)


  - 클래스 선언과 더불어 Parameterized Type을 추가하여 type을 인자로 받도록 한다.

- 변수

  ![image](https://user-images.githubusercontent.com/63644587/117577431-b6475800-b124-11eb-855b-c58a3c927ae6.png)


  - 데이터 필드는 기존의 스택과 동일하다.
  - List의 type을 Object로 선언하여 generic programming이 가능하도록 한다.

- 생성자

  ![image](https://user-images.githubusercontent.com/63644587/117577435-bfd0c000-b124-11eb-9206-77db0c3132c7.png)

  - 생성자는 기존의 스택과 같이 no-arg 생성자로 초기 배열값을 고정하거나, capacity를 인자로 받아 해당 크기의 배열을 선언한다.
  - 생성된 배열에 인자로 받은 type으로 명시적 캐스팅을 진행한다. 이 때 unchecked cast 컴파일 경고가 나오게 되는데 run time에서 동적으로 type이 결정되기 때문에 compile time에서 안정성을 보장할 수 없음을 의미한다. 그러나 이번 과제에서는 의도적으로 형안정성을 위배하거나 유지하므로 추가적인 조치를 하지 않는다.

- Public boolean isEmpty()

  ![image](https://user-images.githubusercontent.com/63644587/117577445-c65f3780-b124-11eb-8e6c-95917eb031f6.png) 
  
  - 이전과 동일하게, 스택이 비었는지 확인하는 메소드이다.
  - 스택이 비었다면 top 변수의 값은 -1이 된다. 그러므로 top의 음수 여부를 반환하도록 한다.


- Public E pop()

  ![image](https://user-images.githubusercontent.com/63644587/117577458-cfe89f80-b124-11eb-8d9a-ec4eb46ac229.png)


  - 배열 내에 데이터가 존재한다면 list[top]을 반환하고, 가장 최근 데이터를 가리키는 top변수를 줄인다. 만약 존재하지 않는 경우 null값을 반환한다.
  - 반환값을 type변수로 지정하고, 실행 전 list는 Object형이므로 명시적 캐스팅을 진행한다.

- Public void push(E o)
  
  ![image](https://user-images.githubusercontent.com/63644587/117577469-d9720780-b124-11eb-8dff-d17d609eff9d.png)

  - 이전과 동일하게 인자로 받은 데이터를 배열에 추가한다. 이 때 배열이 포화상태라면 배열의 크기를 2배로 증가시킨다.
  - 이 때도 미지정된 type의 데이터를 인자로 받도록하며, 새로운 배열 생성 시 명시적 캐스팅을 진행한다.


- Public String toString

  ![image](https://user-images.githubusercontent.com/63644587/117577485-e7278d00-b124-11eb-9c10-6df771d66087.png)


  - Object class의 toString()메소드를 override하여 재정의한 것으로, 스택 내의 데이터를 하나의 문자열로 만들어 반환한다.



**2) 실행 결과**

- TestMain 클래스에서는 type-safe한 동적스택에 대해 다음 항목을 실험한다.
  - 지정한 type외에 다른 데이터를 스택에 추가할 수 있는가?
  - 어떠한 객체든 스택의 데이터로 사용할 수 있는가?
  - 이를 위하여 String과 Double로 type을 지정한 두 개의 동적 스택을 생성하였다.

    ![image](https://user-images.githubusercontent.com/63644587/117577499-f3abe580-b124-11eb-9052-baf0a858a35a.png)

  - 동적 바인딩을 확인하기 위하여 printStack 메소드는 스택 인스턴스를 인자로 받아 toString을 호출하고, 반환받은 문자열을 출력하도록 해 generic programming을 구현하였다.

    ![image](https://user-images.githubusercontent.com/63644587/117577516-0e7e5a00-b125-11eb-9a1d-1d8af39b9846.png)


- 지정한 type외에 다른 데이터를 스택에 추가할 수 있는지 확인
  - 이를 위해 다음 코드를 실행한다. 

    ![image](https://user-images.githubusercontent.com/63644587/117577527-18a05880-b125-11eb-8eda-3a76dbcebc14.png)


    - String 형으로 type이 결정된 스택에 정수, 문자열, 실수를 담은 Double형 스택의 인스턴스 참조변수, 총 4개의 데이터를 삽입한다. 이를 통해 지정 type외에 데이터가 추가되는지 확인한다.

  - 실행 결과 

    ![image](https://user-images.githubusercontent.com/63644587/117577535-20f89380-b125-11eb-99ff-007ec1c98da8.png)


    - 지정 type외에 데이터가 추가되지 않음을 확인할 수 있다.

- 어떠한 객체든 스택의 데이터로 사용할 수 있는지 확인
  - 이를 위해 다음과 같은 코드를 실행하여 지정 type의 데이터만을 push한다.


    ![image](https://user-images.githubusercontent.com/63644587/117577542-2eae1900-b125-11eb-8059-56cb34ceabae.png) ![image](https://user-images.githubusercontent.com/63644587/117577546-31a90980-b125-11eb-9163-bc5ac65fe6ad.png)

  - 실행 결과 

    ![image](https://user-images.githubusercontent.com/63644587/117577559-3cfc3500-b125-11eb-98f9-34720d5fa5e0.png)

    ![image](https://user-images.githubusercontent.com/63644587/117577562-408fbc00-b125-11eb-827f-a49a194f984c.png)

    - 지정 type의 데이터가 정상적으로 추가되었음을 확인할 수 있다.


- 기능에 대한 평가

  Inheritence : 공통된 특징을 가진 클래스를 상속하여 중복을 피하고, 고유한 속성은 추가하거나 오버라이딩하여 손쉽게 변경 및 확장(구체화)가 가능하다.

  Generic : 가상의 형을 만들어 일반화된 메소드 작성이 가능하고, 이에 어떤 인자가 와도 사용이 가능하다.  

  Type-safe : Generic 사용 시 특정 상황에서 다른 타입의 인자가 처리되는 것을 미연에 방지할 수 있다. Runtime에서 type으로 인해 문제가 발생하는 것을 방지하고, compile time에서 문제를 인식한다.
